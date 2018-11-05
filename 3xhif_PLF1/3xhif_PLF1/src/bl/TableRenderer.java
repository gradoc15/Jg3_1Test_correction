/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author User
 */
public class TableRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        JLabel l = new JLabel();
        l.setOpaque(true);
        
        WetterStation ws = (WetterStation) value;
        
        switch(column)
        {
            case 0: l.setText(ws.getPalce()); break;
            case 1: l.setText(""+ws.getSeaLvl()); break;
            case 2: l.setText(""+ws.getTemp()); break;
            case 3: l.setText(""+ws.getHumidity()); break;
            default: l.setText("ERROR");
        }
        
        if(ws.getTemp() > 25 && ws.getHumidity() <= 20)
            l.setBackground(Color.yellow);
        else if(ws.getTemp() < 0 && ws.getHumidity() < 30)
            l.setBackground(Color.blue);
        else if(ws.getHumidity() > 50)
            l.setBackground(Color.green);
        
        return l;
    }
    
}
