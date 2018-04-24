/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathread;

/**
 *
 * @author josuepirir
 */
public class JavaThread {
    
    private static Hilo hiloMonitor;  
    private static HiloCosas haceCosas;
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        long initialTime = System.nanoTime();
        String hiloName = "report -"+initialTime;
        
        haceCosas = new HiloCosas(hiloName);
        haceCosas.start();
        
        hiloMonitor = new Hilo(hiloName, initialTime, haceCosas,10);
        hiloMonitor.start();
        
        haceCosas = new HiloCosas(hiloName+1);
        haceCosas.start();
        
        hiloMonitor = new Hilo(hiloName+1, initialTime, haceCosas,20);
        hiloMonitor.start();
        

        
        
    }
    
}
