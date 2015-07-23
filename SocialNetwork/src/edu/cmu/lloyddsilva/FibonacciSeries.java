package edu.cmu.lloyddsilva;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/* 
* Generates a fibonacci sequece from 0...index and returns it as an array
* Utilized BigInteger because fibonacci increases rapidly and utilized a cache for intermediate results
* Sample series: 0, 1, 1, 2, 3, 5, 8, 13 .. 
*/
public class FibonacciSeries {
    //Cache to store intermediate results. Takes more space, but reduces the time
    private static ArrayList<BigInteger> fibonacciCache = new ArrayList<BigInteger>();
    
    //Initialize the cache with 0, 1 values
    static {
        fibonacciCache.add(BigInteger.ZERO);
        fibonacciCache.add(BigInteger.ONE);
    
    }

    //Get a single fibonacci number
    public static BigInteger getFibonacci(int index) {
        if(index >= fibonacciCache.size()) {
            fibonacciCache.add(index, getFibonacci(index-1).add(getFibonacci(index-2)));
        }
        return fibonacciCache.get(index);
    }
    
    //Get all fibonacci numbers in the series and return as a BigInteger array
    public static BigInteger[] getFibonacciArray(int index) {
    	//Guard condition for invalid numbers
    	if(index <=0) {
            BigInteger[] output = new BigInteger[1];
            output[0] = BigInteger.ZERO;
            return output;
            
        }
            
            
        //Initialize array
        BigInteger[] series = new BigInteger[index];
        
        //Populate array
        for(int i=0; i<index ; i++) {
            series[i] = getFibonacci(i);
        
        }
    
        return series;
    }
    
    //Main driver to test
    public static void main(String[] args) {
        //Test one fibonacci number
        System.out.println(getFibonacci(1));
        
        //Test returned array
        System.out.println(Arrays.toString(getFibonacciArray(10)));
    
    }
}