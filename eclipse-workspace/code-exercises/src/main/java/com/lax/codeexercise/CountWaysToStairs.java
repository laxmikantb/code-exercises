package com.lax.codeexercise;

public class CountWaysToStairs {

	public static void main(String[] args) {
		System.out.println(countWays(10));

	}
	
	public static int countWays(int steps) {
		if (steps < 0) return 1;
		if (steps <=1) return 1;
		int[] paths = new int[steps + 1];
		paths[0] = 1;
		paths[1] = 1;
		paths[2] = 2;
		
		for (int j=3; j <= steps; j++) {
			paths[j] = paths[j-1] + paths[j-2] + paths[j-3];
		}
		return paths[steps];
	}

}
