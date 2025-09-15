package service;

import model.Donasi;
import java.util.ArrayList;
import java.util.Scanner;

public class DonasiService {
    private ArrayList<Donasi> listDonasi = new ArrayList<>();
    private int nextId = 1;
    private Scanner scanner = new Scanner(System.in);

    public void tambahDonasi() {
        System.out.print("Nama Donatur: ");
        String nama = scanner.nextLine();

        double jumlah = 0;
        while (true) { // validasi input angka
            try {
                System.out.print("Jumlah Donasi: ");
                jumlah = Double.parseDouble(scanner.nextLine());
                if (jumlah <= 0) {
                    System.out.println("Jumlah harus lebih dari 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka!");
            }
        }

        System.out.print("Penerima: ");
        String penerima = scanner.nextLine();

        Donasi donasi = new Donasi(nextId++, nama, jumlah, penerima);
        listDonasi.add(donasi);
        System.out.println("✅ Donasi berhasil ditambahkan!");
    }

    public void tampilkanDonasi() {
        if (listDonasi.isEmpty()) {
            System.out.println("Belum ada donasi.");
        } else {
            for (Donasi d : listDonasi) {
                System.out.println(d);
            }
        }
    }

    public void editDonasi() {
        System.out.print("Masukkan ID Donasi yang akan diubah: ");
        int id = Integer.parseInt(scanner.nextLine());

        Donasi target = cariById(id);
        if (target == null) {
            System.out.println("❌ Donasi tidak ditemukan!");
            return;
        }

        System.out.print("Nama Donatur baru (kosong = tidak diubah): ");
        String nama = scanner.nextLine();
        if (!nama.isEmpty()) target.setNamaDonatur(nama);

        System.out.print("Jumlah baru (kosong = tidak diubah): ");
        String jumlahInput = scanner.nextLine();
        if (!jumlahInput.isEmpty()) {
            try {
                target.setJumlah(Double.parseDouble(jumlahInput));
            } catch (NumberFormatException e) {
                System.out.println("Input jumlah tidak valid, tidak diubah.");
            }
        }

        System.out.print("Penerima baru (kosong = tidak diubah): ");
        String penerima = scanner.nextLine();
        if (!penerima.isEmpty()) target.setPenerima(penerima);

        System.out.println("✅ Donasi berhasil diperbarui!");
    }

    public void hapusDonasi() {
        System.out.print("Masukkan ID Donasi yang akan dihapus: ");
        int id = Integer.parseInt(scanner.nextLine());

        Donasi target = cariById(id);
        if (target == null) {
            System.out.println("❌ Donasi tidak ditemukan!");
            return;
        }

        listDonasi.remove(target);
        System.out.println("✅ Donasi berhasil dihapus!");
    }

    
    public void cariDonasi() {
        System.out.print("Masukkan kata kunci pencarian: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Donasi d : listDonasi) {
            if (d.getNamaDonatur().toLowerCase().contains(keyword) || 
                d.getPenerima().toLowerCase().contains(keyword)) {
                System.out.println(d);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ Tidak ada hasil pencarian.");
        }
    }

 
    private Donasi cariById(int id) {
        for (Donasi d : listDonasi) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
}
