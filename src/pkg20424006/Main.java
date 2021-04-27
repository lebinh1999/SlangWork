/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.util.Scanner;

/**
 *
 * @author Le Duc Binh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static boolean check = true;
    
    public final String source = "../20424006/src/pkg20424006/";
    public final String Slang = source + "slang.txt";
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        QLSlang ql = new QLSlang();
        
        int chon =0;
        
        while(chon != 11){
            System.out.println("========= Menu ==========");
            System.out.println("1.Tìm kiếm theo slang word");
            System.out.println("2.Tìm kiếm theo definition");
            System.out.println("3.Hiển thị history , danh sách đã tìm kiếm");
            System.out.println("4.Add 1 slang words mới, confirm nếu bị trung keyworks");
            System.out.println("5.Edit 1 slang word.");
            switch(chon){
                case 1: 
                    System.out.print("Nhập từ khóa keywork để tim kiếm :");
                    String key = sc.nextLine();
                    Slang s = ql.findKeyWord(key);
                    break;
            }
            
        }
        
    }
    
}
