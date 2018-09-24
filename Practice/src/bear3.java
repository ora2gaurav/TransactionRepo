import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class bear3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Long> tailLength = new ArrayList<>();
		List<Long> tlength = new ArrayList<>();
		List<Long> headTime = new ArrayList<>();
		
		Set<Long> setOfUniqueTime = new HashSet<>();
		for (int i = 0; i < N; i++) {
			Long tail = sc.nextLong();
			tlength.add(tail);
		}
		for (int i = 0; i < N; i++) {
			Long head = sc.nextLong();
			headTime.add(head);
			tailLength.add(tlength.get(i)+head);
			setOfUniqueTime.add(head);
			setOfUniqueTime.add(tailLength.get(i));
		}
		tlength.clear();
		List<Long> listOfUniqueTime=new ArrayList<Long>(setOfUniqueTime);
		int maxsum=0;
		for(int i=0;i<setOfUniqueTime.size();i++) {
			int sum=fetchCount1st(listOfUniqueTime.get(i),headTime,tailLength);
			if(sum==N||maxsum==N) {
				maxsum=N;
				break;
			}
			for(int j=i+1;j<setOfUniqueTime.size();j++) {
				int Sum2nd=fetchCount2nd(listOfUniqueTime.get(i), headTime, tailLength, listOfUniqueTime.get(j));
				if(sum+Sum2nd>maxsum) {
					maxsum=sum+Sum2nd;
				}
			}
		}
		
		
		
		
		System.out.println(maxsum>N?N:maxsum);
		

	}

	private static Integer fetchCount1st(Long long1, List<Long> headTime, List<Long> tailLength) {
		int count=0;
		for (int i = 0; i < headTime.size(); i++) {
			if (long1 >= headTime.get(i) && long1 <= (tailLength.get(i))) {
				count++;
			}
		}
		return count;
	}
	
	private static Integer fetchCount2nd(Long long1, List<Long> headTime, List<Long> tailLength,Long long2) {
		int count=0;
		for (int i = 0; i < headTime.size(); i++) {
			if (long1 >= headTime.get(i) && long1 <= (tailLength.get(i))) {
				
			}
			else if(long2 >= headTime.get(i) && long2 <= (tailLength.get(i))) {
				count++;
			}
		}
		return count;
	}
	
	

	
}
