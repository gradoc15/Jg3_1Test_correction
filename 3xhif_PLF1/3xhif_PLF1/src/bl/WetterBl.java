/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class WetterBl extends AbstractTableModel
{
    private ArrayList<WetterStation> data = new ArrayList();
    private final String[] titel = {"Place", "Sealevel","Temperature","Humidity"};
    
    public void add(WetterStation ws)
    {
        data.add(ws);
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }
    
    public void del(int idx)
    {
        data.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }

    @Override
    public int getRowCount()
    {
        return data.size();
    }

    @Override
    public int getColumnCount()
    {
        return titel.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return data.get(rowIndex);
    }
    
    @Override
    public String getColumnName(int idx)
    {
        return titel[idx];
    }
}
