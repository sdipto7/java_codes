/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

/**
 *
 * @author DIPTO
 */
// Java program to compute Totient  
// function for all numbers smaller 
// than or equal to n.

class totient { 
      
// Computes and prints totient of all numbers 
// smaller than or equal to n. 
static void computeTotient(int n) { 
      
    // Create and initialize an array to store 
    // phi or totient values 
    long phi[] = new long[n + 1]; 
    for (int i = 1; i <= n; i++) 
    phi[i] = i; // indicates not evaluated yet 
                // and initializes for product 
                // formula. 
  
    // Compute other Phi values 
    for (int p = 2; p <= n; p++) { 
          
    // If phi[p] is not computed already, 
    // then number p is prime 
    if (phi[p] == p) { 
          
        // Phi of a prime number p is 
        // always equal to p-1. 
        phi[p] = p - 1; 
  
        // Update phi values of all 
        // multiples of p 
        for (int i = 2 * p; i <= n; i += p) { 
              
        // Add contribution of p to its 
        // multiple i by multiplying with 
        // (1 - 1/p) 
        phi[i] = (phi[i] / p) * (p - 1); 
        } 
    } 
    } 
  
    // Print precomputed phi values 
    for (int i = 1; i <= n; i++) 
    System.out.println("Totient of " + i + 
                         " is " + phi[i]); 
} 
  
// Driver code 
public static void main(String[] args) { 
      
    int n = 12; 
    computeTotient(n); 
} 
} 
