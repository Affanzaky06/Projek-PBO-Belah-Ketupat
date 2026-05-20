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
public class PrismaBelahKetupat extends BelahKetupat{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;
    
   
    public PrismaBelahKetupat(){
        super();
        this.tinggiPrisma = 0;
    }
    
    public PrismaBelahKetupat(double d1, double d2, double tinggiPrisma){
        super(d1,d2);
        this.tinggiPrisma = tinggiPrisma;
    }
    
    public void setTinggiPrisma(double tinggiPrisma){
        this.tinggiPrisma = tinggiPrisma;
    }
    
    public double getTinggiPrisma(){
        return tinggiPrisma;
    }
    
    public double getVolume(){ 
        return volume; 
    }
    
    public double getLuasPermukaan(){ 
        return luasPermukaan; 
    }
    
   public void hitungVolume() {
        // Karena kelas atas public, Prisma bisa langsung pakai 'this.luas' warisan bapaknya
        this.volume = this.luas * this.tinggiPrisma;
    }
    
    public void hitungLuasPermukaan() {
        // Langsung comot data luas dan keliling dari dirinya sendiri (hasil warisan)
        this.luasPermukaan = ((2 * this.luas) + (this.keliling * this.tinggiPrisma));
    }
    @Override
    public void tampilkanHasil() {
        
        BelahKetupat.logTarget.append("Volume Prisma Belah Ketupat: " + this.volume+ "\n");
        BelahKetupat.logTarget.append("Luas Permukaan Prisma Belah Ketupat: " + this.luasPermukaan+ "\n");
        BelahKetupat.logTarget.append("------------------------------------\n");
        
//        System.out.println("Volume Prisma Belah Ketupat: " + hitungVolume());
//        System.out.println("Luas Permukaan Prisma Belah Ketupat: " + hitungLuasPermukaan());
//        System.out.println(" ");
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
                int waktuTunda = 10;
            Thread.sleep(waktuTunda);
            }
           
            
//            if (logTarget != null) {
//                javax.swing.SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        logTarget.append("-> [" + namaThread + "] Sedang memproses data...\n");
//                        logTarget.setCaretPosition(logTarget.getDocument().getLength()); // Auto-scroll
//                    }
//                });
//            }
            
            
            int waktuTunda = 500 + (int)(Math.random() * 1000); 
            Thread.sleep(waktuTunda);
            

     
             super.hitungS();
             super.hitungLuas();
             super.hitungKeliling();
             this.hitungVolume();
             this.hitungLuasPermukaan();

            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Cetak nama pesertanya dulu
                        logTarget.append("[" + namaThread + "] Berhasil finish!\n");
                        
                        // Panggil hasil cetakan masing-masing
                        tampilkanHasil();
                        
                        // EFEK TERMINAL: Paksa layar otomatis scroll ke baris paling bawah
                        logTarget.setCaretPosition(logTarget.getDocument().getLength());
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
