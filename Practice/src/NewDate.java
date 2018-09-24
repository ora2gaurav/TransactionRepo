import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewDate {
	
	
	public static void main(String[] args) throws ParseException {
		String dateFormat = "yyyy-MM-dd";
		Date date= new SimpleDateFormat(dateFormat).parse("2017-01-11");
		
		
		try {
			Date postDate = new SimpleDateFormat(dateFormat).parse(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			 

		
	}

}
