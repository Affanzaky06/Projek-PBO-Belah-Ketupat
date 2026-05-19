/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

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
    
    public double hitungVolume(){
        return (super.hitungLuas()*tinggiLimas)/3.0;
        
    }
    
    public double hitungLuasPermukaan(){
        double sisi = super.hitungS();
        
        double r =  (super.getD1()*super.getD2())/(4*sisi);
            
        double tinggiSegitiga = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(r, 2));
        
        double luasSelimut = 2 * sisi * tinggiSegitiga;
        
        return super.hitungLuas() + luasSelimut;
        
    }
    @Override
    public void tampilkanHasil() {
        
        BangunGeometri.logTarget.append("Volume Limas Belah Ketupat: " + hitungVolume() + "\n");
        BangunGeometri.logTarget.append("Luas Permukaan Limas Belah Ketupat: " + hitungLuasPermukaan()+ "\n");
        BangunGeometri.logTarget.append("------------------------------------\n");
        

    }
    
//    @Override
//    public void run(){
//       try {
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
