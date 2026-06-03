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
public class PrismaBelahKetupat extends BelahKetupat implements Runnable{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;
    
    
    public PrismaBelahKetupat(){
        this.tinggiPrisma = 0;
    }
    
    public void setTinggiPrisma(double tinggiPrisma){
        this.tinggiPrisma = tinggiPrisma;
    }
    
    public double getTinggiPrisma(){
        return tinggiPrisma;
    }
    
    public void hitungVolume() {
        // Karena kelas atas public, Prisma bisa langsung pakai 'this.luas' warisan bapaknya
        this.volume = super.luas * this.tinggiPrisma;
    }
   
    public void hitungVolume(double luas, double tinggiPrisma) {
        // Karena kelas atas public, Prisma bisa langsung pakai 'this.luas' warisan bapaknya
        this.volume = luas * tinggiPrisma;
    }
   
    public void hitungVolume(double d1, double d2, double tinggiPrisma) {
        super.hitungLuas(d1, d2);
        this.volume = super.luas * tinggiPrisma;
    }
    
    public void hitungLuasPermukaan() {
        // Langsung comot data luas dan keliling dari dirinya sendiri (hasil warisan)
        this.luasPermukaan = ((2 * super.luas) + (super.keliling * this.tinggiPrisma));
    }
    
    public void hitungLuasPermukaan(double luas, double keliling, double tinggiPrisma) {
        
        this.luasPermukaan = ((2 * luas) + (keliling * tinggiPrisma));
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
