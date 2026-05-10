/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

/**
 *
 * @author ACER
 */
public class BelahKetupat extends BangunGeometri{
    // Encapsulation
    private double d1;
    private double d2;
    
    
    // 1. Constructor Default (Tanpa Parameter) dipakai buat bikin objek dulu, sbg contoh kalau pakai input user, maka dibuat objek dulu
    // baru diisi kemudian pake Overloading yang bawah
    public BelahKetupat(){
        this.d1 = 0;
        this.d2 = 0;
    }
    
    public BelahKetupat(double d1, double d2){
        this.d1 = d1;
        this.d2 = d2;
    }
    
    public void setD1(double d1){
        this.d1 = d1;
    }
    
    public void setD2(double d2){
        this.d2 = d2;
    }
    
    public double getD1(){
        return d1;
    }
    
    public double getD2(){
        return d2;
    }
    
    public double hitungLuas(){
        return 0.5*d1*d2;
    }
    
    public double hitungS(){
        double s = Math.sqrt(Math.pow((d1*0.5), 2) + Math.pow((d2*0.5), 2));
        return s;
    }
    
    public double hitungKeliling(){
        return 4*(hitungS());
    }
    
    public void tampilkanHasil() {
        
        BangunGeometri.logTarget.append("Sisi Belah Ketupat: " + hitungS() + "\n");
        BangunGeometri.logTarget.append("Luas Belah Ketupat: " + hitungLuas() + "\n");
        BangunGeometri.logTarget.append("Keliling Belah Ketupat: " + hitungKeliling() + "\n");
        BangunGeometri.logTarget.append("------------------------------------\n");
        
//        System.out.println("Sisi Belah Ketupat: " + hitungS());
//        System.out.println("Luas Belah Ketupat: " + hitungLuas());
//        System.out.println("Keliling Belah Ketupat: " + hitungKeliling());
//        System.out.println(" ");
    }
//    @Override
//    public void run() {
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
