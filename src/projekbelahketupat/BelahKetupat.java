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
public class BelahKetupat extends BangunGeometri implements Runnable{
  
    public double d1;
    public double d2;
    public double sisi;
    public double luas;
    public double keliling;   
    
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
    
    
    public double hitungLuas(){
        this.luas = 0.5*this.d1*this.d2;
        return luas;
    }
    
    public double hitungLuas(double d1, double d2) {
        this.luas = 0.5*d1*d2;
        return luas;
    }
    
    public double hitungSisi(){
        this.sisi = Math.sqrt(Math.pow((this.d1*0.5), 2) + Math.pow((this.d2*0.5), 2));
        return sisi;
    }
    
    public double hitungSisi(double d1, double d2){
        this.sisi = Math.sqrt(Math.pow((d1*0.5), 2) + Math.pow((d2*0.5), 2));
        return sisi;
    }
    
    public double hitungKeliling(){
        this.keliling = 4*this.sisi;
        return keliling;
    }
    
    public double hitungKeliling(double sisi){
        this.keliling = 4*sisi;
        return keliling;
    }
    
    @Override
    public void tampilkanHasil() {
//        BelahKetupat.logTarget.append("Sisi Belah Ketupat: " + this.sisi + "\n");
//        BelahKetupat.logTarget.append("Luas Belah Ketupat: " + this.luas + "\n");
//        BelahKetupat.logTarget.append("Keliling Belah Ketupat: " + this.keliling + "\n");
//        BelahKetupat.logTarget.append("------------------------------------\n");
    }   

    @Override
    public void run() {
        
        try {
            // 1. TANGKAP NAMA THREAD SEBELUM MASUK GUI (Cukup 1 kali saja)
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
            
            hitungSisi();
            hitungLuas();
            hitungKeliling();
            
            // 4. Tampilkan Hasil (Java akan memanggil tampilkanHasil() sesuai wujud aslinya berkat Polymorphism)

                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        if (barProses != null) {
                            barProses.setValue(100);
                        }
                        
                        if (logTarget != null) {
                            logTarget.append("[" + namaThread + "] Berhasil finish!\n");

                            ProjekBelahKetupat.prosesSelesai(BelahKetupat.this);
                        
                            logTarget.setCaretPosition(logTarget.getDocument().getLength());
                          }
                        
                    }
                });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
