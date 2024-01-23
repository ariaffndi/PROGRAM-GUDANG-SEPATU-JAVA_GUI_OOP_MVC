package Entity;

public abstract class EntitySepatuGeneral {
    protected String merk, jenis;

    public EntitySepatuGeneral(String merk, String jenis) {
        this.merk = merk;
        this.jenis = jenis;
    }

    public String infoLokasi() {
        return "Sepatu tersebut berada di Rak no - 0";
    };
    public abstract void cetakInfo();

    public String getJenis() {
        return jenis;
    }

    public String getMerk() {
        return merk;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
