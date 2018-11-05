/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class WetterStation implements Serializable
{
    private String palce;
    private int seaLvl;
    private float temp;
    private int humidity;

    public WetterStation(String palce, int seaLvl, float temp, int humidity)throws Exception
    {
        this.palce = palce;
        this.seaLvl = seaLvl;
        
        setTemp(temp);
        setHum(humidity);
    }
    
    public void setTemp(float temp)throws Exception
    {
        if(temp < -35 || temp > 45)
            throw new Exception("Es ist nur eine Temperatur zwischen -35 und +45 Grad erlaubt");
        this.temp = temp;
    }
    
    public void setHum(int hum)throws Exception
    {
        if(hum < 0 || hum > 100)
            throw  new Exception("Es ist nur eine Luftfeutchtigkeit zwischen 0 und 100% gültig");
        this.humidity = humidity;
    }

    public String getPalce()
    {
        return palce;
    }

    public int getSeaLvl()
    {
        return seaLvl;
    }

    public float getTemp()
    {
        return temp;
    }

    public int getHumidity()
    {
        return humidity;
    }
    
    
}
