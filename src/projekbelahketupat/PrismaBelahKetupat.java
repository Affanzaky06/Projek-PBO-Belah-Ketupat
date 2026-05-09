/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

/**
 *
 * @author ACER
 */
public class PrismaBelahKetupat extends BelahKetupat{
    private double tinggiPrisma;
    
   
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
    
    public double hitungVolume(){
        return super.hitungLuas()*tinggiPrisma;
    }
    
    public double hitungLuasPermukaan(){
        return ((2*super.hitungLuas()) + super.hitungKeliling()*tinggiPrisma);
    }
    @Override
    public void tampilkanHasil() {
        System.out.println("Volume Prisma Belah Ketupat: " + hitungVolume());
        System.out.println("Luas Permukaan Prisma Belah Ketupat: " + hitungLuasPermukaan());
        System.out.println(" ");
    }
    
//    @Override
//    public void run(){
//        try {
//            // Mendapatkan nama thread yang sedang berjalan
//            String namaThread = Thread.currentThread().getName();
//            System.out.println("-> [" + namaThread + "] Sedang memproses data...");
//            
//            // "Mengerem" program secara acak antara 0.5 sampai 2 detik
//            // Ini untuk mensimulasikan bahwa rumus matematikanya "berat"
//            long waktuTunda = (long) (Math.random() * 2000) + 500; 
//            Thread.sleep(waktuTunda);
//            
//            // Setelah selesai pending, baru tampilkan hasilnya
//            tampilkanHasil();
//            System.out.println("<- [" + namaThread + "] SELESAI!\n");
//            
//        } catch (InterruptedException e) {
//            System.out.println("Proses terganggu!");
//        }
//    }
        
}
