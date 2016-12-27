/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemkeymacs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shane
 */
public class CmdMapper {
    
    static List<String> keysDown = new ArrayList();
    
    public static void addKeyDown(String key){
        if(!key.equals("Right Alt"))  //Right Alt causes problems with Listener
            keysDown.add(key);
        if(keysDown.size() == 3 && keysDown.contains("Left Control") && keysDown.contains("Left Alt")){
            for(String k : keysDown){
                if(!(k.equals("Left Control") || k.equals("Left Alt"))){
                    System.out.println("Executing Command: " + k);
                }
            }
        }
    }
    
    public static void remKeyDown(String key){
        try{
            keysDown.remove(key);
        }catch(Exception e){}
    }
    
}
