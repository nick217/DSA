package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * Link: https://practice.geeksforgeeks.org/problems/next-permutation/0
 * Implement the next permutation, which rearranges numbers into the numerically 
 * next greater permutation of numbers. If such arrangement is not possible, 
 * it must be rearranged as the lowest possible order ie, sorted in an ascending order.

	For example:
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3

	Input:
	The first line contains an integer T, depicting total number of test cases. 
	Then following T lines contains an integer N depicting the size of array and next line 
	followed by the value of array.

	Output:
	Print the array of next permutation in a separate line.
	
	Constraints:
	1 ≤ T ≤ 40
	1 ≤ N ≤ 100
	0 ≤ A[i] ≤ 100

	Example:
	Input:
	1
	6
	1 2 3 6 5 4

	Output:
	1 2 4 3 5 6
 */
class JNEXT_GFG {
	public static void main (String[] args) throws Exception{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    String params[] = br.readLine().split(" ");
		    int nums[] = new int[n];
		    for(int k = 0; k < n; k++){
		        nums[k] = Integer.parseInt(params[k]);
		    }
		    int i = n-1;
		    while(i!= 0 && nums[i] < nums[i-1]){
		        i--;
		    }
		    if(i == 0){
		        Arrays.sort(nums);
		    }
		    else{
		         int k = n-1;
		         while(nums[k] < nums[i-1]){
		             k--;
		         }
		         int temp = nums[k];
		         nums[k] = nums[i-1];
		         nums[i-1] = temp;
		         Arrays.sort(nums,i,n);
		    }
		    for(int k = 0; k < n; k++){
		        System.out.print(nums[k] + " ");
		    }
		    System.out.println();
		}
	}
}
