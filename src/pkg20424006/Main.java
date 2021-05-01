/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        
        QL.readSlangFile("../20424006/src/pkg20424006/slang.txt");
        

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
            chon = Integer.parseInt(sc.next());
            
            switch (chon) {
                case 1:
                    System.out.print("Nhập từ khóa keywork để ttim kiếm :");
                    String keyword = sc.nextLine();
                    //giờ mở file // nếu nó không trùng chữ cái đầu trong grouptype => dùng ls.charAt(0)=> loại luôn
                    //vi du: "Slang".charAt(0) => S //hieu khong
                    //ngược lại => vô đó tìm tuần tự ok để đó tí làm 
//                   
//                    if( s != null){ Slang s = QL.findGroup(keyword);
//                        System.out.println("=====slang====");
//                        for(String def : s.getNghia()) {
//                            System.out.println("->nghĩa:"+def);
//                        }
//                    }
//                    else {
//                        System.out.println("không tìm thấy");
//                    }
                    break;
            }

        }

    }

}
