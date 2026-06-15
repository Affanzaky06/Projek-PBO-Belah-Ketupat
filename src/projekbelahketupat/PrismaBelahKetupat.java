/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;
import javax.swing.*;
import static projekbelahketupat.BangunGeometri.logTarget;

/**
 *
 * @author ACER
 */
public class PrismaBelahKetupat extends BelahKetupat implements Runnable{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;
    
    
    public PrismaBelahKetupat(double d1, double d2, double t){
        super(d1, d2);
        this.tinggiPrisma = t;
    }
    
    public void setTinggiPrisma(double tinggiPrisma){
        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException ("nilai tinggi tidak boleh <= 0");
        }
        this.tinggiPrisma = tinggiPrisma;
    }
    
    public double getTinggiPrisma(){
        return tinggiPrisma;
    }
    
    public double hitungVolume(){
        if (super.luas <=0 || super.sisi <=0) {
            throw new IllegalArgumentException ("pastikan luas dan tinggi sudah di hitung dan tidak <= 0");
        }
        this.volume = super.luas * this.tinggiPrisma;
        return volume;
    }
   
    public double hitungVolume(double d1, double d2, double tinggiPrisma){
        if (d1 <= 0 || d2 <= 0 || tinggiPrisma <=0) {
            throw new IllegalArgumentException ("nilai d1, d2 dan tinggi tidak boleh <= 0");
        }
        this.volume = super.hitungLuas(d1, d2) * tinggiPrisma;
        return volume;
    }
    
    public double hitungLuasPermukaan(){
        if (this.tinggiPrisma <= 0 || super.sisi <= 0 || super.luas <=0) {
            throw new IllegalArgumentException ("pastikan sisi  dan luas sudah dihitung dan tidak <= 0 dan nilai tinggi tidak <= 0");
        }
        this.luasPermukaan = ((2 * super.luas) + (super.keliling * this.tinggiPrisma));
        return luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double d1, double d2, double keliling, double tinggiPrisma){
        if (d1 <= 0 || d2 <= 0 || tinggiPrisma <=0 || sisi <=0) {
            throw new IllegalArgumentException ("nilai d1, d2, tinggi dan sisi tidak boleh <= 0");
        }
        this.luasPermukaan = ((2 * super.hitungLuas(d1, d2)) + (keliling * tinggiPrisma));
        return luasPermukaan;
    }
    @Override
    public void tampilkanHasil() {
        
        BelahKetupat.logTarget.append("Volume Prisma Belah Ketupat: " + this.volume+ "\n");
        BelahKetupat.logTarget.append("Luas Permukaan Prisma Belah Ketupat: " + this.luasPermukaan+ "\n");
        BelahKetupat.logTarget.append("------------------------------------\n");
        
    }
    
    @Override
    public void run() {
        try {
            final String namaThread = Thread.currentThread().getName();
            
//            for (int i = 0; i < 100; i++) {
//                final int persen = i;
//                if (this.barProses != null) {
//                    SwingUtilities.invokeLater(new Runnable (){
//                        public void run(){
//                            barProses.setValue(persen);
//                        }
//                    });
//                }
//                int waktuTunda =  10 + (int)(Math.random() * 40);
//                Thread.sleep(waktuTunda);
//            }
//           
           
          
            int waktuTunda = 500 + (int)(Math.random() * 1000); ; 
            
             super.hitungSisi();
             barProses.setValue(20);
             Thread.sleep(waktuTunda);
             
             super.hitungLuas();
             barProses.setValue(40);
             Thread.sleep(waktuTunda);
             
             super.hitungKeliling();
             barProses.setValue(60);
             Thread.sleep(waktuTunda);
             
             this.hitungVolume();
             barProses.setValue(80);
             Thread.sleep(waktuTunda);
             
             this.hitungLuasPermukaan();

         
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        if (barProses != null && logTarget != null) {
                            barProses.setValue(100);
                            logTarget.append("[" + namaThread + "] Berhasil finish!\n");
                            tampilkanHasil();
                            logTarget.setCaretPosition(logTarget.getDocument().getLength());
                        }   
                    }
                });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}