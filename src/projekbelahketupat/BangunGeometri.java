package projekbelahketupat;
import javax.swing.JTextArea;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public abstract class BangunGeometri implements Runnable{
    
    public static JTextArea logTarget;
    
    public abstract void tampilkanHasil();
        
    @Override
    public void run() {
        try {
//            String namaThread = Thread.currentThread().getName();
//            System.out.println("-> [" + namaThread + "] Sedang memproses data...");
            
            // TANGKAP NAMA THREAD SEBELUM MASUK GUI
            final String namaThread = Thread.currentThread().getName();
            
            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        logTarget.append("-> [" + namaThread + "] Sedang memproses data...\n");
                        logTarget.setCaretPosition(logTarget.getDocument().getLength()); // Auto-scroll
                    }
                });
            }
            
            // Simulasi perhitungan berat
            int waktuTunda =  1000; 
            Thread.sleep(waktuTunda);
            
            
          
            // POLYMORPHISM BERAKSI DI SINI!
            // Java akan memanggil tampilkanHasil() sesuai wujud aslinya (Prisma/Limas)
            
            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Cetak nama pesertanya dulu
                        logTarget.append("-> [" + namaThread + "] Berhasil finish!\n");
                        
                        // Panggil rumus masing-masing
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
