package main;

import service.DonasiService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DonasiService service = new DonasiService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU DONASI ===");
            System.out.println("1. Tampilkan Donasi");
            System.out.println("2. Tambah Donasi");
            System.out.println("3. Edit Donasi");
            System.out.println("4. Hapus Donasi");
            System.out.println("5. Cari Donasi");
            System.out.println("6. Keluar");

            int pilihan = -1;
            try {
                System.out.print("Pilih menu: ");
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1 -> service.tampilkanDonasi();
                case 2 -> service.tambahDonasi();
                case 3 -> service.editDonasi();
                case 4 -> service.hapusDonasi();
                case 5 -> service.cariDonasi();
                case 6 -> {
                    running = false;
                    System.out.println("Terima kasih, program selesai!");
                }
                default -> System.out.println(" Pilihan tidak valid!");
            }
        }
    }
}
