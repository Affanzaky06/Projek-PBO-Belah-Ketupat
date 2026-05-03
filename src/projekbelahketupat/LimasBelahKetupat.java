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
        System.out.println("Volume Limas Belah Ketupat: " + hitungVolume());
        System.out.println("Luas Permukaan Limas Belah Ketupat: " + hitungLuasPermukaan());
        System.out.println(" ");
    }
    
    @Override
    public void run(){
        System.out.println("\n Thread Limas Mengeksekusi Perhirungan......");
        tampilkanHasil();
    }
}
