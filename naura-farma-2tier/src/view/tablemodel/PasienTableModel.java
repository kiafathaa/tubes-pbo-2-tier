package view.tablemodel;

import model.Pasien;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PasienTableModel extends AbstractTableModel {

    private List<Pasien> data = new ArrayList<>();
    private final String[] columnNames = {
        "ID", "Nama", "Email", "Umur", "Jenis Kelamin"
    };

    public void setData(List<Pasien> data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pasien p = data.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getId();
            case 1: return p.getNama();
            case 2: return p.getEmail();
            case 3: return p.getUmur();
            case 4: return p.getJenisKelamin();
            default: return null;
        }
    }
    public List<Pasien> getData() {
    return data;
}

}
