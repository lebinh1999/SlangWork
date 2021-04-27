/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.util.List;

/**
 *
 * @author Le Duc Binh
 */
public class QLSlang {
    private List<Slang>qlSlang;
    
    
    public Slang findKeyWord (String key) {
        return qlSlang.stream().parallel().filter(s -> s.getKey().equals(key)).findFirst().get();
    }
    
    
}
