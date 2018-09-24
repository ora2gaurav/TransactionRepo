
public class min {
	
	public static void main(String[] args) {
		int m=2;
		int n=2;
		System.out.println(findmin(m,n));
		System.out.println(dpsoln(m,n));
		
	}

	private static Integer findmin(int m, int n) {
	if(m<0||n<0) return 0;
		if(m==1||n==1) {
			return 1;
		}
		return findmin(m-1,n)+findmin(m,n-1)+findmin(m-1,n-1);
	} 
	
private static Integer dpsoln(int m,int n) {
	int [][] arr=new int [m][n];
	for(int i=0;i<m;i++) {
		arr[i][0]=1;
	}
	for(int j=0;j<m;j++) {
		arr[0][j]=1;
	}
	for(int i=1;i<m;i++) {
		for(int j=1;j<n;j++) {
			arr[i][j]=arr[i-1][j]+arr[i][j-1]+arr[i-1][j-1];
		}
	}
	
	return arr[m-1][n-1];
	
	
}
}
