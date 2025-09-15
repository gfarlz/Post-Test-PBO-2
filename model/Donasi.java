package model;

public class Donasi {
    private int id;
    private String namaDonatur;
    private double jumlah;
    private String penerima;

    public Donasi(int id, String namaDonatur, double jumlah, String penerima) {
        this.id = id;
        this.namaDonatur = namaDonatur;
        this.jumlah = jumlah;
        this.penerima = penerima;
    }

    public int getId() {
        return id;
    }

    public String getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(String namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    @Override
    public String toString() {
        return id + ". " + namaDonatur + " - Rp" + jumlah + " → " + penerima;
    }
}
