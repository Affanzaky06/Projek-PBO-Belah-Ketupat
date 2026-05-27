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
