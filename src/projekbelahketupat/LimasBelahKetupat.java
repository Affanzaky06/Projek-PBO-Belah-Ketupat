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
    
    
    
    public void hitungVolume() {
        this.volume = (1.0 / 3.0) * this.luas * tinggiLimas;
    }
    
    public void hitungLuasPermukaan() {
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(this.sisi / 2, 2));
        this.luasPermukaan = this.luas + (4 * (0.5 * this.sisi * tinggiSegitigaTegak));
    }
    @Override
    public void tampilkanHasil() {
        
        BelahKetupat.logTarget.append("Volume Limas Belah Ketupat: " + this.volume + "\n");
        BelahKetupat.logTarget.append("Luas Permukaan Limas Belah Ketupat: " + this.luasPermukaan + "\n");
        BelahKetupat.logTarget.append("------------------------------------\n");
        

    }
    
@Override
    public void run() { // ◄ Hapus kata 'abstract' dan titik koma ';'
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
            

             super.hitungS();
             super.hitungLuas();
             super.hitungKeliling();
             this.hitungVolume();
             this.hitungLuasPermukaan();

            
            // 4. Tampilkan Hasil (Java akan memanggil tampilkanHasil() sesuai wujud aslinya berkat Polymorphism)
            if (logTarget != null) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Cetak nama pesertanya dulu
                        logTarget.append("[" + namaThread + "] Berhasil finish!\n");
                        
                        // Panggil hasil cetakan masing-masing
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
    