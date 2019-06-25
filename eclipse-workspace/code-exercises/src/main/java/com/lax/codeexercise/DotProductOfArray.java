package com.lax.codeexercise;

public class DotProductOfArray {

	static int n = 3;

	// Function that return
	// dot product of two vector array.
	static int dotProduct(int vect_A[], int vect_B[]) {
/*
 * 	A = 3 * i + 5 * j + 4 * k
	B = 2 * i + 7 * j + 5 * k
dot product = 3 * 2 + 5 * 7 + 4 * 5
            = 6 + 35 + 20
            = 61
 */
		int product = 0;

		// Loop for calculate cot product
		for (int i = 0; i < n; i++)
			product = product + vect_A[i] * vect_B[i];
		return product;
	}
	
    // Function to find 
    // cross product of two vector array. 
    static void crossProduct(int vect_A[], int vect_B[],  
                                           int cross_P[]) 
      
    { 
      /*
       * A = 3 * i + 5 * j + 4 * k
		 B = 2 * i + 7 * j + 5 * k
		cross product 
			= (5 * 5 - 4 * 7) * i 
      			+ (3 * 5 - 4 * 2) * j + (3 * 7 - 5 * 2) * k
			= -3 *i + 7 * j + 11 * k
       */
        cross_P[0] = vect_A[1] * vect_B[2]  
                    - vect_A[2] * vect_B[1]; 
        cross_P[1] = vect_A[0] * vect_B[2]  
                    - vect_A[2] * vect_B[0]; 
        cross_P[2] = vect_A[0] * vect_B[1]  
                    - vect_A[1] * vect_B[0]; 
    } 
	
    public static void main (String[] args)  
    { 
        int vect_A[] = { 3, -5, 4 }; 
        int vect_B[] = { 2, 6, 5 }; 
        int cross_P[] = new int [n]; 
      
        // dotProduct function call 
        System.out.print ( "Dot product:"); 
        System.out.println (dotProduct(vect_A, vect_B)) ; 
      
        // crossProduct function call 
        System.out.print ( "Cross product:"); 
        crossProduct(vect_A, vect_B, cross_P); 
      
        // Loop that print 
        // cross product of two vector array. 
        for (int i = 0; i < n; i++) 
      
            System.out.print ( cross_P[i] +" "); 
          
    } 
}
