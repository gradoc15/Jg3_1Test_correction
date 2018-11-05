/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.Comparator;

/**
 *
 * @author User
 */
public class compName implements Comparator<WetterStation>
{

    @Override
    public int compare(WetterStation o1, WetterStation o2)
    {
        if(o1.getPalce().hashCode() > o2.getPalce().hashCode())
            return 1;
        else if(o1.getPalce().hashCode() < o2.getPalce().hashCode())
            return -1;
        return 0;
    }
    
}
