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
    private double sisi;
    private double luas;
    private double keliling;
    
    
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
    
    public double getSisi(){
        return sisi; 
    }
    
    public double getLuas(){ 
        return luas; 
    }
    
    public double getKeliling(){ 
        return keliling; 
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
    }   

    @Override
    public void run() {
        final String namaThread = Thread.currentThread().getName();
        try {
            for (int i = 0; i < 20; i++) {
                final int persen = i * 5;
                
                StringBuilder barProgres = new StringBuilder("[");
                for (int j = 0; j < 20; j++) {
                    barProgres.append(j <= i? "||" : "-");
                }
                barProgres.append("]");
                final String tampilBar = barProgres.toString();
                
                if (logTarget != null) {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            logTarget.append("⏳ [" + namaThread + "] " + tampilBar + " " + persen + "%\n");
                            logTarget.setCaretPosition(logTarget.getDocument().getLength());
                        }
                    });
                }
                Thread.sleep(100); 
            }
            
            // URUTAN EKSEKUSI MUTATOR (Sangat Penting!)
            hitungS();        // Mengisi atribut 'sisi'
            hitungLuas();     // Mengisi atribut 'luas'
            hitungKeliling(); // Memakai atribut 'sisi' untuk mengisi 'keliling'
            
            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        logTarget.append(" [" + namaThread + "] FINISH!\n");
                        tampilkanHasil();
                        logTarget.setCaretPosition(logTarget.getDocument().getLength());
                    }
                });
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
