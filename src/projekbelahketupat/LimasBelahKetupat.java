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
public class LimasBelahKetupat extends BelahKetupat{
    
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;
        
    public LimasBelahKetupat(){
        super();
        this.tinggiLimas = 0;
    }
    
    public LimasBelahKetupat(double d1, double d2, double tinggiLimas){
        super(d1, d2);
        this.tinggiLimas = tinggiLimas;
    }
    
    public void setTinggiLimas(double tinggiLimas){
        this.tinggiLimas = tinggiLimas;
    }
    
    public double getTinggiLimas(){
    return tinggiLimas;
    }
    
    public double getVolume(){ 
        return volume; 
    }
    
    public double getLuasPermukaan(){ 
        return luasPermukaan; 
    }
    
    
    
    public void hitungVolume() {
        this.volume = (1.0 / 3.0) * this.luas * tinggiLimas;
    }
    
    public void hitungLuasPermukaan() {
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(this.sisi / 2, 2));
        this.luasPermukaan = this.luas + (4 * (0.5 * this.sisi * tinggiSegitigaTegak));
    }
    @Override
    public void tampilkanHasil() {
        
        BelahKetupat.logTarget.append("Volume Limas Belah Ketupat: " + this.volume + "\n");
        BelahKetupat.logTarget.append("Luas Permukaan Limas Belah Ketupat: " + this.luasPermukaan + "\n");
        BelahKetupat.logTarget.append("------------------------------------\n");
        

    }
    
@Override
    public void run() { 
        try {
            final String namaThread = Thread.currentThread().getName();
            
            if (waktuTungguSebelumMaju > 0) {
                Thread.sleep(waktuTungguSebelumMaju);
            }

            if (targetInterupsi != null && targetInterupsi.isAlive()) {
                final String namaKorban = targetInterupsi.getName();
                if (logTarget != null) {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            logTarget.append("\n 🚨 [" + namaThread + "] MENGINTERUPSI [" + namaKorban + "]!\n");
                        }
                    });
                }
                targetInterupsi.interrupt(); 
            }

            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        logTarget.append("-> Thread hitung " + namaThread + " memulai perhitungan...\n");
                    }
                });
            }
            
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
            

             super.hitungS();
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

                            tampilkanHasil();
                        
                            logTarget.setCaretPosition(logTarget.getDocument().getLength());
                        }
                        
                    }
                });
            
        } catch (InterruptedException e) {
            final String namaMati = Thread.currentThread().getName();
            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        logTarget.append("[X] Perhitungan " + namaMati + " TERHENTI DI TENGAH JALAN KARENA DIINTERUPSI!\n");
                        logTarget.setCaretPosition(logTarget.getDocument().getLength());
                    }
                });
            }
        }
    }
    
}
    