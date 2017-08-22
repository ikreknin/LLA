package lv.bc.views;

import java.awt.Component;
import java.awt.Font;

import javax.swing.*;

public class FontCellRenderer extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
            JLabel label = (JLabel)super.getListCellRendererComponent(
                list,value,index,isSelected,cellHasFocus);
            Font font = new Font((String)value, Font.PLAIN, 17);
            label.setFont(font);
            return label;
        }	
	
}
