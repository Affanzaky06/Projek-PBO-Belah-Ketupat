/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

import javax.swing.*;

/**
 *
 * @author ACER
 */
public abstract class BangunGeometri implements Runnable{
    public static JTextArea logTarget;
    public JProgressBar barProses;
    
    @Override
    public abstract void run();
}
