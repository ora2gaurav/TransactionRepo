import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BearCD1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Long> tailLength = new ArrayList<>();
		List<Long> length = new ArrayList<>();
		List<Long> headTime = new ArrayList<>();
		
		Set<Long> setOfUniqueTime = new HashSet<>();
		for (int i = 0; i < N; i++) {
			Long tail = sc.nextLong();
			tailLength.add(tail);
		}
		for (int i = 0; i < N; i++) {
			Long head = sc.nextLong();
			headTime.add(head);
			setOfUniqueTime.add(head);
			setOfUniqueTime.add(tailLength.get(i)+head);
		}

		Map<Long, Integer> countOfElements = new HashMap<>();
		fetchCountOfMehtod(N, tailLength, headTime,setOfUniqueTime, countOfElements);
		List<Long> highestTime = findHighestCountElements(countOfElements);
		int maxsum=0;
		for(Long time:highestTime) {
		int sum=0;
			if (countOfElements.get(time) == N) {
				maxsum=N;
				break;
			} else {
				 sum = countOfElements.get(time);
				sum += removeListOfElements(time, tailLength, headTime, N);
			}
			if(sum>maxsum) {
				maxsum=sum;
			}
		}
		System.out.println(maxsum);
		

	}

	private static void fetchCountOfMehtod(int N, List<Long> tailLength, List<Long> headTime, Set<Long> setOfUniqueTime,
			Map<Long, Integer> countOfElements) {
		for (Long Time : setOfUniqueTime) {
			for (int i = 0; i < N; i++) {
				if (Time >= headTime.get(i) && Time <= (headTime.get(i)+tailLength.get(i))) {
					if (countOfElements.containsKey(Time)) {
						countOfElements.put(Time, countOfElements.get(Time) + 1);
					} else {
						countOfElements.put(Time, 1);
					}
				}
			}

		}
	}

	private static Integer removeListOfElements(Long Time, List<Long> tailLength, List<Long> headTime,
			  int n) {
		Set<Long> setOfUniqueTime=new HashSet<>();
		Map<Long, Integer> countOfElements2=new HashMap<>();
		 List<Long>  secondtailLength=new ArrayList<>();
		 List<Long>  secondheadLength=new ArrayList<>();
		 
		for (int i = 0; i < n; i++) {
			if (Time >= headTime.get(i) && Time <= (headTime.get(i)+tailLength.get(i))) {
				
			} 
			else {
				secondtailLength.add(tailLength.get(i));
				secondheadLength.add(headTime.get(i));
			}

		}
		
		for (int i = 0; i < secondheadLength.size(); i++) {
			setOfUniqueTime.add(secondheadLength.get(i)+secondtailLength.get(i));
			setOfUniqueTime.add(secondheadLength.get(i));
		}
		fetchCountOfMehtod(secondheadLength.size(), secondtailLength, secondheadLength, setOfUniqueTime, countOfElements2);
		
	List<Long> highestcnt= findHighestCountElements(countOfElements2);
	if(!highestcnt.isEmpty())
	return countOfElements2.get(highestcnt.get(0));
	else return 0;
	
		

	}

	private static List<Long> findHighestCountElements(Map<Long, Integer> countOfElements) {
		int highestcnt = 0;
		List<Long> highestTime = new ArrayList<>();
		
		for (Map.Entry<Long, Integer> entry : countOfElements.entrySet()) {
			if (entry.getValue() > highestcnt) {
				highestcnt = entry.getValue();
			}
		}
		for (Map.Entry<Long, Integer> entry : countOfElements.entrySet()) {
			if(entry.getValue() == highestcnt) {
				highestTime.add(entry.getKey());
			}
		}
		
		return highestTime;
	}
}
