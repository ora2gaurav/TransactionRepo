
public class GoldMan2 {
	public static void main(String args[]){
	/*	System.out.println(secureChannel(1, "ope","12345"));
		System.out.println(secureChannel(1, "open","12"));
		System.out.println(secureChannel(2, "oppeeened","10"));
		System.out.println(secureChannel(2, "opp","1234"));
		*/
		System.out.println(secureChannel(1, "opp","1234"));
		System.out.println(secureChannel(2, "oppeeened","10"));
		
		System.out.println(secureChannel(2, "abcdd","101"));
		//System.out.println(secureChannel(2, "ab","12"));
	}
	static String secureChannel(int operation, String message, String key) {
		if(message==null || message.length()==0)return "-1";
		if(key==null || key.length()==0)return message;
		switch(operation){
		case 1:	return encode(message,key);
		case 2: return decode(message,key);
		default:return "-1";
		}
	}

	private static String decode(String message, String key) {
		char[] m=message.toCharArray();
		char[] k=key.toCharArray();
		StringBuilder decoded=new StringBuilder();
		int j=0;
		for(int i=0;i<k.length;i++){
			int count=Integer.parseInt(""+k[i]);
			if(j>=m.length){
				break;
			}
			if(count==0){
				j++;
				continue;
			}
			if(j+count<=m.length){
			decoded.append(m[j]);
			}else{
				return "-1";
			}
			j+=count;
		}
		if(j<m.length){
			decoded.append(message.substring(j));
		}
		return decoded.toString();
	}

	private static String encode(String message, String key) {
		char[] m=message.toCharArray();
		char[] k=key.toCharArray();
		StringBuilder encoded=new StringBuilder();
		int i=0;
		try{
			for(i=0;i<Math.min(m.length,k.length);i++){
				int count=Integer.parseInt(""+k[i]);
				for(int j=0;j<count;j++){
					encoded.append(m[i]);
				}
			}
			if(i<m.length){
				encoded.append(message.substring(i));
			}
			return encoded.toString();
		}catch(NumberFormatException e){
			return "-1";
		}
	}
}
