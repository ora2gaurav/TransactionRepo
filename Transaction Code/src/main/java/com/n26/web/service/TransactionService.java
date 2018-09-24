package com.n26.web.service;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.Controller.TransactionController;
import com.n26.DTO.TransactionRequestDTO;
import com.n26.DTO.TransactionStatisticsDTO;

@RestController
@RequestMapping(value = "")
public class TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

	@Autowired
	@Qualifier("transactionController")
	private TransactionController transactionController;

	@RequestMapping(value = "/transactions", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Void> deleteTransactions() {
		this.transactionController.deleteTransactions();
		ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return response;

	}

	@RequestMapping(value = "/transactions", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> saveTransactions(@RequestBody TransactionRequestDTO transactionRequestDTO) {
		ResponseEntity<Void> response = null;
		try {
			String dateTime = transactionController.fetchCurrentTime();
			String status = transactionController.insertTransactions(transactionRequestDTO, dateTime);
			if (String.valueOf(HttpStatus.CREATED).equals(status)) {
				response = new ResponseEntity<>(HttpStatus.CREATED);
			} else if (String.valueOf(HttpStatus.NO_CONTENT).equals(status)) {
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else if (String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY).equals(status)) {
				response = new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
			}

		}

		catch (ParseException | HttpMessageNotReadableException e) {
			response = new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public TransactionStatisticsDTO fetchStatistics() throws ParseException {
		String dateTime = transactionController.fetchCurrentTime();
		return this.transactionController.fetchStatistics(dateTime);

	}
}
