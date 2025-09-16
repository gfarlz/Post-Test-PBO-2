package model;

public class Donasi {
    public int id;
    public String namaDonatur;
    public double jumlah;
    public String penerima;

    public Donasi(int id, String namaDonatur, double jumlah, String penerima) {
        this.id = id;
        this.namaDonatur = namaDonatur;
        this.jumlah = jumlah;
        this.penerima = penerima;
    }

    @Override
    public String toString() {
        return id + ". " + namaDonatur + " - Rp" + jumlah + " → " + penerima;
    }
}
