package controller;

import model.Pasien;
import service.PasienService;
import service.PasienServiceDefault;
import view.PasienDialog;
import view.PasienFrame;

import javax.swing.*;
import java.util.List;

public class PasienController {

    private final PasienFrame frame;
    private final PasienService service = new PasienServiceDefault();

    public PasienController(PasienFrame frame) {
        this.frame = frame;
        initListener();
        loadData();
    }

    // ================== LISTENER ==================
    private void initListener() {

        // ===== TAMBAH =====
        frame.getBtnAdd().addActionListener(e -> {
            PasienDialog dialog = new PasienDialog(frame);
            dialog.getBtnSave().addActionListener(ev -> {
                try {
                    Pasien p = dialog.getPasien();
                    service.save(p);
                    dialog.dispose();
                    loadData();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Input tidak valid!");
                }
            });
            dialog.setVisible(true);
        });

        // ===== HAPUS =====
        frame.getBtnDelete().addActionListener(e -> {
            int row = frame.getTable().getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(frame, "Pilih data dulu!");
                return;
            }

            Pasien p = frame.getTableModel().getData().get(row);
            int confirm = JOptionPane.showConfirmDialog(
                    frame,
                    "Hapus pasien " + p.getNama() + "?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                service.delete(p);
                loadData();
            }
        });

        // ===== REFRESH =====
        frame.getBtnRefresh().addActionListener(e -> loadData());
    }

    // ================== LOAD DATA ==================
    private void loadData() {
        List<Pasien> list = service.getAll();
        frame.getTableModel().setData(list);
    }
}
