package service;

import java.util.List;
import model.Pasien;

public interface PasienService {
    void save(Pasien pasien);
    void delete(Pasien pasien);
    List<Pasien> getAll();
}
