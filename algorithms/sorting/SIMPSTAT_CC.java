package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 	Link: https://www.codechef.com/problems/SIMPSTAT
 * 	Sergey has made N measurements. Now, he wants to know the average value of the 
 * 	measurements made.

	In order to make the average value a better representative of the measurements, 
	before calculating the average, he wants first to remove the highest K and the lowest 
	K measurements. After that, he will calculate the average value among the remaining 
	N - 2K measurements.

	Could you help Sergey to find the average value he will get after these manipulations?

	Input
	The first line of the input contains an integer T denoting the number of test cases. 
	The description of T test cases follows.
	
	The first line of each test case contains two space-separated integers N and K denoting 
	the number of measurements and the number of the greatest and the lowest values that 
	will be removed.
	
	The second line contains N space-separated integers A1, A2, ..., AN denoting the measurements.

	Output
	For each test case, output a single line containing the average value after removing 
	K lowest and K greatest measurements.

	Your answer will be considered correct, in case it has absolute or relative error, 
	not exceeding 10-6.

	Constraints
	1 ≤ T ≤ 100
	1 ≤ N ≤ 104
	0 ≤ 2K < N
	-106 ≤ Ai ≤ 106
	
	Subtasks
	Subtask #1 (50 points): K = 0
	Subtask #2 (50 points): no additional constraints
	Example
	Input:
	3
	5 1
	2 9 -10 25 1
	5 0
	2 9 -10 25 1
	3 1
	1 1 1

	Output:
	4.000000
	5.400000
	1.000000
 */
public class SIMPSTAT_CC {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);

			int[] arr1 = new int[n];
			input = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(input[i]);
			}
			if (k != 0) {
				Arrays.sort(arr1);
			}
			int start = 0;
			int end = n - 1;
			start += k;
			end -= k;
			double sum = 0d;
			for (int i = start; i <= end; i++) {
				sum += arr1[i];
			}
			double avg = sum / (end - start + 1);
			System.out.println(avg);
		}
	}
}
