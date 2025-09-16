# Post-Test-PBO-2

### Nama: Ghifari Al Azhar
### NIM: 2409116059

## DESKRIPSI PROGRAM
Program donasi ini merupakan sebuah aplikasi sederhana berbasis console yang digunakan untuk mengelola data donasi. Aplikasi ini memungkinkan pengguna untuk menambahkan data donasi baru, menampilkan daftar donasi yang sudah ada, mengubah data donasi tertentu, menghapus data donasi yang tidak diperlukan, serta mencari donasi berdasarkan nama donatur maupun penerima. Program ini dibuat menggunakan bahasa pemrograman Java dengan menerapkan konsep dasar seperti class, object, package, arraylist, dan access modifier. Dengan adanya program ini, proses pencatatan dan pengelolaan donasi dapat dilakukan secara lebih terstruktur dan mudah diakses.
## ALUR PROGRAM
1. Program dijalankan dari class App.
2. Pengguna ditampilkan menu utama (tampilkan donasi, tambah, edit, hapus, cari, keluar).
3. Pengguna memilih salah satu menu:
   - Jika memilih 1, program menampilkan semua data donasi.
   - Jika memilih 2, program meminta input donasi baru lalu menyimpannya.
   - Jika memilih 3, program meminta ID donasi yang ingin diubah lalu memperbarui datanya.
   - Jika memilih 4, program meminta ID donasi lalu menghapus data tersebut.
   - Jika memilih 5, program meminta kata kunci pencarian dan menampilkan hasil yang cocok.
   - Jika memilih 6, program berhenti.
4. Proses akan berulang selama pengguna belum memilih keluar.

## STRUKTUR PACKAGE

<img width="362" height="148" alt="image" src="https://github.com/user-attachments/assets/45749dbf-ada5-483d-80ff-9d4dcc18769d" />

1. Package model
   - Berisi class Donasi yang digunakan sebagai model data atau cetakan objek donasi.
   - Menyimpan atribut seperti idDonasi, namaDonatur, dan jumlahDonasi, serta constructor untuk menginisialisasi objek.
   - Fungsi utama package ini adalah menyimpan struktur data yang akan digunakan oleh logika program.
2. Package service
   - Berisi class DonasiService yang berfungsi sebagai pengelola data donasi.
   - Di dalamnya terdapat logika CRUD: menambah (tambahDonasi), melihat (lihatDonasi), memperbarui (updateDonasi), menghapus (hapusDonasi), dan mencari donasi (cariDonasi).
   - Data donasi disimpan sementara dalam ArrayList.
   - Fungsi utama package ini adalah menangani semua operasi pada data sesuai input dari pengguna.
3. Package main
   - Berisi class Main yang menjadi titik masuk (entry point) program.
   - Menampilkan menu interaktif kepada pengguna dan menerima input pilihan.
   - Memanggil method-method di DonasiService sesuai pilihan menu.
   - Fungsi utama package ini adalah menghubungkan pengguna dengan logika CRUD yang ada di service.
  
## PENJELASAN CODE
**1. App.java**
```bash
package com.mycompany.main;

import java.util.Scanner;
import models.Donasi;
import service.DonasiService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DonasiService service = new DonasiService();
        int pilihan;

        do {
            System.out.println("\n=== Menu Donasi ===");
            System.out.println("1. Tambah Donasi");
            System.out.println("2. Lihat Donasi");
            System.out.println("3. Update Donasi");
            System.out.println("4. Hapus Donasi");
            System.out.println("5. Cari Donasi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Donatur: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Jumlah Donasi: ");
                    double jumlah = scanner.nextDouble();
                    service.tambahDonasi(new Donasi(id, nama, jumlah));
                    break;
                case 2:
                    service.lihatDonasi();
                    break;
                case 3:
                    System.out.print("Masukkan ID Donasi yang ingin diupdate: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan Jumlah Baru: ");
                    double jumlahBaru = scanner.nextDouble();
                    service.updateDonasi(idUpdate, namaBaru, jumlahBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID Donasi yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    service.hapusDonasi(idHapus);
                    break;
                case 5:
                    System.out.print("Masukkan ID Donasi yang dicari: ");
                    int idCari = scanner.nextInt();
                    Donasi hasil = service.cariDonasi(idCari);
                    if (hasil != null) {
                        System.out.println("Ditemukan -> ID: " + hasil.idDonasi +
                                           ", Nama: " + hasil.namaDonatur +
                                           ", Jumlah: " + hasil.jumlahDonasi);
                    } else {
                        System.out.println("Data donasi tidak ditemukan.");
                    }
                    break;
            }
        } while (pilihan != 0);
    }
}
```
Kode ini mendefinisikan class Main sebagai titik masuk (entry point) program.
Di dalamnya terdapat sebuah menu interaktif yang berisi pilihan:
   - Tambah Donasi
   - Lihat Donasi
   - Update Donasi
   - Hapus Donasi
   - Cari Donasi
   - Keluar
Program menggunakan Scanner untuk menerima input dari pengguna. Input tersebut diproses dengan switch-case yang kemudian memanggil method yang ada di DonasiService.
   - Jika memilih 1, pengguna bisa memasukkan ID, nama donatur, dan jumlah donasi → lalu data disimpan.
   - Jika memilih 2, program akan menampilkan daftar donasi yang ada.
   - Jika memilih 3, pengguna bisa memperbarui data donasi tertentu.
   - Jika memilih 4, data donasi bisa dihapus dengan memasukkan ID.
   - Jika memilih 5, pengguna bisa mencari donasi berdasarkan ID.
   - Jika memilih 6, program berhenti.
     
Secara keseluruhan, class ini berfungsi sebagai penghubung utama antara pengguna dengan logika CRUD yang ada di DonasiService.

**2.Donasi.java**
```bash
package models;

public class Donasi {
    public int idDonasi;
    public String namaDonatur;
    public double jumlahDonasi;

    public Donasi(int idDonasi, String namaDonatur, double jumlahDonasi) {
        this.id = id;
        this.namaDonatur = namaDonatur;
        this.jumlahDonasi = jumlahDonasi;
        this.penerima = penerima;
    }
}
```
Kode ini mendefinisikan class Donasi yang berfungsi sebagai cetakan objek donasi.
Terdapat tiga atribut:
   - idDonasi → untuk menyimpan ID unik donasi,
   - namaDonatur → untuk menyimpan nama penyumbang,
   - jumlahDonasi → untuk menyimpan jumlah nominal donasi,
   - penerima → untuk menyimpan nama penerima.
     
Selain itu, terdapat constructor yang digunakan untuk memberi nilai awal pada atribut setiap kali objek donasi dibuat. Class ini hanya berfungsi sebagai penyimpan data yang nantinya akan diolah pada DonasiService.


**3.DonasiService.java**
```bash
package service;

import model.Donasi;
import java.util.ArrayList;
import java.util.Scanner;

public class DonasiService {
    public ArrayList<Donasi> listDonasi = new ArrayList<>();
    public int nextId = 1;
    public Scanner scanner = new Scanner(System.in);

    // Constructor untuk isi data awal
    public DonasiService() {
        listDonasi.add(new Donasi(nextId++, "Budi Santoso", 500000, "Panti Asuhan Harapan"));
        listDonasi.add(new Donasi(nextId++, "Siti Aminah", 250000, "Yayasan Pendidikan"));
        listDonasi.add(new Donasi(nextId++, "Agus Pratama", 1000000, "Rumah Sakit Sosial"));
    }

    public void tambahDonasi() {
        System.out.print("Nama Donatur: ");
        String nama = scanner.nextLine();

        double jumlah = 0;
        while (true) {
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
        System.out.println("Donasi berhasil ditambahkan!");
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
            System.out.println("Donasi tidak ditemukan!");
            return;
        }

        System.out.print("Nama Donatur baru (kosong = tidak diubah): ");
        String nama = scanner.nextLine();
        if (!nama.isEmpty()) target.namaDonatur = nama;

        System.out.print("Jumlah baru (kosong = tidak diubah): ");
        String jumlahInput = scanner.nextLine();
        if (!jumlahInput.isEmpty()) {
            try {
                target.jumlah = Double.parseDouble(jumlahInput);
            } catch (NumberFormatException e) {
                System.out.println("Input jumlah tidak valid, tidak diubah.");
            }
        }

        System.out.print("Penerima baru (kosong = tidak diubah): ");
        String penerima = scanner.nextLine();
        if (!penerima.isEmpty()) target.penerima = penerima;

        System.out.println("Donasi berhasil diperbarui!");
    }

    public void hapusDonasi() {
        System.out.print("Masukkan ID Donasi yang akan dihapus: ");
        int id = Integer.parseInt(scanner.nextLine());

        Donasi target = cariById(id);
        if (target == null) {
            System.out.println("Donasi tidak ditemukan!");
            return;
        }

        listDonasi.remove(target);
        System.out.println("Donasi berhasil dihapus!");
    }

    public void cariDonasi() {
        System.out.print("Masukkan kata kunci pencarian: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Donasi d : listDonasi) {
            if (d.namaDonatur.toLowerCase().contains(keyword) || 
                d.penerima.toLowerCase().contains(keyword)) {
                System.out.println(d);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada hasil pencarian.");
        }
    }

    public Donasi cariById(int id) {
        for (Donasi d : listDonasi) {
            if (d.id == id) {
                return d;
            }
        }
        return null;
    }
}

```
Kode ini mendefinisikan class DonasiService yang bertugas mengelola seluruh data donasi. Data donasi disimpan dalam sebuah ArrayList bernama listDonasi.
   - Pada bagian constructor, program otomatis menambahkan 3 data donasi awal agar pengguna tidak mulai dari kondisi kosong.
   - Method tambahDonasi() memungkinkan pengguna menambahkan donasi baru dengan input nama, jumlah, dan penerima. Program juga memvalidasi agar jumlah donasi harus berupa angka dan lebih dari 0.
   - Method tampilkanDonasi() digunakan untuk menampilkan semua donasi yang sudah tersimpan.
   - Method editDonasi() memungkinkan pengguna mengubah data donasi tertentu berdasarkan ID. Setiap atribut bisa diubah atau dilewati dengan input kosong.
   - Method hapusDonasi() menghapus data donasi dari daftar berdasarkan ID.
   - Method cariDonasi() digunakan untuk mencari donasi berdasarkan nama donatur atau penerima dengan pencocokan kata kunci (case insensitive).
   - Method cariById() membantu mencari donasi spesifik berdasarkan ID, biasanya dipakai di edit dan hapus.

Secara keseluruhan, class ini adalah inti logika program karena semua operasi CRUD dan pencarian dipusatkan di dalamnya.

## Penjelasan MVC
1. Model (M) → Struktur Data
Bagian Model adalah class yang menyimpan data atau menjadi cetakan objek.
   - Pada program ini, bagian Model adalah Donasi.java.
   - Class ini berisi atribut seperti id, namaDonatur, jumlah, dan penerima.
   - Model hanya berfungsi untuk menyimpan data, tidak ada logika perhitungan atau proses bisnis.
   - Ibaratnya, Model ini adalah wadah data yang akan digunakan oleh Controller dan ditampilkan oleh View.

2. View (V) → Tampilan / Antarmuka
Bagian View bertugas menampilkan informasi dan berinteraksi dengan pengguna.
   - Pada program ini, bagian View ditangani oleh class App (atau Main.java).
   - Di sini terdapat menu interaktif yang ditampilkan ke layar:
     - Tampilkan Donasi
     - Tambah Donasi
     - Edit Donasi
     - Hapus Donasi
     - Cari Donasi
   - View juga menggunakan Scanner untuk menerima input dari pengguna.
   - Jadi, View adalah jembatan komunikasi antara pengguna dengan logika program.

3. Controller (C) → Logika / Pengendali
Bagian Controller berfungsi mengatur alur data antara Model dan View.
   - Pada program ini, bagian Controller adalah DonasiService.java.
   - Controller berisi logika CRUD (Create, Read, Update, Delete) serta pencarian.
   - Contoh: saat pengguna menekan menu “Tambah Donasi” di View, maka View akan memanggil method tambahDonasi() yang ada di Controller. Controller lalu mengolah input itu dengan membuat objek baru dari Model Donasi dan menyimpannya ke dalam ArrayList.
   - Jadi, Controller ini adalah otak utama yang mengatur jalannya program.

Kesimpulan MVC Program Donasi
   - Model = Donasi.java → menyimpan struktur data donasi.
   - View = App/Main.java → menampilkan menu, menerima input dari pengguna, dan menampilkan hasil ke layar.
   - Controller = DonasiService.java → mengatur logika CRUD donasi, menghubungkan data di Model dengan tampilan di View.
Dengan pola ini, program menjadi lebih terstruktur: data dipisah dari logika, dan logika dipisah dari tampilan. Kalau nanti programnya diperbesar (misalnya pakai database atau GUI), struktur MVC ini akan sangat membantu karena mudah dikembangkan

## PENJELASAN OUTPUT
**Menu 1**

<img width="583" height="284" alt="image" src="https://github.com/user-attachments/assets/c4640ef2-3df7-44ff-8708-13940f872971" />
<img width="613" height="111" alt="image" src="https://github.com/user-attachments/assets/71fe0ebb-e92e-4c72-8532-c3e202c908a6" />

Jika pengguna memilih menu Tambah Donasi, program akan meminta input berupa nama donatur, jumlah donasi, dan penerima donasi. Program juga sudah dilengkapi validasi: jika jumlah donasi yang dimasukkan bukan angka atau bernilai nol/negatif, maka akan muncul pesan kesalahan, lalu pengguna diminta mengulangi input. Setelah data benar, sistem otomatis membuat objek Donasi baru dengan ID yang unik (menggunakan nextId++) dan menambahkannya ke dalam listDonasi. Output akhirnya adalah pesan “Donasi berhasil ditambahkan!”, yang menandakan data berhasil tersimpan ke sistem.

**Menu 2**

<img width="496" height="137" alt="image" src="https://github.com/user-attachments/assets/c883b8cf-93b6-4799-ae03-38b2ca95469f" />

Saat pengguna memilih menu ini program akan melakukan iterasi pada seluruh objek Donasi di dalam listDonasi dan menampilkannya satu per satu. Outputnya biasanya berupa daftar nama donatur, jumlah, dan penerima. Dengan cara ini, pengguna bisa langsung melihat data donasi yang sudah masuk ke sistem.
**Menu 3**

<img width="619" height="162" alt="image" src="https://github.com/user-attachments/assets/69fb275a-bc8d-486e-94d2-0674a35ddd4a" />

Menu ini digunakan untuk mengubah data donasi yang sudah ada. Program pertama-tama meminta pengguna memasukkan ID donasi yang ingin diubah. Program akan memberi kesempatan pengguna untuk mengisi data baru: nama donatur, jumlah, dan penerima. Jika pengguna menekan Enter tanpa mengetikkan apapun, maka data lama tidak akan berubah. Setelah semua perubahan selesai, program menampilkan output “Donasi berhasil diperbarui!”. Dengan cara ini, pengguna bisa memperbaiki data yang salah tanpa perlu menghapus lalu menambahkan ulang.

**Menu 4**

<img width="506" height="85" alt="image" src="https://github.com/user-attachments/assets/1207b5d4-9275-4d77-a720-a1a4a76cddb4" />

Menu hapus dipakai untuk menghilangkan donasi tertentu dari daftar. Program akan meminta ID donasi sebagai acuan. Data tersebut langsung dihapus dari listDonasi. Setelah berhasil, program menampilkan pesan “Donasi berhasil dihapus!”. Dengan adanya menu ini, data donasi yang tidak relevan atau salah input bisa dibersihkan dari sistem.

**Menu 5**

<img width="496" height="95" alt="image" src="https://github.com/user-attachments/assets/1304903e-d33a-4a37-bd4e-681bfd163920" />

Menu pencarian ini memungkinkan pengguna menemukan data donasi tertentu berdasarkan kata kunci. Program akan meminta pengguna mengetikkan sebuah keyword, lalu sistem akan mencocokkan kata kunci tersebut dengan nama donatur atau penerima donasi. Jika ada data yang cocok, program menampilkan semua hasil yang sesuai. Fitur ini sangat membantu saat data donasi sudah banyak, sehingga pengguna tidak perlu mencari manual di daftar panjang.

**Menu 6**

<img width="824" height="184" alt="image" src="https://github.com/user-attachments/assets/0856424e-92d1-432f-8eb2-bbac371eccd0" />

**Validasi Input**

<img width="338" height="60" alt="image" src="https://github.com/user-attachments/assets/ff86fa54-1a9e-4559-b3fd-971336937594" />
<img width="428" height="130" alt="image" src="https://github.com/user-attachments/assets/c3fa45fa-c58b-4f80-be5a-35f4456da01e" />
