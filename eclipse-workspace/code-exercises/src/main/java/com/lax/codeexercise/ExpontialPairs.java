package com.lax.codeexercise;

public class ExpontialPairs {

	// Given a set of numbers identify pairs such that a^b = b^a
	    public void exponentialPair(int[] a, int[] b) {
	        int aLength = a.length;
	        int bLength = b.length;
	        for (int i = 0; i < aLength; i++) {
	            for (int j = 0; j < bLength; j++) {
	                if (Math.pow(a[i], b[j]) == Math.pow(b[j], a[i])) {
	                    System.out.println(a[i] + " " + b[j]);
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	    	ExpontialPairs ep = new ExpontialPairs();
	        int[] a = {2, 4, 6};
	        int[] b = {4, 2};
	        ep.exponentialPair(a, b);

	    }
}
