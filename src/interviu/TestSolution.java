package interviu;

import java.util.*;

public class TestSolution {
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		String seats = "1A 1C 1E 2A 2C 2D 3F 3A 3G 1G 4F";
		//String seats = "1A 2F 1C";
		//int nr = 1;
		
		System.out.println(sol.solution(4, seats));
	}
}

class Solution {
	
	int solution(int nr, String S) {
		
		//char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
		
		//int count = nr * 3;
		int answer = 0;
		
		String[] seats = S.split(" "); 
		Arrays.sort(seats);
		List<ArrayList<String>> seats2 = new ArrayList<>();
		
		int j = 1;
		for (int i = 1; i < nr+1; i++) {
			seats2.add(new ArrayList<>());
			while(j < seats.length && Integer.valueOf(seats[j].substring(0, 1)) == i) {
				seats2.get(i-1).add(seats[j].substring(1));
				j++;
			}
		}
		
		System.out.println(seats2);
		
		for (ArrayList<String> arr : seats2) {
			String[] str = arr.toArray(new String[0]);
			answer += checkRow(str);
		}
		
		return answer;
	}
	
	private int checkRow(String[] str) {
		int count = 3;
		
		
		for(int j = 0; j < str.length; j++) {
			if (str[j].equals("A") ||
					str[j].equals("B") || 
					str[j].equals("C")) {
				count--;
				break;
			}
		}
		
		for(int j = 0; j < str.length; j++) {
			if (str[j].equals("H") ||
					str[j].equals("J") || 
					str[j].equals("K")) {
				count--;
				break;
			}
		}
		
		OUTER: for(int i = 0; i < str.length; i++) {
			if (str[i].equals("E") ||
					str[i].equals("F")) {
				count--;
				break;
			}
			if (str[i].equals("D")) {
				for (int j = i; j < str.length; j++) {
					if (str[j].equals("G")) {
						count--;
						break OUTER;
					}
				}
			}
		}
		
		
		
		return count;
	}

}

