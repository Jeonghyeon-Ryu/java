package kakao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws ParseException {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

		String[] type = new String[terms.length];		
		int[] tDay = new int[terms.length];
		
		int[] pYear = new int[privacies.length];
		int[] pMonth = new int[privacies.length];
		int[] pDay = new int[privacies.length];
		
		
		int[] answer = {};
		List<Integer> temp = new ArrayList<>();
		
		for(int i=0; i<terms.length; i++) {
			type[i] = terms[i].split(" ")[0];
			tDay[i] = Integer.parseInt(terms[i].split(" ")[1]);
		}
		
		for(int i=0; i<privacies.length; i++) {
			pYear[i] = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[0]);
			pMonth[i] = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[1]);
			pDay[i] = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[2]);
			pYear[i] += pMonth[i]/12;
			pMonth[i] = pMonth[i]%12 + tDay[Arrays.asList(type).indexOf(privacies[i].split(" ")[1])];
			while(pMonth[i]>12) {
				pYear[i] += pMonth[i]/12;
				pMonth[i] = pMonth[i]%12;
			}
			System.out.println(pYear[i] + " : " + pMonth[i] + " : " + pDay[i]);
			
			
			if(Integer.parseInt(today.split("\\.")[0]) == pYear[i]) {
				if(Integer.parseInt(today.split("\\.")[1]) == pMonth[i]) {
					if(Integer.parseInt(today.split("\\.")[2]) >= pDay[i]) {
						temp.add(i+1);
					}
				} else if(Integer.parseInt(today.split("\\.")[1]) > pMonth[i]) {
					temp.add(i+1);
				}
			} else if (Integer.parseInt(today.split("\\.")[0]) > pYear[i]) {
				temp.add(i+1);
			}
		}
		int[] arr = temp.stream().mapToInt(i -> i).toArray();
		answer = arr;
//		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
