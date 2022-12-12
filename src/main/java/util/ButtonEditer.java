/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import view.ChiTietHoaDonJdialog;
import view.HoaDonJpanel;
import view.TrangChu;

/**
 *
 * @author admin
 */
public class ButtonEditer extends DefaultCellEditor {

    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditer(JTextField textField) {
        super(textField);
        btn = new JButton();
        btn.setOpaque(true);

        btn.addActionListener((ActionEvent e) -> {
            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        lbl = (value == null) ? "" : value.toString();
        btn.setSize(10, 10);
        btn.setText(lbl);
        clicked = true;
        return btn;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            new ChiTietHoaDonJdialog(new TrangChu(), true).setVisible(true);
            clicked = false;
        }
        return lbl;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

}

