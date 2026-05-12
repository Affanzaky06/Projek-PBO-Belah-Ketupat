/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projekbelahketupat;

/**
 *
 * @author ACER
 */
public class ProjekBelahKetupat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        System.out.println("loding...");
        System.out.println("Membuka Antarmuka GUI...");

        // Memanggil dan memunculkan FrameTampil (GUI) ke layar secara aman
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instansiasi objek FrameTampil lalu buat menjadi terlihat (visible)
                new FrameTampil().setVisible(true);
            }
        });
        
    }
    }
