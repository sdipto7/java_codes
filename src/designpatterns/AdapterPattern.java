/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

/**
 *
 * @author DIPTO
 */
interface Calculator{
    int sum(int x, int y);
    int substract(int x, int y);
    int multiply(int x, int y);
}

class ScientificMath{
    int addNumbers(int x, int y){
        return x+y;
    }
    int substractNumbers(int x, int y){
        return x-y;
    }
    int multiplyNumbers(int x, int y){
        return x*y;
    }
    
}

class ScientificCalculator extends ScientificMath implements Calculator{
    public int sum(int x, int y){
        return this.addNumbers(x,y);
    }
    
    public int substract(int x, int y){
        return this.substractNumbers(x,y);
    }
    
    public int multiply(int x, int y){
        return this.multiplyNumbers(x,y);
    }
}

class main{
    public static void main(String[] args){
        Calculator calc = new ScientificCalculator();
        System.out.println(calc.sum(5,5));
    }
}

