/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjavatesting;

import java.util.HashMap;

/**
 *
 * @author cgupta
 * @version 1.0
 */

public class FibonacciSeries {   

    //Using Hashmap for Memorization of Fibonacci number
    
    //              key , value  <- here 'key' is fibonacci number and
    //                              'value' is fibonacci value for that number
    static HashMap <Long, Long> memory = new HashMap <Long, Long>();
      
    //Fibonacci series using Recursion and Dynamic Programming/Memorization 
    //Technique
    static Long fibUsingDP(Long inputNumber){
        
        if ( inputNumber.longValue() < 2 ){                
            memory.put(inputNumber, inputNumber);
            System.out.println("Fibo Number = " + inputNumber +
                                                " ,value = " + inputNumber);
            return (memory.get(inputNumber));           
        }
        else{            
            Long val = memory.get(inputNumber);
            
            if( val == null ){                
                memory.put(inputNumber, (fibUsingDP(inputNumber - 1) + 
                                         fibUsingDP(inputNumber - 2) ) );                
                System.out.println("Fibo Number = " + inputNumber + " ,value = " 
                                                    + memory.get(inputNumber));   
                
                return (memory.get(inputNumber));
            }
            
            return  val;   
        }
    }
    
    //Fibonacci series using only Recursion 
    static long fib(long inputNumber){
        if (inputNumber > 1){           //Base condition    
            
            long val = fib(inputNumber - 1) + fib(inputNumber - 2);          
            
            System.out.println("Fibo Number = " + inputNumber + " ,value = " + 
                                                                        val);
            
            return val;
        }
        else{
            System.out.println("Fibo Number = " + inputNumber + " ,value = " + 
                                                                   inputNumber);
            return inputNumber;
        }
    }
        
    public static void main(String args[]){
        long    startTime;
        long    endTime;
        long    timeElapsed;    
        long    fiboNumber;
        
        //Change value here for which you want fibonacci series
        fiboNumber = 15;     
        
        
        
        startTime = System.nanoTime();        
        System.out.println("Analysis of Fibonacci series using only Recursion.\n");        
        System.out.println("\nFibonacci of " + fiboNumber + " = " + 
                                                                fib(fiboNumber));       
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("\nExecution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " +
                                                        timeElapsed / 1000000);
   
        startTime = System.nanoTime();   
        System.out.println("\n\n");
        System.out.println("Analysis of Fibonacci series using Recursion and "
                                                    + "Dynamic Programming\n");
        System.out.println("\nFibonacci of " + fiboNumber + " using DP = " + 
                                                        fibUsingDP(fiboNumber));
        System.out.println("Memorized Data = " + memory);
        memory.clear();        
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("\nExecution time in nanoseconds  : " + timeElapsed);
        System.out.println("Execution time in milliseconds : " +
                                                        timeElapsed / 1000000);       
        
    }
}
