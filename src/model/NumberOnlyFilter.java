/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author HoangHiep
 */
public class NumberOnlyFilter extends DocumentFilter{
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string.matches("\\d*")) {
            super.insertString(fb, offset, string, attr);
        } else {
            showError();
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text.matches("\\d*")) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            showError();
        }
    }

    private void showError() {
        JOptionPane.showMessageDialog(null, "Vui lòng chỉ nhập số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
    }
}
