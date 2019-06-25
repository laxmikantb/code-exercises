package com.lax.codeexercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class FindMedian {
	static Queue<Integer> queue = new LinkedList<Integer>();
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer a, Integer b) {
        	return -1 * a.compareTo(b);
        }
	});
	
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
    public static void addNum(int num) {
		if (minHeap.size() == 0 || num < minHeap.peek()) {
			minHeap.offer(num);
		}
		else
		{
			maxHeap.offer(num);
		}
		
    	if (minHeap.size() > maxHeap.size()+1) maxHeap.offer(minHeap.poll());
    	else
    	if (minHeap.size()+1 < maxHeap.size()) minHeap.offer(maxHeap.poll());
    }
    
    public static void removeNum(int num) {
    	if (!minHeap.isEmpty() && num <= minHeap.peek()) 
    		minHeap.remove(num);
    	else
    		maxHeap.remove(num);
    	if (minHeap.size() > maxHeap.size()+1) maxHeap.offer(minHeap.poll());
    	else if (minHeap.size()+1 < maxHeap.size()) minHeap.offer(maxHeap.poll());

    }
    
    public static int findMedian() {
    	
    	if (minHeap.size() > maxHeap.size()) {
    		while(true) {
    			if (minHeap.size() - maxHeap.size() > 2) {
    				maxHeap.offer(minHeap.poll());
    			}
    			else
    				break;
    		}
    		return  minHeap.peek();
    	}
    	if (maxHeap.size() > minHeap.size()) {
    		while(true) {
    			if (maxHeap.size() - minHeap.size() > 2) {
    				minHeap.offer(maxHeap.poll());
    			}
    			else
    				break;
    		}
    		return maxHeap.peek();
    	}

    	return maxHeap.peek();
    }
    public static void solve(int[] expenditures, int days) {
        	Queue<Integer> queue = new LinkedList<Integer>();
        	int[] counts = new int[201];
        	Arrays.fill(counts,0);
        	for (int i=0; i < expenditures.length; i++) {
        		queue.offer(expenditures[i]);
        		if (i < days) {
        			counts[expenditures[i]]++;
        		}
        		
        	}
        	
        }
    
    public static double findMean(int a[], int n) 
    { 
        int sum = 0; 
        for (int i = 0; i < n; i++)  
            sum += a[i]; 
      
        return (double)sum / (double)n; 
    } 
  
    // Function for calculating median 
    public static double findMedian(int a[], int n) 
    { 
        // First we sort the array 
        Arrays.sort(a); 
  
        // check for even case 
        if (n % 2 != 0) 
        return (double)a[n / 2]; 
      
        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0; 
    } 
    
	    public static void main(String[] args) throws IOException {
	      String thisLine;
	  	  BufferedReader br = null;
	  	  int i;
	  	  ArrayList<Integer> list = new ArrayList<Integer>();
		  //Open the file for reading
		      try {
		        br = new BufferedReader(new FileReader("C:\\Users\\laxmikant\\fraudtests.txt"));
		        while ((thisLine = br.readLine()) != null) { // while loop begins here
		        String[] tokens = thisLine.split(" ");
		        for (i=0; i < tokens.length; i++) {
		        		list.add(Integer.parseInt(tokens[i]));
		        }
		        
		      }
		      }
		      catch (IOException e) {
		        System.err.println("Error: " + e);
		      }
		      finally {
		    	  if (br != null) br.close();
		      }
		      
	        Scanner input = new Scanner(System.in);
	        int n = 200000;
	        int d = 10000;
	        int notifications = 0;
	        
	        //Wait for d transactions before any notifications
	        for(i = 0; i < d; i++)
	        {
	            int transaction = list.get(i);
	            addNum(transaction);
	            queue.offer(transaction);
	        }
	            
	        int indx = d;
	        for(i = 0; i < n-d; i++)
	        {
	            int newTransaction = list.get(indx);
	            indx++;
	            
	            //Check if fraudulent activity may have occurred
	            int median = findMedian();
//	            System.out.println(median + " " + newTransaction);
	            if(newTransaction >= (2 * median)) {
	                notifications++;
	                //System.out.println(median + " " + newTransaction);
	            }
	            else
	            	System.out.println(" === " + median + " " + newTransaction);
	                
	            //Remove the oldest transaction
	            removeNum(queue.poll());
	            //Add the new transaction
	            queue.offer(newTransaction);
	            addNum(newTransaction);
	        }
	        
	        System.out.println(notifications);
	    }
}
