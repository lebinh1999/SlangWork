/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Le Duc Binh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
//    private static boolean check = true;
    public final String source = "../20424006/src/pkg20424006/";
    public final String Slang = source + "slang.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        QLSlang QL = new QLSlang();
        SlangGroup SG = new SlangGroup();
        QL.readSlangFile("../20424006/src/pkg20424006/slang.txt");
//        for (SlangGroup g : QL.getLstGroup()) {
//
//            System.out.println(g.getGroupType());
//            for (Slang s : g.getLstSlang()) {
//                System.out.println(s.getKey() + " - " + s.getNghia().get(0));
//            }
//
//        }

        int chon = 0;

        while (chon != 11) {
            System.out.println("========= Menu ==========");
            System.out.println("1.Tìm kiếm theo slang word");
            System.out.println("2.Tìm kiếm theo definition");
            System.out.println("3.Hiển thị history , danh sách đã tìm kiếm");
            System.out.println("4.Add 1 slang words mới, confirm nếu bị trung keyworks");
            System.out.println("5.Edit 1 slang word.");

            // nhap chon vao day
            System.out.println("Nhap lua chon:");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhập từ khóa keywork để tìm kiếm :\n");
                    String key = sc.nextLine();
                    Slang s = SG.findBySlangWord(key);
                    if (s != null) {
                        System.out.println("=====SLANG WORD====");
                        for (String str : s.getNghia()) {
                            System.out.println("nghĩa của từ :" + str);
                        }
                    } else {
                        System.out.println("không tìm thấy");
                    }
                    break;
                case 2:
                    System.out.print("Nhập từ definition tìm kiếm :");
                    String def = sc.nextLine();
                    List<Slang> lstSlang = SG.findBySlangWordDefinition(def);
                    if (lstSlang != null && lstSlang.size() > 0) {
                        System.out.println("=========SLANG definition ==========");
                        for (Slang sl : lstSlang) {
                            System.out.println("Từ của :" + sl.getKey());
                        }
                    } else {
                        System.out.println("Không thể tìm thấy nghĩa cần tìm");
                    }
                    break;
                default:
                    break;
            }

        }

    }

}
