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
public class HiloCosas extends Thread {
   
    
    public HiloCosas(String hiloName){
        super(hiloName);
    }
    
    @Override
    public void run(){
        System.out.println("Start "+ Thread.currentThread().getName()+ " hace cosas");
        try {
            while (!Thread.currentThread().isInterrupted()){
                    
                System.out.println(Thread.currentThread().getName()+" hace cosas");
                
                Thread.currentThread().sleep(500);
            }
            
        } catch (InterruptedException ex) {
            //Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("End Thread "+ Thread.currentThread().getName()+ " hace cosas");
        }
    }

}
