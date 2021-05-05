/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Le Duc Binh
 */
public class SlangGroup {

    private char groupType;
    //vô đây
    private List<Slang> lstSlang;

    public SlangGroup(char type) {
        this.groupType = type;
        lstSlang = new LinkedList<Slang>();
    }

    public SlangGroup() {
        lstSlang = new LinkedList<Slang>();
    }

    public char getGroupType() {
        return groupType;
    }

    public void setGroupType(char groupType) {
        this.groupType = groupType;
    }

    public List<Slang> getLstSlang() {
        return lstSlang;
    }

    public void setLstSlang(List<Slang> lstSlang) {
        this.lstSlang = lstSlang;
    }

    public SlangGroup(char groupType, List<Slang> lstSlang) {
        super();
        this.groupType = groupType;
        this.lstSlang = lstSlang;
    }

    public Slang findBySlangWord(String key) {
        return lstSlang.stream().parallel().filter(p -> p.getKey().equals(key)).findFirst().orElse(null);
    }

    public List<Slang> findBySlangWordDefinition(String key) {
        return lstSlang.stream()
                .parallel()
                .filter(p -> p
                .getNghia()
                .stream()
                .anyMatch(n -> n.contains(key)))
                .collect(Collectors.toList());
    }

}
