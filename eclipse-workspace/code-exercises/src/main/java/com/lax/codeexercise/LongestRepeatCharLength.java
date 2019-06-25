package com.lax.codeexercise;

public class LongestRepeatCharLength {

	static char maxRepeating(String str) 
    { 
        int n = str.length(); 
        int count = 0; 
        char res = str.charAt(0); 
        int cur_count = 1; 
  
        // Traverse string except last character 
        for (int i = 0; i < n; i++) 
        { 
            // If current character matches with next 
            if (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) 
                cur_count++; 
  
            // If doesn't match, update result 
            // (if required) and reset count 
            else
            { 
                if (cur_count > count) 
                { 
                    count = cur_count; 
                    res = str.charAt(i); 
                } 
                cur_count = 1; 
            } 
        } 
        return res; 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        String str = "aaaabbaaccde"; 
        System.out.println(maxRepeating(str)); 
    } 
}
