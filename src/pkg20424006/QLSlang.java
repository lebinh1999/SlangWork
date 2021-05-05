/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424006;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author Le Duc Binh
 */
public class QLSlang {
    private List<SlangGroup> lstGroup;
     
//    Hàm đoc Slang
    public void readSlangFile(String filePath) throws FileNotFoundException, IOException, InterruptedException {
        lstGroup = new LinkedList<SlangGroup>();
        long start = System.currentTimeMillis();
        try (BufferedReader br
                = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] ls = line.split("`", 2);

                List<String> defsList = new LinkedList<String>();

               // nếu ls[1] có kí hiệu |
                
                if (ls[1].contains("|")) {
                    String[] defs = ls[1].split("\\|");
                    for (String s : defs) {
                        defsList.add(s);
                    }
                }   // nếu ls[1] không có kí hiệu này
                else {
                    defsList.add(ls[1]);
                }

                addGroup(ls[0], defsList);
            }
        }
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time to load file " + formatter.format((end - start) / 1000d) + " seconds");
    }

    //hàm này là thêm 1 group dựa vào việc thêm 1 word và list-defs
    //lưu ý: cách đánh số của 1 Slang group sẽ từ 0->n
    // - đối với 1 group mới index ban đầu sẽ là 0
    // - đối với 1 group đã tồn tại sẽ có 2 trường hợp
    // - từ đó bị trùng => set lại list
    // - từ đó không bị trùng => thêm vào cuối nghĩa là list - 1
    public void addGroup(String word, List<String> defs) {
        int group_index = findGroup(word.charAt(0));
        // khong tim thay group
        if (group_index == -1) {
            //them group
            SlangGroup group = new SlangGroup(word.charAt(0));
            group.getLstSlang().add(new Slang(word, defs, 0));
            lstGroup.add(group);
        } // tim thay group
        else {
            SlangGroup group = lstGroup.get(group_index);
           // phải loại trùng trong trường hợp có từ trùng
            int iS = findDuplicate(word, group_index);
            if (iS == -1) {
                group.getLstSlang().add(new Slang(word, defs, group.getLstSlang().size() - 1)); // không tìm thấy trùng
            } else {
                // trong trường hợp này đầu tiên ta sẽ thêm một nhóm nghĩa vào từ cũ
                Slang sNew = group.getLstSlang().get(iS);
              // dùng addAll để add thêm một nhóm nghĩa mới
                sNew.getNghia().addAll(defs);
                group.getLstSlang().set(iS, sNew);
                //set lại group
                lstGroup.set(group_index, group);
            }
        }
    }
    // tìm 1 group trong 1 nhóm group
    public int findGroup(char type) {
        return IntStream.range(0, lstGroup.size())
                .filter(gi -> type == lstGroup.get(gi).getGroupType())
                .findFirst()
                .orElse(-1);
    }
//    public Slang findDefinitionBySlangWord(String key){
//        return lstGroup.stream()
//                .parallel()
//                .filter(p -> p.getGroupType().equals(key.charAt(0)))).findFirst().orElse(null);
//    }
//   
//    
    // hàm này giúp tìm từ trùng trong phạm vi 1 group
			// trả về -1 nghĩa là không có từ nào trùng
			// ngược lại thì trả về vị trí của slang đó trong nhóm

    public int findDuplicate(String word, int group_index) {
        Slang s = lstGroup.get(group_index).getLstSlang().stream().parallel().filter(w -> w.getKey().equals(word)).findFirst().orElse(null);
        if (s == null) {
            return -1;
        }
        return s.getIndex();
    }

    public List<SlangGroup> getLstGroup() {
        return lstGroup;
    }

    public void setLstGroup(List<SlangGroup> lstGroup) {
        this.lstGroup = lstGroup;
    }

}
