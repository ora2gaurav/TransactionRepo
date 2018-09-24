
public class minimuCoingreq {

	
	public static void main(String[] args) {
		int [] coins= {25,10,5};
		int V=30;
		int []lookUp=new int [V+1];
		lookUp[0]=0;
		for(int i=1;i<=V;i++) {
			lookUp[i]=Integer.MAX_VALUE;
		}
		for(int i=1;i<=V;i++) {
			for(int j=0;j<coins.length;j++) {
				if(i>=coins[j]) {
					int res=lookUp[i-coins[j]];
					if(res!=Integer.MAX_VALUE&&res+1<lookUp[i]) {
						lookUp[i]=res+1;
					}
					
				}
				
				
			}
			
			
			
			
		}
		System.out.println(lookUp[V]);
	}
	
	
}
