/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekbelahketupat;

/**
 *
 * @author ACER
 */
public class PrismaBelahKetupat extends BelahKetupat{
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;
    
   
    public PrismaBelahKetupat(){
        super();
        this.tinggiPrisma = 0;
    }
    
    public PrismaBelahKetupat(double d1, double d2, double tinggiPrisma){
        super(d1,d2);
        this.tinggiPrisma = tinggiPrisma;
    }
    
    public void setTinggiPrisma(double tinggiPrisma){
        this.tinggiPrisma = tinggiPrisma;
    }
    
    public double getTinggiPrisma(){
        return tinggiPrisma;
    }
    
    public double getVolume(){ 
        return volume; 
    }
    
    public double getLuasPermukaan(){ 
        return luasPermukaan; 
    }
    
   public void hitungVolume() {
        this.volume = this.luas * this.tinggiPrisma;
    }
    
    public void hitungLuasPermukaan() {
        this.luasPermukaan = ((2 * this.luas) + (this.keliling * this.tinggiPrisma));
    }
    @Override
    public void tampilkanHasil() {
        
        BelahKetupat.logTarget.append("Volume Prisma Belah Ketupat: " + this.volume+ "\n");
        BelahKetupat.logTarget.append("Luas Permukaan Prisma Belah Ketupat: " + this.luasPermukaan+ "\n");
        BelahKetupat.logTarget.append("------------------------------------\n");

    }
    
  @Override
    public void run() {
        try {
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
            
            
            int waktuTunda = 500 + (int)(Math.random() * 1000); 
            Thread.sleep(waktuTunda);
            

     
             super.hitungS();
             super.hitungLuas();
             super.hitungKeliling();
             this.hitungVolume();
             this.hitungLuasPermukaan();

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
