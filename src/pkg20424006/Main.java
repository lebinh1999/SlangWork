/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    static final String source = "../20424006/src/pkg20424006/";
    static final String NewSlang = source + "Newslang.txt";
    public static ArrayList<String> history = new ArrayList<String>();
    
    
      public static void saveHistory(String fileName) {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);

            for (String str : history) {
                fileWriter.write(str + "\n");
            }

            fileWriter.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //read data from history variable and write down that data to history.txt file 
    public static ArrayList<String> readHistory(String fileName) {
        ArrayList<String> history = new ArrayList<String>();

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                history.add(line);
            }

            fileReader.close();
            bufferedReader.close();

        } catch (Exception ex) {
            System.out.println("Something goes wrong: " + ex);
        }

        return history;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        QLSlang QL = new QLSlang();
        SlangGroup SG = new SlangGroup();
        QL.readSlangFile("../20424006/src/pkg20424006/slang.txt");
//        QL.WriteFile(NewSlang);
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
            System.out.println("1.T??m ki???m theo slang word");
            System.out.println("2.T??m ki???m theo definition");
            System.out.println("3.Hi???n th??? history , danh s??ch ???? t??m ki???m");
            System.out.println("4.Add 1 slang words m???i, confirm n???u b??? trung keyworks");
            System.out.println("5.Edit 1 slang word.");

            // nhap chon vao day
            System.out.println("Nhap lua chon:");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nh???p t??? kh??a keywork ????? t??m ki???m :\n");
                    String key = sc.nextLine();
                    Slang s = SG.findBySlangWord(key);
                    history.add(key);
                    if (s != null) {
                        System.out.println("=====SLANG WORD====");
                        for (String str : s.getNghia()) {
                            System.out.println("ngh??a c???a t??? :" + str);
                        }
                    } else {
                        System.out.println("kh??ng t??m th???y");
                    }
                    break;
                case 2:
                    System.out.print("Nh???p t??? definition t??m ki???m :");
                    String def = sc.nextLine();
                    List<Slang> lstSlang = SG.findBySlangWordDefinition(def);
                    if (lstSlang != null && lstSlang.size() > 0) {
                        System.out.println("=========SLANG definition ==========");
                        for (Slang sl : lstSlang) {
                            System.out.println("T??? c???a :" + sl.getKey());
                        }
                    } else {
                        System.out.println("Kh??ng th??? t??m th???y ngh??a c???n t??m");
                    }
                    break;
                    
                case 3 :
                     System.out.print("History: ");
                     System.out.println(history.toString());
                    break;
                    
                case 4:
                    Slang SLadd =  new Slang();
                    SLadd.Inputconfirm(sc, QL.getLstGroup().size());
                    System.out.println("T??? ???? b??? commit b???n c?? mu???n th??m");
                    System.out.println("|   YES          CANCEL   |");
                    System.out.print("C??u tr??? l???i c???a b???n:");
                    String confirm = sc.nextLine();
                    if(confirm.equals("Exit"))
                            break;
//                    QL.addGroup(SLadd, NewSlang);
                    break;             
                default:
                    break;
            }

        }

    }

}
