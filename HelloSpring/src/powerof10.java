import java.util.HashMap;
import java.util.Scanner;

public class powerof10 {
public static void main(String[] args) {
	String ip="ss7.4.1.0";
	String []sta=ip.split("\\.");
	//System.out.println(sta);
	System.out.println(sta.length);
	if(sta.length==4)
	{ 
		for(String tew:sta)
		{  try{
			if(Integer.parseInt(tew)>=0 &&Integer.parseInt(tew)<=255 )
			{}
		else{System.out.println("NOT VALID");break;}
		} catch(Exception e){System.out.println("NOT VALID");break;}
		}
	}
	else{System.out.println("NOT VALID");}
	
			
	HashMap<String,Integer> hm=new HashMap<String,Integer>();
	hm.put("127.0.0.1", 0);
	hm.put("222.222.554.1", 0);
		
}
}
