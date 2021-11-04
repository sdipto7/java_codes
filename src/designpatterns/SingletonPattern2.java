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
class PrinterModule {
    private static PrinterModule pm;
    
    private PrinterModule(){
    
    }
    
    public static PrinterModule getInstance(){
        if (pm == null){
            pm = new PrinterModule();
        }
        return pm;
    }
    
    public void doPrint(){
        
        System.out.println("Print");
    }    
}

class Runner{
    static PrinterModule pm = PrinterModule.getInstance();
    public static void main(String[] args){
        pm.doPrint();
        pm.doPrint();
        pm.doPrint();
    }
}
