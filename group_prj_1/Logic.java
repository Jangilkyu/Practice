package group_prj_1;

import java.io.*;
import java.util.*;

public class Logic {

    FileInputStream fis;
    InputStreamReader isr;
    StringBuilder sbCopyword;
    BufferedReader br;
    HashMap<String,Integer> map;
    List<String> list1;

    //-------------Constructor
    public Logic() throws FileNotFoundException,UnsupportedEncodingException,IOException {
        fis = new FileInputStream((new File("C:\\Users\\jewel\\OneDrive\\바탕 화면\\01.group_prj_1\\sist_input_1.log")));
        isr = new InputStreamReader(fis,"UTF-8");
        br = new BufferedReader(isr);
        sbCopyword = new StringBuilder();
        map = new HashMap<String,Integer>();
        list1 = new ArrayList<String>();
        getFrequency();
    }//Group_prj_1

    //-------------getFrequency
    public void getFrequency() throws IOException {
        String getword = "";
        while((getword = br.readLine()) != null){
            list1.add(getword);
            sbCopyword.append(getword);
        }//end while

        StringTokenizer stk = new StringTokenizer(sbCopyword.toString().replace("[", "").replace("]", "|"),"|",false);

        while(stk.hasMoreTokens()){
            String freqword = stk.nextElement().toString();

            if(!map.containsKey(freqword)){
                map.put(freqword,1);
            }
            else {
                map.put(freqword,map.get(freqword)+1);
            }
        }//end while

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

//        for(int i = 1000; i < 1501; i++){
//            System.out.println(list1.get(i));
//        }

        double resultie = map.get("ie")/(double)list1.size()*100;
        if(map.containsKey("ie")){
            System.out.printf("ie %d (%.0f%%): \n",map.get("ie"),resultie);
        }

        double reusltChrome = map.get("Chrome")/(double)list1.size()*100;
        if(map.containsKey("Chrome")){
            System.out.printf("Chrome %d (%.0f%%): \n",map.get("Chrome"),reusltChrome);
        }

        double result404 = map.get("Chrome")/(double)list1.size()*100;
        if(map.containsKey("404") && map.containsKey("200")){
            System.out.println("서비스를 성공적으로 수행한 횟수 " + map.get("200"));
            System.out.println("서비스를 실패한 횟수 " + map.get("404"));
        }

    }//getfrequency

}
