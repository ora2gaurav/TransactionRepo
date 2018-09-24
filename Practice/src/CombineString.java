import java.util.ArrayList;
import java.util.List;

public class CombineString {
	
	public static void main(String[] args) {
		List<String> arr=new ArrayList<>();
		arr.add("RRBBR");
		arr.add("RRBBR");
		arr.add("RBRRBRBRBRB");
		arr.add("BBRBBR");
		arr.add("BRR");
		arr.add("BRRRRBB");
		int RR=0;int BB=0;List<Integer> BR=new ArrayList<>();
		List<Integer> RB=new ArrayList<>();
		for(String str:arr) {
			if(str.charAt(0)=='R'&&str.charAt(str.length()-1)=='R') {
				RR+=str.length();
			}
			else if(str.charAt(0)=='B'&&str.charAt(str.length()-1)=='B') {
				BB+=str.length();
			}
			else if(str.charAt(0)=='R'&&str.charAt(str.length()-1)=='B') {
				RB.add(str.length());
			}
			else if(str.charAt(0)=='B'&&str.charAt(str.length()-1)=='R') {
				BR.add(str.length());
			}
		}
		if(BR.size()==0 && RB.size()==0) {
			System.out.println(Integer.max(RR, BB));
		}
		else if(BR.size()>0 && RB.size()==0) {
			int len=0;
			if(BB!=0) {
			len=findMax(BR);}
		System.out.println(BB+len+RR);
		}
		else if(RB.size()>0 && BR.size()==0) {
			int len=0;
			if(RR!=0) {
			len=findMax(RB);}
		System.out.println(BB+len+RR);
		}
		else {
			System.out.println(BB+RR+fetchBRRBLen(BR, RB));
		}
		}

	private static int findMax(List<Integer> bR) {
		int len=Integer.MIN_VALUE;
		for(Integer a: bR) {
			len=len<a?a:len;
		}
		return len;
	}
	private static int fetchBRRBLen(List<Integer> bR,List<Integer> rB) {
		int minLenseg=0;
		if(bR.size()==rB.size()) {
			for(Integer in:bR)
			{
					minLenseg+=in;
			}
			for(Integer in:rB)
			{
					minLenseg+=in;
			}
		}
		else {
		int min=bR.size()>rB.size()?rB.size():bR.size();
		List<Integer> minLenList=bR.size()<=rB.size()?rB:bR;
		List<Integer> manLenList=bR.size()>=rB.size()?rB:bR;
		
		while(min>0) {
			Integer max=minLenList.get(0);
			int maxi=0;
			for(Integer i=1;i<minLenList.size();i++) {
				
				if(max<minLenList.get(i)) {
				max=minLenList.get(i);
				maxi=i;
				}
			}
			minLenList.remove(maxi);
			minLenseg+=max;
			min--;
		}
		for(Integer in:manLenList)
	{
			minLenseg+=in;
	}
		}return minLenseg;
	}	
	}


