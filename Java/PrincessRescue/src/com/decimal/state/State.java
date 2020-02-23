/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.decimal.state;

/**
 *
 * @author Anuj Bhatt
 */
public class State {

    @Override
    public String toString() {
        return "State{" + "x=" + x + ", y=" + y + '}';
    }
    private int x,y;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if(this.x==other.x && this.y == other.y)
        return true;
        else return false;
    }
    
    public void moveUp(){
        this.y -=1;
        System.out.println("UP");
    }
    
    public void moveDown(){
        this.y +=1;
        System.out.println("DOWN");
    }
    public void moveRight(){
        this.x+=1;
        System.out.println("RIGHT");
    }
    public void moveLeft(){
        this.x-=1;
        System.out.println("LEFT");
    }
    
    public double distance(State no){
        int dist_x= this.x-no.x;
        int dist_y=this.y-no.y;
        return Math.sqrt( dist_x*dist_x+dist_y*dist_y);
    }
    
    public double distance(int x, int y){
        int dist_x= this.x-x;
        int dist_y=this.y-y;
        return Math.sqrt( dist_x*dist_x+dist_y*dist_y);
    }
    
    public State(){}
    public State(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return this.x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getY(){
        return this.y;
    }
    
}
