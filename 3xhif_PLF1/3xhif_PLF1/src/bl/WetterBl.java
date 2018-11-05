/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class WetterBl extends AbstractTableModel
{
    private ArrayList<WetterStation> data = new ArrayList();
    private final String[] titel = {"Place", "Sealevel","Temperature","Humidity"};
    private boolean hide = false;
    
    public void add(WetterStation ws)
    {
        data.add(ws);
        fireTableRowsInserted(data.size()-1, data.size()-1);
        
        sort();
    }
    
    public void del(int idx)
    {
        data.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }
    
    public void sort()
    {
        Collections.sort(data, new compName());
        fireTableDataChanged();
    }
    
    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        
        WetterStation ws = null;
        while((ws = (WetterStation)ois.readObject()) != null)
        {
            data.add(ws);
        }
    }
    
    public void save(File f) throws FileNotFoundException, IOException
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        
        for(WetterStation ws : data)
        {
            oos.writeObject(ws);
        }
    }

    @Override
    public int getRowCount()
    {
        return data.size();
    }

    @Override
    public int getColumnCount()
    {
        if(hide)
            return titel.length-1;
        
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
        if(hide)
            return titel[idx > 0 ? idx+1 : idx];
        
        return titel[idx];
    }

    public void setHide(boolean hide)
    {
        this.hide = hide;
        fireTableStructureChanged();
    }
    
    
}
