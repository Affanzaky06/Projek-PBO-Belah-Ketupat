/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

/**
 *
 * @author ACER
 */
public class BelahKetupat implements Runnable{
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
        System.out.println("Sisi Belah Ketupat: " + hitungS());
        System.out.println("Luas Belah Ketupat: " + hitungLuas());
        System.out.println("Keliling Belah Ketupat: " + hitungKeliling());
        System.out.println(" ");
    }
    @Override
    public void run() {
        System.out.println("\n Thread BelahKetupat Mengeksekusi Perhirungan......");
        tampilkanHasil();
    }
    
    
}
