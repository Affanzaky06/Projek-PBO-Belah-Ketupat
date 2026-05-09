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
        System.out.println("=== UJI BEBAN MULTITHREADING DENGAN DATA RANDOM ===\n");

        int jumlahData = 10000; // Kita coba buat 5 bangun ruang sekaligus
        Thread[] kumpulanThread = new Thread[jumlahData];

        for (int i = 0; i < jumlahData; i++) {
            // Generate angka random antara 10.0 sampai 50.0
            double randD1 = 10 + (Math.random() * 40);
            double randD2 = 10 + (Math.random() * 40);
            double randTinggi = 10 + (Math.random() * 40);

            // BUKTI POLYMORPHISM di dalam Looping
            BelahKetupat bangun; 
            
            bangun = new PrismaBelahKetupat(randD1, randD2, randTinggi);
            bangun = new LimasBelahKetupat(randD1, randD2, randTinggi);
            bangun = new BelahKetupat(randD1, randD2);
            // Jika angkanya genap buat Prisma, jika ganjil buat Limas
            
//            if (i % 2 == 0) {
//                bangun = new PrismaBelahKetupat(randD1, randD2, randTinggi);
//            } else {
//                bangun = new LimasBelahKetupat(randD1, randD2, randTinggi);
//            }

            // Memasukkan objek ke dalam array Thread dan langsung di-START!
            kumpulanThread[i] = new Thread(bangun, "Thread-" + i);
            kumpulanThread[i].start();
        }

        // BUKTI SINKRONISASI: Main Thread menunggu semua anak Thread selesai
        for (int i = 0; i < jumlahData; i++) {
            try {
                kumpulanThread[i].join();
            } catch (InterruptedException e) {}
        }

        System.out.println("=== SEMUA PERHITUNGAN MASSAL SELESAI ===");
    }
        
    }
//        // Tipe datanya Super Class, tapi instansiasinya Sub Class(Polymorphism)
//        
//        BelahKetupat bangun1 = new PrismaBelahKetupat(10, 12, 15);
//        BelahKetupat bangun2 = new LimasBelahKetupat(10, 12, 15);
//        BelahKetupat bangun3 = new BelahKetupat(50, 70);
//        BelahKetupat bangun4 = new PrismaBelahKetupat(14, 16, 18);
//        BelahKetupat bangun5 = new LimasBelahKetupat(100, 120, 150);
//        BelahKetupat bangun6 = new PrismaBelahKetupat(140, 128, 157);
//        
//        
//        
//        // Multithread
//        Thread thread1 = new Thread(bangun1);
//        Thread thread2 = new Thread(bangun2);
//        Thread thread3 = new Thread(bangun3);
//        Thread thread4 = new Thread(bangun4);
//        Thread thread5 = new Thread(bangun5);
//        Thread thread6 = new Thread(bangun6);
//        
//        System.out.println("=> Memulai proses perhitungan secara paralel(Multithreading)...\n");
//        
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        
//        
//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//            thread4.join();
//            thread5.join();
//            thread6.join();
//        } catch (InterruptedException e) {
//            System.out.println("Eksekusi thread terganggu!");
//        }
//        
//        System.out.println("\n=== SEMUA PERHITUNGAN SELESAI ===");
//        
//        // Akan memanggil method sesuai dengan wujud objek aslinya (Sub Class)
////        bangun1.tampilkanHasil();
////        System.out.println(" ");
////        bangun2.tampilkanHasil();
////        System.out.println(" ");
////        bangun3.tampilkanHasil();
//    }
//    
//}
