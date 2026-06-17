/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

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
//    public BelahKetupat(){
//        this.d1 = 0;
//        this.d2 = 0;
//    } 
    
    public BelahKetupat(double d1, double d2){
        this.d1 = d1;
        this.d2 = d2;
    } 
    
    
    public double hitungLuas(){
        if (d1 <= 0 || d2 <= 0) {
            throw new IllegalArgumentException ("pastikan nilai d1 dan d2 tidak <= 0");
        }
        this.luas = 0.5*this.d1*this.d2;
        return luas;
    }
    
    public double hitungLuas(double d1, double d2) {
        if (d1 <= 0 || d2 <= 0) {
            throw new IllegalArgumentException ("nilai d1 dan d2 tidak boleh <= 0");
        }
        this.luas = 0.5*d1*d2;
        return luas;
    }
    
    public double hitungSisi(){
        if (this.d1 <= 0 || this.d2 <= 0) {
            throw new IllegalArgumentException ("nilai d1 dan d2 tidak boleh <= 0");
        }
        this.sisi = Math.sqrt(Math.pow((this.d1*0.5), 2) + Math.pow((this.d2*0.5), 2));
        return sisi;
    }
    
    public double hitungSisi(double d1, double d2) {
        if (d1 <= 0 || d2 <= 0) {
            throw new IllegalArgumentException ("nilai d1 dan d2 tidak boleh <= 0");
        }
        this.sisi = Math.sqrt(Math.pow((d1*0.5), 2) + Math.pow((d2*0.5), 2));
        return sisi;
    }
    
    public double hitungKeliling(){
        if (this.sisi <= 0) {
            throw new IllegalArgumentException ("nilai sisi belum dihitung atau <= 0");
        }
        this.keliling = 4*this.sisi;
        return keliling;
    }
    
    public double hitungKeliling(double sisi) {
        if (sisi <= 0) {
            throw new IllegalArgumentException ("nilai sisi tidak boleh <= 0!");
        }
        this.keliling = 4*sisi;
        return keliling;
    }
    
    @Override
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
            
            int waktuTunda = 500 + (int)(Math.random() * 1000);
            
            hitungSisi();
            barProses.setValue(30);
            Thread.sleep(waktuTunda);
            
            hitungLuas();
            barProses.setValue(60);
            Thread.sleep(waktuTunda);
            
            hitungKeliling();
            barProses.setValue(90);
            Thread.sleep(waktuTunda);
            
            // 4. Tampilkan Hasil (Java akan memanggil tampilkanHasil() sesuai wujud aslinya berkat Polymorphism)

                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        if (barProses != null && logTarget != null) {
                            barProses.setValue(100);
                            logTarget.append("[" + namaThread + "] Berhasil finish!\n");
                            tampilkanHasil();
                            logTarget.setCaretPosition(logTarget.getDocument().getLength());
                        }
                        
                    }
                });
            
        } catch (Exception e) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    javax.swing.JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Perhitungan Gagal",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                });
            }
        }
    }
    
    

