/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificialintelligence;

import com.decimal.heuristics.ResquePrincess;
import com.decimal.state.State;
import com.decimal.state.StateSpace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Anuj Bhatt
 */
public class ArtificialIntelligence {
    public static State start=null,goal=null;
    public static int size;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            size = Integer.parseInt(br.readLine());
            String[] row = new String[size];
            
            for(int i =0; i<size; i++){
                row[i] = br.readLine();                
                int s = row[i].indexOf("m");
                if(s!=-1){
                    start = new State(s,i);
                }
                int p = row[i].indexOf("p");
                if(p!=-1){
                    goal = new State(p,i);
                }
            }
           
            StateSpace.nextStepHuristic();
            
        }catch(IOException ex){
            
        }
    }
    
}
