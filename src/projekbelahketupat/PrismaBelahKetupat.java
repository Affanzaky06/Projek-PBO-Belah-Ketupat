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
    
    public double hitungVolume(){
        return super.hitungLuas()*tinggiPrisma;
    }
    
    public double hitungLuasPermukaan(){
        return ((2*super.hitungLuas()) + super.hitungKeliling()*tinggiPrisma);
    }
    @Override
    public void tampilkanHasil() {
        System.out.println("Volume Prisma Belah Ketupat: " + hitungVolume());
        System.out.println("Luas Permukaan Prisma Belah Ketupat: " + hitungLuasPermukaan());
    }
        
}
