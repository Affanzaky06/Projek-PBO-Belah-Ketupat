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
public class BelahKetupat implements Runnable{
    
    public static JTextArea logTarget;
    
    public double d1;
    public double d2;
    public double sisi;
    public double luas;
    public double keliling;
    public JProgressBar barProses;
    public Thread targetInterupsi; 
    public int waktuTungguSebelumMaju = 0;
    
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
            
            // 1. FASE MENUNGGU GILIRAN MAJU (Skenario Dosen)
            if (waktuTungguSebelumMaju > 0) {
                Thread.sleep(waktuTungguSebelumMaju);
            }

            // 2. FASE EKSEKUSI INTERUPSI KEPADA KORBAN
            if (targetInterupsi != null && targetInterupsi.isAlive()) {
                final String namaKorban = targetInterupsi.getName();
                if (logTarget != null) {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            logTarget.append("\n 🚨 [" + namaThread + "] MENGINTERUPSI [" + namaKorban + "]!\n");
                        }
                    });
                }
                targetInterupsi.interrupt(); // Potong jalur korban!
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
                
            if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException(); // Jika ya, langsung lempar ke zona catch!
                }
            
            
            int waktuTunda =  10 + (int)(Math.random() * 40);
            Thread.sleep(waktuTunda);
            }

            hitungS();
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
