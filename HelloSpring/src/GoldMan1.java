import java.util.HashMap;
import java.util.Map;


public class GoldMan1 {
	static int findDuplicates(String[][] matrix) {
			int r=matrix.length;
			int c=matrix[0].length;
			int ans=0;
			HashMap<String, Integer> freq=new HashMap<String, Integer>();
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					if(freq.containsKey(matrix[i][j])){
						int count=freq.get(matrix[i][j]);
						if(count==1)ans++;
						freq.put(matrix[i][j],++count);
					}else{
						freq.put(matrix[i][j],1);
					}
				}
			}
			return ans;
	}
}
