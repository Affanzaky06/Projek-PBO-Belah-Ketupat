/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projekbelahketupat;

/**
 *
 * @author ACER
 */
public class ProjekBelahKetupat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Tipe datanya Super Class, tapi instansiasinya Sub Class(Polymorphism)
        BelahKetupat bangun1 = new PrismaBelahKetupat(10, 12, 15);
        BelahKetupat bangun2 = new LimasBelahKetupat(10, 12, 15);
        BelahKetupat bangun3 = new BelahKetupat(50, 70);

        // Akan memanggil method sesuai dengan wujud objek aslinya (Sub Class)
        bangun1.tampilkanHasil();
        System.out.println(" ");
        bangun2.tampilkanHasil();
        System.out.println(" ");
        bangun3.tampilkanHasil();
    }
    
}
