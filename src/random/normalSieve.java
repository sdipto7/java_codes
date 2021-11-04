/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

// Java program to implement normal Sieve 
// of Eratosthenes using simple optimization 
// to reduce size of prime array to half and 
// reducing iterations. 
import java.util.Arrays; 
  
class GFG 
{ 
    static void normalSieve(int n) 
    { 
        // prime[i] is going to store true if 
        // if i*2 + 1 is composite. 
        boolean prime[]=new boolean[n / 2]; 
        Arrays.fill(prime, false); 
      
        // 2 is the only even prime so we can 
        // ignore that. Loop starts from 3. 
        for (int i = 3 ; i * i < n; i += 2) 
        { 
            // If i is prime, mark all its 
            // multiples as composite 
            if (prime[i / 2] == false) 
                for (int j = i * i; j < n; j += i * 2) 
                    prime[j / 2] = true; 
        } 
      
        // writing 2 separately 
        System.out.print("2 "); 
      
        // Printing other primes 
        for (int i = 3; i < n ; i += 2) 
            if (prime[i / 2] == false) 
                System.out.print(i + " "); 
    } 
    public static void main (String[] args) 
    { 
        int n = 100 ; 
        normalSieve(n); 
    } 
} 
  
// This code is contributed by Anant Agarwal.