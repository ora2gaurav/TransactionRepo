import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FIndMaxMovies {
	/*
	 * i/p
	 * 6
9:00
10:00
9:15
9:30
9:30
10:45
11:00
11:45
11:50
13:45
14:00
14:30
	 */
	 
	
	public static void main(String[] args) throws ParseException {
		List<Date> startTime=new ArrayList<Date>();
		List<Date> endTime=new ArrayList<Date>();
		int N=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("TIME FORMAT ++=> hh:mm \n Ex 15:30");
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		N=sc.nextInt();
		for(int i=0;i<N;i++) {
			String time = "15:30:18";
			//System.out.println("Start Time :");
			time=sc.next()+":00";
			
			startTime.add(sdf.parse(time));
		//	System.out.println("END Time :");
			time=sc.next()+":00";
			endTime.add(sdf.parse(time));
		}
				//sort both list on basis of start Time
		//can be done in o(nlogn) but to simplify code
		for(int i=0;i<startTime.size();i++) {
			for(int j=0;j<endTime.size();j++) {
				if(endTime.get(i).before(endTime.get(j))) {
					Date tempEnd=endTime.get(i);
					Date tempStart=startTime.get(i);
					endTime.set(i, endTime.get(j));
					startTime.set(i, startTime.get(j));
					endTime.set(j, tempEnd);
					startTime.set(j, tempStart);
				}
			}
		}
		int count =1;
		int prev=0;
		for(int i=1;i<startTime.size();i++) {
			if(startTime.get(i).after(endTime.get(prev))
					||sdf.format(startTime.get(i)).equals(sdf.format((endTime.get(prev)))))
			{	prev=i;
					count++;}
		}
		System.out.println("MAX MOVIES THAT CAN BE WATHCED=="+count +"    ENJOY");
		
		
	}


	

}
