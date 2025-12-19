package service;

import dao.PasienDao;
import dao.mysql.PasienDaoMysql;
import model.Pasien;

import java.util.List;

public class PasienServiceDefault implements PasienService {

    private final PasienDao dao = new PasienDaoMysql();

    @Override
    public void save(Pasien pasien) {
        if (pasien.getId() == 0) {
            dao.insert(pasien);
        } else {
            dao.update(pasien);
        }
    }

    @Override
    public void delete(Pasien pasien) {
        dao.delete(pasien.getId());
    }

    @Override
    public List<Pasien> getAll() {
        return dao.findAll();
    }
}
