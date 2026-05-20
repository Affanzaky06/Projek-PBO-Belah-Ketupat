/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;
import javax.swing.JTextArea;
/**
 *
 * @author ACER
 */
public class BelahKetupat implements Runnable{
    
    public static JTextArea logTarget;
    
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
    
   
    public void hitungLuas(){
        this.luas = 0.5*d1*d2;
    }
    
    public void hitungS(){
        this.sisi = Math.sqrt(Math.pow((d1*0.5), 2) + Math.pow((d2*0.5), 2));
    }
    
    public void hitungKeliling(){
        this.keliling = 4*this.sisi;
    }
    
    public void tampilkanHasil() {
        
       
        BelahKetupat.logTarget.append("Sisi Belah Ketupat: " + this.sisi + "\n");
        BelahKetupat.logTarget.append("Luas Belah Ketupat: " + this.luas + "\n");
        BelahKetupat.logTarget.append("Keliling Belah Ketupat: " + this.keliling + "\n");
        BelahKetupat.logTarget.append("------------------------------------\n");
    }   

    @Override
    public void run() { 
        try {
            // 1. TANGKAP NAMA THREAD SEBELUM MASUK GUI (Cukup 1 kali saja)
            final String namaThread = Thread.currentThread().getName();
            
            // (Opsional) Cetak di terminal bawah NetBeans
            System.out.println("-> [" + namaThread + "] Sedang memproses data..."); 
            
            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        logTarget.append("-> [" + namaThread + "] Sedang memproses data...\n");
                        logTarget.setCaretPosition(logTarget.getDocument().getLength()); // Auto-scroll
                    }
                });
            }
            
            int waktuTunda = 500 + (int)(Math.random() * 1000); 
            Thread.sleep(waktuTunda);
            

            hitungS();
            hitungLuas();
            hitungKeliling();


            
            // 4. Tampilkan Hasil (Java akan memanggil tampilkanHasil() sesuai wujud aslinya berkat Polymorphism)
            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        logTarget.append("[" + namaThread + "] Berhasil finish!\n");

                        tampilkanHasil();
                        
                        logTarget.setCaretPosition(logTarget.getDocument().getLength());
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
