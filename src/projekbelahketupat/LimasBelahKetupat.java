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
public class LimasBelahKetupat extends BelahKetupat implements Runnable{
    
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;
        
    public LimasBelahKetupat(){
        this.tinggiLimas = 0;
    }
    
    
    public void setTinggiLimas(double tinggiLimas){
        this.tinggiLimas = tinggiLimas;
    }
    
    public double getTinggiLimas(){
    return tinggiLimas;
    }
        
    public void hitungVolume() {
        this.volume = (1.0 / 3.0) * super.luas * this.tinggiLimas;
    }
    
    public void hitungVolume(double luas, double tinggiLimas) {
        this.volume = (1.0 / 3.0) * luas * tinggiLimas;
    }
    
    public void hitungLuasPermukaan() {
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(super.sisi / 2, 2));
        this.luasPermukaan = super.luas + (4 * (0.5 * super.sisi * tinggiSegitigaTegak));
    }
    
    public void hitungLuasPermukaan(double tinggiLimas, double sisi, double luas) {
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(sisi / 2, 2));
        this.luasPermukaan = luas + (4 * (0.5 * sisi * tinggiSegitigaTegak));
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
    
    
    

    
@Override
    public void run() { 
        try {
            final String namaThread = Thread.currentThread().getName();
            
            for (int i = 0; i < 100; i++) {
                final int persen = i;
                if (this.barProses != null) {
                    SwingUtilities.invokeLater(new Runnable (){
                        public void run(){
                            barProses.setValue(persen);
                        }
                    });
                }
                int waktuTunda =  10 + (int)(Math.random() * 40);
                Thread.sleep(waktuTunda);
            }
                    
            int waktuTunda = 500 + (int)(Math.random() * 1000); 
            Thread.sleep(waktuTunda);
            

             super.hitungSisi();
             super.hitungLuas();
             super.hitungKeliling();
             this.hitungVolume();
             this.hitungLuasPermukaan();

            
         
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        if (barProses != null) {
                            barProses.setValue(100);
                        }
                        
                        if (logTarget != null) {
                            logTarget.append("[" + namaThread + "] Berhasil finish!\n");


                        
                            logTarget.setCaretPosition(logTarget.getDocument().getLength());
                        }
                        
                    }
                });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
    