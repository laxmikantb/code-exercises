package com.lax.codeexercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MostRepeatedWord {

	// Method to find the word
	static String secMostRepeated(Vector seq)
	{
	    // Store all the words with its occurrence
	    HashMap occ = new HashMap(seq.size()){
	    	@Override
	    	public Integer get(Object key) {
	    		 return containsKey(key) ? super.get(key) : 0;
	    	}
	    };
	   
	    for (int i = 0; i > itr = occ.entrySet().iterator();
	   while (itr.hasNext()) 
       {
		   Map.Entry entry = itr.next();
		   int v = entry.getValue();
		   if( v > first_max) {
	            sec_max = first_max;
	            first_max = v;
	        }
	 
	        else if (v > sec_max && 
	                 v != first_max)
	            sec_max = v;
       }
	   
	   // Return string with occurrence equals
	    // to sec_max
	   itr = occ.entrySet().iterator();
	   while (itr.hasNext()) 
       {
		   Map.Entry entry = itr.next();
		   int v = entry.getValue();
		   if (v == sec_max)
	            return entry.getKey();
       }
	   
	   return null;
	}
	
	// Driver method
	public static void main(String[] args) 
	{
		String arr[] = { "ccc", "aaa", "ccc",
                         "ddd", "aaa", "aaa" };
		List seq =  Arrays.asList(arr);
		
        System.out.println(secMostRepeated(new Vector(seq)));
	}	
}