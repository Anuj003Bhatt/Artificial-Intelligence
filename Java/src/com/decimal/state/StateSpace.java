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
class VisitedState{
    State visited=null;
    VisitedState nextState=null;
    public VisitedState(){
        
    }
    public VisitedState(State st){
        this.visited = st;
    }
}
class StateList{
    VisitedState start=null;
    public void append(State next){
      VisitedState  visited = new VisitedState(next);
      if(this.start == null){
          this.start = visited;
          return;
      }
      VisitedState temp = this.start;
      while( temp.nextState !=null ){
          temp = temp.nextState;
      }
      temp.nextState = visited;
    }
    
    public boolean isStatePresent(State st){
        VisitedState temp = this.start;
        while( temp != null ){
            if(temp.visited.equals(st))return true;
            temp = temp.nextState;
        }
        return false;
    }
    
    public boolean isStatePresent(int x, int y){
        State st = new State(x,y);
        VisitedState temp = this.start;
        while( temp != null ){
            if(temp.visited.equals(st))return true;
            temp = temp.nextState;
        }
        return false;
    }
}

public class StateSpace {
    
    private static final String LEFT="LEFT",RIGHT="RIGHT",UP="UP",DOWN="DOWN"; 
    private static double dist[] = new double[4];
    private static StateList STATES_LIST = new StateList();

    
    public static void nextStepHuristic(){
        int current_x=artificialintelligence.ArtificialIntelligence.start.getX();
        int current_y=artificialintelligence.ArtificialIntelligence.start.getY();
        int goal_x=artificialintelligence.ArtificialIntelligence.goal.getX();
        int goal_y=artificialintelligence.ArtificialIntelligence.goal.getY();
        double dist_right=-1,dist_left=-1,dist_down=-1,dist_up=-1;
        dist[0]=-1;
        dist[1]=-1;
        dist[2]=-1;
        dist[3]=-1;
        
//        System.out.println("State of the system : \n Start : "+artificialintelligence.ArtificialIntelligence.start);
//        System.out.println("Goal : "+artificialintelligence.ArtificialIntelligence.goal);
        
//        Scanner sc = new Scanner(System.in);
//        sc.nextLine();
         if(current_x==goal_x && current_y==goal_y){return;}
        
        // Can move right right=>0
        if(current_x <artificialintelligence.ArtificialIntelligence.size){
        current_x+=1;
        if(current_x==goal_x && current_y==goal_y){
         
            artificialintelligence.ArtificialIntelligence.start.moveRight();
            StateSpace.STATES_LIST.append(artificialintelligence.ArtificialIntelligence.start);
            return;
        }
        dist_right = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        dist[0] = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        current_x-=1;
        }
        
        
        
        // Can move left left=>1 
        if(current_x >0){
        current_x-=1;
        if(current_x==goal_x && current_y==goal_y){
            artificialintelligence.ArtificialIntelligence.start.moveLeft();
            StateSpace.STATES_LIST.append(artificialintelligence.ArtificialIntelligence.start);
            return;
        }
        dist_left = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        dist[1] = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        current_x+=1;
        }
        
        // Can move down down=>2
        if(current_y <artificialintelligence.ArtificialIntelligence.size){
        current_y+=1;
        if(current_x==goal_x && current_y==goal_y){
            artificialintelligence.ArtificialIntelligence.start.moveDown();
            StateSpace.STATES_LIST.append(artificialintelligence.ArtificialIntelligence.start);
            return;
        }
        dist_down = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        dist[2] = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        current_y-=1;
        }
        
        // Can move up    UP => 3
        if(current_y >0){
        current_y-=1;
        if(current_x==goal_x && current_y==goal_y){
            artificialintelligence.ArtificialIntelligence.start.moveUp();
            StateSpace.STATES_LIST.append(artificialintelligence.ArtificialIntelligence.start);
            return;
        }
        dist_up = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        dist[3] = artificialintelligence.ArtificialIntelligence.goal.distance(current_x, current_y);
        current_y+=1;
        }
        
        int next = move(current_x,current_y);
        switch(next){
            case 1 : artificialintelligence.ArtificialIntelligence.start.moveLeft(); break;
            case 0 : artificialintelligence.ArtificialIntelligence.start.moveRight(); break;
            case 2 : artificialintelligence.ArtificialIntelligence.start.moveDown(); break;
            case 3 : artificialintelligence.ArtificialIntelligence.start.moveUp(); break;
            case -1: System.out.println("No solution exist !!");
        }
        
        nextStepHuristic();
        
        
    }
    
    public static int move(int current_x, int current_y){
        int min_i=0;
        for(int i=1;i<StateSpace.dist.length;i++){
           
            if(  (StateSpace.dist[min_i] == -1 && StateSpace.dist[i] != -1 ) ||(StateSpace.dist[i]<StateSpace.dist[min_i] && StateSpace.dist[i]!=-1) ){
            boolean replace = true;    
            switch(i){
            case 1 : replace = STATES_LIST.isStatePresent(current_x-1, current_y); break;
            case 0 : replace = STATES_LIST.isStatePresent(current_x+1, current_y); break;
            case 2 : replace = STATES_LIST.isStatePresent(current_x, current_y+1); break;
            case 3 : replace = STATES_LIST.isStatePresent(current_x+1, current_y-1); break;
            } 
            if(!replace)
                min_i = i;
            }
        }
       
            
        return min_i;
    }
    
}
