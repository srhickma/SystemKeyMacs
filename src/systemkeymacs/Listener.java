/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemkeymacs;

import java.util.logging.LogManager;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
/**
 *
 * @author Shane Hickman
 */
public class Listener implements NativeKeyListener{
    
    public void nativeKeyPressed(NativeKeyEvent e){
        CmdMapper.addKeyDown(NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyReleased(NativeKeyEvent e){
        CmdMapper.remKeyDown(NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e){}

    public static void main(String[] args){
        LogManager.getLogManager().reset();
        try{
            GlobalScreen.registerNativeHook();
        }
        catch(NativeHookException ex){
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new Listener());
    }
    
}
