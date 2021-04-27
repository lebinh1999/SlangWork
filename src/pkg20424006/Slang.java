/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Le Duc Binh
 */
public class Slang implements Serializable {
    private String key;
    private int index;
    private List<String>means;
    
    
    public Slang(){
        means = new LinkedList<String>();
        index = 0;
    }
   
    
    public String getKey (){
        return key;
    }
    
    public void setKey (String Key){
        this.key = Key;
    }
    public Slang(String Key){
        this.key = Key;
        index= 0;
    }
    
}
