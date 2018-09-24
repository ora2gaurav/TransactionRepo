package com.n26.Controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.n26.DTO.TransactionRequestDTO;
import com.n26.DTO.TransactionStatisticsDTO;
import com.n26.DTO.TransactionStoreDTO;

@Component
@Qualifier("transactionController")
public class TransactionController {

	@Autowired
	private ServletContext servletContext;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	private static final Long SECOND_LIMIT = 60000L;
	
	public static final long MILLIS_FOR_ONE_SECOND = 1000;

	private static final String RESPONSE_CODE_SUCCESS = "201";

	private static final String RESPONSE_CODE_OLDER_TX = "204";

	private static final String RESPONSE_CODE_FUTURE_TX = "422";

	private static final int SCALE = 2;

	public String insertTransactions(TransactionRequestDTO transactionRequestDTO, String dateTime)
			throws ParseException {
		
		String statusCode = StringUtils.EMPTY;
		TransactionStoreDTO tx = new TransactionStoreDTO();
		try {
			tx.setAmount(new BigDecimal(transactionRequestDTO.getAmount()));
			tx.setTimeStamp(formatter.parse(transactionRequestDTO.getTimeStamp()));
			long seconds = (formatter.parse(dateTime).getTime() - tx.getTimeStamp().getTime()) ;	

			
			if (seconds >= SECOND_LIMIT) {
				statusCode = RESPONSE_CODE_OLDER_TX;
			} else if (seconds < NumberUtils.LONG_ZERO) {
				statusCode = RESPONSE_CODE_FUTURE_TX;
			} else {
				Map<Date,TransactionStatisticsDTO> mapOfTransactions = this.fetchTransactionStorageMem();
				for(int i=0;i<60;i++) {
					Date requestDate=tx.getTimeStamp();
					requestDate=addSeconds(requestDate,i);
					TransactionStatisticsDTO stats=this.performOperation(mapOfTransactions.get(requestDate),tx);
					mapOfTransactions.put(requestDate, stats);
					
				}
				statusCode = RESPONSE_CODE_SUCCESS;
			}

		} catch (Exception e) {
			throw new ParseException("Exception while parsing" + e.getMessage(), 0);
		}
		return statusCode;

	}

	private TransactionStatisticsDTO performOperation( TransactionStatisticsDTO transactionStatisticsDTO,
			TransactionStoreDTO tx) {
		BigDecimal sum = null;
		BigDecimal avg = null;
		BigDecimal max = null;
		BigDecimal min = null;
		Long count =0L;
		if(transactionStatisticsDTO ==null) {
			sum=tx.getAmount();
			avg=tx.getAmount();
			max=tx.getAmount();
			min=tx.getAmount();
			count++;
			transactionStatisticsDTO=new TransactionStatisticsDTO();
		}
		else {
			sum=new BigDecimal(transactionStatisticsDTO.getSum()).add(tx.getAmount());
			max =  new BigDecimal(transactionStatisticsDTO.getMax()).max(tx.getAmount());
			min= new BigDecimal(transactionStatisticsDTO.getMin()).min(tx.getAmount());
			count=transactionStatisticsDTO.getCount()+1;
			avg=sum.divide(BigDecimal.valueOf(count), SCALE, BigDecimal.ROUND_HALF_UP);
			sum = sum.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
			max = max.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
			min = min.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
		
		}
		transactionStatisticsDTO.setAvg(avg == null ? "0.00" : String.valueOf(avg));
		transactionStatisticsDTO.setCount(count == null ? 0L : count);
		transactionStatisticsDTO.setMax(max == null ? "0.00" : String.valueOf(max));
		transactionStatisticsDTO.setMin(min == null ? "0.00" : String.valueOf(min));
		transactionStatisticsDTO.setSum(sum == null ? "0.00" : String.valueOf(sum));
		return transactionStatisticsDTO;
		
	}

	public String fetchCurrentTime() {
		Instant timestamp = Instant.now();
		String currentTime = DateTimeFormatter.ISO_INSTANT.format(timestamp);
		return currentTime;
	}

	public void deleteTransactions() {
		Map<Date,TransactionStatisticsDTO> mapOfTransactions = this.fetchTransactionStorageMem();
		mapOfTransactions.clear();
	}

	private Map<Date,TransactionStatisticsDTO> fetchTransactionStorageMem() {
		Map<Date,TransactionStatisticsDTO> mapOfTransactions = (Map<Date,TransactionStatisticsDTO>) servletContext
				.getAttribute("mapOfTransactions");
		if (mapOfTransactions == null) {
			mapOfTransactions = new ConcurrentHashMap<>();  // This will create new Object if it doesn't exists.
			servletContext.setAttribute("mapOfTransactions", mapOfTransactions);
		}
		return mapOfTransactions;
	}

	public TransactionStatisticsDTO fetchStatistics(String dateTime) throws ParseException {
		Date currentTime = formatter.parse(dateTime);
		TransactionStatisticsDTO result = new TransactionStatisticsDTO();
		BigDecimal sum = null;
		BigDecimal avg = null;
		BigDecimal max = null;
		BigDecimal min = null;
		Long count = 0L;
		Map<Date,TransactionStatisticsDTO> mapOfTransactions = this.fetchTransactionStorageMem();
		if(mapOfTransactions.containsKey(currentTime)) {
			result=mapOfTransactions.get(currentTime);//  O(1) retrieval 
		}else {
		result.setAvg("0.00");
		result.setCount(0L);
		result.setMax("0.00");
		result.setMin("0.00");
		result.setSum("0.00");
		}
		
		return result;

	}
	
	 public  Date addSeconds(Date date, Integer seconds) {
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(date);
		    cal.add(Calendar.SECOND, seconds);
		    return cal.getTime();
		  }
	 /**
	     * this is a scheduled job which runs every second to clean/prune transactions which are older than 60 seconds
	     * from the current time. This is a async task which runs in a separate thread.
	  */
	 @Async
	 @Scheduled(fixedDelay = MILLIS_FOR_ONE_SECOND, initialDelay = MILLIS_FOR_ONE_SECOND)
	  public void cleanOldStatsPerSecond() throws ParseException {
		 Map<Date,TransactionStatisticsDTO> mapOfTransaction=this.fetchTransactionStorageMem();
		 Date requestDate=addSeconds(formatter.parse(fetchCurrentTime()),-60);//clearing in memory storage
		 mapOfTransaction.remove(requestDate);//clearing
		 
	 }
}
