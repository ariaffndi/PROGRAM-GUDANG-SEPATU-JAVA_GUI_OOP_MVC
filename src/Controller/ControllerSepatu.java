package Controller;

import Entity.EntitySepatuSpesifik;
import Model.ModelSepatu;

import java.util.ArrayList;

public class ControllerSepatu {
    ModelSepatu modelSepatu = new ModelSepatu();

    public void createSepatu(String merk, String jenis, String type, String warna, int ukuran, int stok, int lokasi) {
        modelSepatu.createSepatu(merk, jenis, type, warna, ukuran, stok, lokasi);
    }

    public ArrayList <EntitySepatuSpesifik> readDataSepatu() {
        return modelSepatu.readSepatu();
    }

    public void updateDataSepatu(String type, String jenis, String warna, int ukuran, int lokasi ){
        modelSepatu.updateInfoSepatu(type, jenis, warna, ukuran, lokasi);
    }

    public void updateStokSepatu(String type, int stok) {
        modelSepatu.updateStokSepatu(type,stok);
    }

    public void deleteSepatu(String type) {
        EntitySepatuSpesifik sepatu = modelSepatu.searchShoesByType(type);
        modelSepatu.deleteSepatu(sepatu);
    }

    public boolean findSepatuByType(String type) {
        EntitySepatuSpesifik sepatu = modelSepatu.searchShoesByType(type);
        return sepatu != null;
    }

    public boolean findSepatuByMerk(String merk) {
        EntitySepatuSpesifik sepatu = modelSepatu.searchShoesByMerk(merk);
        return sepatu != null;
    }

    public EntitySepatuSpesifik dataSepatu (String type) {
        return modelSepatu.searchShoesByType(type);
    }

}
