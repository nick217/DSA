package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 	Link: https://www.codechef.com/problems/GRID
 * 	Sherlock is stuck. There is a N X N grid in which some cells are empty (denoted by ‘.’), 
 * 	while some cells have rocks in them (denoted by ‘#’). Sherlock is on the South of the grid. 
 * 	He has to watch what is happening on the East of the grid. He can place a mirror at 45 degrees 
 * 	on an empty cell in the grid, so that he'll see what is happening on East side by reflection 
 * 	from the mirror.
 * 	But, if there's a rock in his line of sight, he won't be able to see what's happening on 
 * 	East side. For example, following image shows all possible cells in which he can place 
 * 	the mirror.
 * 
 * 	You have to tell Sherlock in how many possible cells he can place the mirror and see 
 * 	what's happening on East side.

	Input
	First line, T, the number of testcases. Each testcase will consist of N in one line. 
	Next N lines each contain N characters.

	Output
	For each testcase, print the number of possible options where mirror can be placed 
	to see on the East side.

	Constraints
	1 ≤ T ≤ 10
	1 ≤ N ≤ 1000
 */
public class GRID_CS {

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			char[][] input = new char[n][n];
			for (int i = 0; i < n; i++) {
				input[i] = br.readLine().toCharArray();
			}

			boolean[][] right = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				int j = n - 1;
				while (j >= 0 && input[i][j] == '.') {
					right[i][j] = true;
					j--;
				}
			}
			int count = 0;
			for (int j = 0; j < n; j++) {
				int i = n - 1;
				while (i >= 0 && input[i][j] == '.') {
					if (right[i][j]) {
						count++;
					}
					i--;
				}
			}
			System.out.println(count);
		}
	}

}
