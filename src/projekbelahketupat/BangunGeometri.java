package projekbelahketupat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public abstract class BangunGeometri implements Runnable{
    
    public abstract void tampilkanHasil();
        
    @Override
    public void run() {
        try {
            String namaThread = Thread.currentThread().getName();
            System.out.println("-> [" + namaThread + "] Sedang memproses data...");
            
            // Simulasi perhitungan berat
            int waktuTunda =  10000; 
            Thread.sleep(waktuTunda);
            
            // POLYMORPHISM BERAKSI DI SINI!
            // Java akan memanggil tampilkanHasil() sesuai wujud aslinya (Prisma/Limas)
            
//            synchronized (System.out) {
                tampilkanHasil(); 
                System.out.println("<- [" + namaThread + "] SELESAI!\n");
//            }
            
            
        } catch (InterruptedException e) {
            System.out.println("Proses terganggu!");
        }
    
    }
}
