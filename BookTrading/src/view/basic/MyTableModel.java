package view.basic;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class MyTableModel extends AbstractTableModel {
    Vector<Vector<String>> data;
    Vector<String> name;

    public MyTableModel(Vector<Vector<String>> data, Vector<String> name) {
        this.data = data;
        this.name = name;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return name.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.elementAt(rowIndex).elementAt(columnIndex);
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public String getColumnName(int col) {
        return name.elementAt(col);
    }
}
