import java.math.BigInteger;

public class bignumberhcl {
	
	public static void main(String[] args) {
	//	BigInteger big=new BigInteger();
		String str="";
		for(int i=1;i<500;i++) {
			str+=9+"";
		}
		BigInteger big=new BigInteger(str);
		System.out.println(big);
		System.out.println(big.add(new BigInteger("1"))+" ");
	}

}
