/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javathread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josuepirir
 */
public class Hilo extends Thread {
    
    private final long initialTime;
    private long elapsedTime;
    private long currentTime;
    private HiloCosas hiloCosas;
    private int timeVariable;
    
    public Hilo(String hiloName, long initialTime, HiloCosas hiloCosas, int timeVariable){
        super(hiloName);
        this.initialTime = initialTime;
        this.hiloCosas = hiloCosas;
        this.timeVariable = timeVariable;
    }
    
    @Override
    public void run(){
        try {
            while (!Thread.currentThread().isInterrupted() && getElapsedTime() <timeVariable  ){
                    
                System.out.println("time: "+ getElapsedTime());
                
                Thread.currentThread().sleep(1000);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Thread.currentThread().interrupt();
            hiloCosas.interrupt();
            System.out.println("End Thread Monior");
            
        }
    }

    private long getElapsedTime(){
        currentTime = System.nanoTime();
        elapsedTime  = (currentTime - initialTime) / 1000000000;
        return elapsedTime;
    }
    
}
