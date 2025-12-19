package view;

import view.tablemodel.PasienTableModel;

import javax.swing.*;
import java.awt.*;

public class PasienFrame extends JFrame {

    private JTable table;
    private PasienTableModel tableModel;

    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnRefresh;

    public PasienFrame() {
        setTitle("NAURA FARMA - Data Pasien");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        // ===== Table =====
        tableModel = new PasienTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // ===== Button Panel =====
        btnAdd = new JButton("Tambah");
        btnDelete = new JButton("Hapus");
        btnRefresh = new JButton("Refresh");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        // ===== Layout =====
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // ================== GETTER (WAJIB UNTUK CONTROLLER) ==================

    public PasienTableModel getTableModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }
}
