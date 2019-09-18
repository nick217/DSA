package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Link: https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
 * 	The cost of stock on each day is given in an array A[] of size N. 
 * 	Find all the days on which you buy and sell the stock so that in between those days 
 * 	your profit is maximum.

	Input: 
	First line contains number of test cases T. First line of each test case contains an 
	integer value N denoting the number of days, followed by an array of stock prices of N days. 

	Output:
	For each testcase, output all the days with profit in a single line. And if there is no 
	profit then print "No Profit".

	Constraints:
	1 <= T <= 100
	2 <= N <= 103
	0 <= Ai <= 104

	Example
	Input:
	2
	7
	100 180 260 310 40 535 695
	10
	23 13 25 29 33 19 34 45 65 67

	Output:
	(0 3) (4 6)
	(1 4) (5 9)

	Explanation:
	Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

	Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
	For each input, output should be in a single line.
 */
public class StockBuyAndSell {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String line = br.readLine(); // to read multiple integers line
			String[] strs = line.trim().split("\\s+");
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(strs[i]);
			}
			int b[] = new int[n / 2];
			int s[] = new int[n / 2];
			int k = -1;
			boolean flag = false;
			for (int i = 0; i < n; i++) {

				while ((i + 1) < n && a[i] > a[i + 1]) {
					i++;
				}
				if (i != n - 1) {
					k++;
					b[k] = i;
					flag = true;
				}
				while ((i + 1) < n && a[i] < a[i + 1]) {
					i++;
				}
				if (flag) {
					s[k] = i;
					flag = false;
				}
			}
			if (k == -1) {
				System.out.println("No Profit");
			} else {
				StringBuffer o = new StringBuffer();
				for (int i = 0; i <= k; i++) {
					o.append("(").append(b[i]).append(" ").append(s[i]).append(") ");
				}
				System.out.println(o);
			}

		}

	}
}
