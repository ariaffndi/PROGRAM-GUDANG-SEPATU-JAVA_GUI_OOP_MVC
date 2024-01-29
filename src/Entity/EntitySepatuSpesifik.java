package Entity;

public class EntitySepatuSpesifik extends EntitySepatuGeneral {
    private String type, warna;
    private int ukuran, stok, lokasi;

    public EntitySepatuSpesifik(String merk, String jenis, String type, String warna, int ukuran, int stok, int lokasi) {
        super(merk, jenis);
        this.type = type;
        this.warna = warna;
        this.ukuran = ukuran;
        this.stok = stok;
        this.lokasi = lokasi;
    }

    @Override
    public String infoLokasi() {
        return "\nSepatu Tersebut Berada Di Rak no - " + lokasi;
    }
    public String cetakInfo() {
        return
        "Merk \t: " + merk +
        "\nJenis \t: " + jenis +
        "\nTipe \t: " + type +
        "\nWarna \t: " + warna +
        "\nUkuran \t: " + ukuran +
        "\nStok \t: " + stok +
        infoLokasi();
    }

    public String getType() {
        return type;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    public void setLokasi(int lokasi) {
        this.lokasi = lokasi;
    }

}
