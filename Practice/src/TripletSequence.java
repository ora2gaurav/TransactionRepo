import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSequence {
public static void main(String[] args) {
	
	List<Integer> baseArr=new ArrayList<>(Arrays.asList(4, 3, 2, 1));
	int min=baseArr.size()-1 ,min2=baseArr.size()-1,min3=Integer.MAX_VALUE;
	for(int i=0;i<baseArr.size();i++) {
		if(i<min2&&baseArr.get(i)<baseArr.get(min)) {
			min=i;
		}
		else if(baseArr.get(i)<baseArr.get(min2)&& baseArr.get(i)>baseArr.get(min) ) {
		min2=i;
		}
		if(baseArr.get(i)>baseArr.get(min) && baseArr.get(i)>baseArr.get(min2) && i>min&&i>min2) {
			System.out.println((baseArr.get(i)+" "+baseArr.get(min2)+" "+baseArr.get(min)));
			break;
		}
	}
}
}
