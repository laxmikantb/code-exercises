package com.lax.codeexercise;

/*
 * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time complexity - O(W*total items)
 * 
 */
public class KnapSack {

	public static void main(String[] args) {
		KnapSack knapsack = new KnapSack();
        int val[] = {22, 20, 15, 21, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int r = knapsack.solve(val, wt, 30);
        System.out.println("Max value " + r);

	}
	
	public int solve(int[] val, int[] wt, int W) {
		int[][] k = new int[val.length+1][W+1];
		
		for (int i=0; i <= val.length; i++) {
			for (int j=0; j<= W; j++) {
                if(i == 0 || j == 0){
                    k[i][j] = 0;
                    continue;
                }
                if (j - wt[i-1] >= 0) { 
                	k[i][j] = Math.max(k[i-1][j], val[i-1] + k[i-1][j-wt[i-1]]);
                }
                else
                	k[i][j] = k[i-1][j]; // without current weight as capacity is reached
			}
			
		}
		return k[val.length][W];
	}

}
