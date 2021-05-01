/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Le Duc Binh
 */
public class Slang implements Serializable {

    private static final long serialVersionUID = 1L;
    private String key;
    private List<String> nghia;
    private int index;

    public Slang() {
        nghia = new LinkedList<String>();
        index = 0;
    }

    public Slang(String key) {
        this.key = key;
        nghia = new LinkedList<String>();
        index = 0;
    }

    public void addSlang(String key, String nghiaS, int index) {
        this.key = key;
        nghia.add(nghiaS);
        this.index = index;
    }

    public int hashCode() {
        return key.length() + 31;
    }

    public void print() {
        System.out.println("Từ:" + key);
        if (nghia != null && nghia.size() > 0) {
            for (String s : nghia) {
                System.out.println("->nghĩa:" + s);
            }
        } else {
            System.out.println("KHÔNG CÓ NGHĨA TỪ !!!");
        }
    }

    public void inputSlang(Scanner scanner, int index) {
        System.out.print("Nháº­p Tá»« Slang:");
        String s;
        key = scanner.nextLine();
        nghia = new LinkedList<String>();
        while (true) {
            System.out.print("Nhập nghĩa Của Từ(Nhấn N hoặc n để thoát):");
            s = scanner.nextLine();
            if (s.equals("N") || s.equals("n")) {
                break;
            }
            nghia.add(s);

        }
        this.index = index;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Slang)) {
            return false;
        }
        Slang o = (Slang) obj;
        return o.key.equals(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String Key) {
        this.key = Key;
    }

    public List<String> getNghia() {
        return nghia;
    }

    public void setNghia(List<String> nghia) {
        this.nghia = nghia;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Slang(String key, List<String> nghia, int index) {
        super();
        this.key = key;
        this.nghia = nghia;
        index = 0;
    }

}
