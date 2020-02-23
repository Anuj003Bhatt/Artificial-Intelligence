/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.decimal.heuristics;

/**
 *
 * @author Anuj Bhatt
 */

class Step{
    String step=null;
    Step nextStep=null;
    public Step() {
        
    }
    public Step(String step) {
        this.step = step;
    }
   
}

public class ResquePrincess {
    private Step start=null;
    
    public void append(String step){
        Step nextStep = new Step(step);
        if(start == null){
            this.start = nextStep;
            return;
        }
        Step temp = this.start;
        while(temp.nextStep!=null){
            temp = temp.nextStep;
        }
        temp.nextStep=nextStep;
    }
    
    public void print(){
        Step temp = this.start;
        while(temp!=null){
            System.out.println(temp.step);
            temp = temp.nextStep;
                    
        }
    }
    
    
}
