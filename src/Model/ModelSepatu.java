package Model;

import Database.Database;
import Entity.EntitySepatuSpesifik;

import java.util.ArrayList;

public class ModelSepatu {


    public void createSepatu(String merk, String jenis, String type, String warna, int ukuran, int stok, int lokasi) {
        EntitySepatuSpesifik sepatu = new EntitySepatuSpesifik(merk, jenis, type, warna, ukuran, stok, lokasi);
        Database.databaseSepatu.add(sepatu);
    }

    public ArrayList<EntitySepatuSpesifik> readSepatu() {
        return Database.databaseSepatu;
    }

    public void updateInfoSepatu(String type, String jenis, String warna, int ukuran, int lokasi) {
        EntitySepatuSpesifik updateSepatu = searchShoesByType(type);
        updateSepatu.setJenis(jenis);
        updateSepatu.setWarna(warna);
        updateSepatu.setUkuran(ukuran);
        updateSepatu.setLokasi(lokasi);
    }

    public void updateStokSepatu(String type, int stok) {
        EntitySepatuSpesifik updateStokSepatu = searchShoesByType(type);
        updateStokSepatu.setStok(stok);
    }

    public void deleteSepatu(EntitySepatuSpesifik deleteSepatu) {
        Database.databaseSepatu.remove(deleteSepatu);
    }

    public EntitySepatuSpesifik searchShoesByType (String type) {
        EntitySepatuSpesifik findShoes = null;
        for (EntitySepatuSpesifik shoes : Database.databaseSepatu) {
            if (type.equals(shoes.getType())) {
                findShoes = shoes;
            }
        }
        return findShoes;
    }

    public EntitySepatuSpesifik searchShoesByMerk (String merk) {
        EntitySepatuSpesifik findShoes = null;
        for (EntitySepatuSpesifik shoes : Database.databaseSepatu) {
            if (merk.equals(shoes.getMerk())) {
                findShoes = shoes;
            }
        }
        return findShoes;
    }

}
