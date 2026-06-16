/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

import static projekbelahketupat.BangunGeometri.logTarget;

/**
 *
 * @author ACER
 */
public class LimasBelahKetupat extends BelahKetupat implements Runnable{
    
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

      
    public LimasBelahKetupat(double d1, double d2, double t){
        super(d1, d2);
        this.tinggiLimas = t;
    }
    
    
    public void setTinggiLimas(double tinggiLimas) {
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException ("nilai tinggi tidak boleh <= 0");
        }
        this.tinggiLimas = tinggiLimas;
    }
    
    public double getTinggiLimas(){
    return tinggiLimas;
    }
        
    public double hitungVolume(){
        if (super.luas <=0 || super.sisi <=0) {
            throw new IllegalArgumentException ("pastikan luas dan tinggi sudah di hitung dan tidak <= 0");
        }
        this.volume = (1.0 / 3.0) * super.luas * this.tinggiLimas;
        return volume;
    }
    
    public double hitungVolume(double d1, double d2, double tinggiLimas){
        if (d1 <= 0 || d2 <= 0 || tinggiLimas <=0) {
            throw new IllegalArgumentException ("nilai d1, d2 dan tinggi tidak boleh <= 0");
        }
        this.volume = (1.0 / 3.0) * super.hitungLuas(d1, d2) * tinggiLimas;
        return volume;
    }
    
    public double hitungLuasPermukaan() {
        if (this.tinggiLimas <= 0 || super.sisi <= 0) {
            throw new IllegalArgumentException ("pastikan sisi sudah dihitung dan tidak <= 0 dan nilai tinggi tidak <= 0");
        }
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(super.sisi / 2, 2));
        this.luasPermukaan = super.luas + (4 * (0.5 * super.sisi * tinggiSegitigaTegak));
        return luasPermukaan;
    }
    
    public double hitungLuasPermukaan(double tinggiLimas, double sisi, double d1, double d2){
        if (d1 <= 0 || d2 <= 0 || tinggiLimas <=0 || sisi <=0) {
            throw new IllegalArgumentException ("nilai d1, d2, tinggi dan sisi tidak boleh <= 0");
        }
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(sisi / 2, 2));
        this.luasPermukaan = super.hitungLuas(d1, d2) + (4 * (0.5 * sisi * tinggiSegitigaTegak));
        return luasPermukaan;
    }
    
    @Override
    public void tampilkanHasil() {
        
        BelahKetupat.logTarget.append("Volume Limas Belah Ketupat: " + this.volume + "\n");
        BelahKetupat.logTarget.append("Luas Permukaan Limas Belah Ketupat: " + this.luasPermukaan + "\n");
        BelahKetupat.logTarget.append("------------------------------------\n");
        

    }
    
@Override
    public void run() { 
        try {
            final String namaThread = Thread.currentThread().getName();
                           
            int waktuTunda = 500 + (int)(Math.random() * 1000);; 
            

             super.hitungSisi();
             barProses.setValue(20);
             Thread.sleep(waktuTunda);
            
             super.hitungLuas();
             barProses.setValue(40);
             Thread.sleep(waktuTunda);
            
             super.hitungKeliling();
             barProses.setValue(60);
             Thread.sleep(waktuTunda);
            
             this.hitungVolume();
             barProses.setValue(80);
             Thread.sleep(waktuTunda);
            
             this.hitungLuasPermukaan();

            
         
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
            e.printStackTrace();
        }
    }
    
}    