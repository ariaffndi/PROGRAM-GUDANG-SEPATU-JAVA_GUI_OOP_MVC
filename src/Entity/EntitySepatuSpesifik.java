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
        return "Sepatu Tersebut Berada Di Rak no - " + lokasi;
    }
    public void cetakInfo() {
        System.out.println("Merk \t: " + merk);
        System.out.println("Jenis \t: " + jenis);
        System.out.println("Tipe \t: " + type);
        System.out.println("Warna \t: " + warna);
        System.out.println("Ukuran \t: " + ukuran);
        System.out.println("Stok \t: " + stok);
        System.out.println(infoLokasi());
        System.out.println("---------------------");
    }

    public String getType() {
        return type;
    }

    public String getWarna() {
        return warna;
    }

    public int getUkuran() {
        return ukuran;
    }

    public int getStok() {
        return stok;
    }

    public int getLokasi() {
        return lokasi;
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
