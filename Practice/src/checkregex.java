
public class checkregex {
public static void main(String[] args) {
	String a="[\\u0021-\\u00FF ]*+";
	String b="^[a-zA-Z0-9]*$";
	if("??".matches(b)) {
		System.out.println("TRUE");
		
	}
			
}
}
