package com.lax.codeexercise;

public class PascalTriangle {
	public static void printPascal(int n, int col) 
	{ 
	    for(int line = 1; line <= n; line++) 
	    { 
	          
	    int C=1;// used to represent C(line, i) 
	    for(int i = 1; i <= line; i++) 
	    {  
	        // The first value in a line is always 1 
	    	if (line == n && i == col)
	    		System.out.print(/* "line " + line + */" " + C+" "); 
	        C = C * (line - i) / i;  
	    } 
	    System.out.println(); 
	    } 
	} 
	  
	//Diver code 
	public static void main (String[] args) { 
	    int n = 5; 
	    int col = 2;
	    printPascal(n, col); 
	}  

}
