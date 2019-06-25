package com.lax.codeexercise;

/*
 * The nth term in the series is obtained by adding n to the previous term. Thus, the second term 
 * is found by adding 2 to the first term (which is 1), giving 3. The third term is 3 added to the 
 * second term (which is 3) giving 6, and so on. The numbers in this series are called triangular 
 * numbers because they can be visualized as a triangular arrangement of objects
 *  1,3,6,10,15... -> 2nd number = 1+2, 4th number = 1+2+3+4
 *  
 *  Use recursion
 */
public class TriangularNumber {

	public static void main(String[] args) {
		
		System.out.println(triangle(1));
		System.out.println(triangle(2));
		System.out.println(triangle(3));
		System.out.println(triangle(4));
		System.out.println(triangle(10));
		
	}
	
	public static int triangle(int n) {
		if (n <= 1)
			return n;
		return n + triangle(n-1);
	}
}
