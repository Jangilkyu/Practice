package group_prj_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.*;

public class InfoEvt implements ActionListener {

    private Info info;
    private View v;
    private File file;
    private Date date;
    private FileDialog fdUpload;
    private String getFile;
    private FileInputStream fisUpload;
    private InputStreamReader isrUpload;
    private BufferedReader brUpload;
    private StringBuilder sb;
    private boolean chckflag;
    private int lineCnt;
    private int startIdx;
    private int endIdx;
    private int most403;
    private int most200;
    private int most404;
    private String Rate;
    private String MostDate;
    private String UserRate;
    private HashMap<String, Integer> mapResult = new HashMap<>();
    private HashMap<String, Integer> mapUrl = new HashMap<>();
    private HashMap<String, Integer> mapBrowser = new HashMap<>();
    private HashMap<String, Integer> mapDate = new HashMap<>();
    private HashMap<String, Integer> mapUserResult = new HashMap<>();
    private List<String> listResult = new ArrayList<>();
    private List<String> listUrl = new ArrayList<>();
    private List<String> listBrowser = new ArrayList<>();
    private List<String> listDate = new ArrayList<>();

    String maxKeyVal = "";
    String[] browserKeys;

    public InfoEvt(Info info) {
        this.info = info;
        v = new View(this);
        mapResult = new HashMap<>();
        mapUrl = new HashMap<>();
        mapBrowser = new HashMap<>();
        mapDate = new HashMap<>();
        mapUserResult = new HashMap<>();
        listResult = new ArrayList<>();
        listUrl = new ArrayList<>();
        listBrowser = new ArrayList<>();
        listDate = new ArrayList<>();
    }//InfoEvt

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == info.getJbtnLogFileOpen()) {
            try {
                getInfo1();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(info, "파일 경로가 잘못 되었습니다.");
            } catch (IOException ie) {
                JOptionPane.showMessageDialog(info, "오류가 발생하였습니다.");
            }//end catch
        }//end if

        if (ae.getSource() == info.getJbtnView()) {

            try {
                initInstance();
                if (checkLine()) {
                    setInfoList();
                    maxKeyVal = getMaxkeyUrl();
                    Rate = getBrowserInfo();
                    MostDate = getDateInfo();
                    getResponseResult();
                    UserRate = getUserResult();
                    v.getLogInfo();
                }//end if

            } catch (FileNotFoundException fnfe) {
                JOptionPane.showMessageDialog(info, "파일 경로를 찾을 수 없습니다. 확인 부탁드립니다.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(info, "오류가 발생하였습니다.");
                e.printStackTrace();
            }
        }//end if

        int a = getInfo().getList().getAnchorSelectionIndex();

        if(ae.getSource() == getInfo()){
            System.out.println("a");
        }

    }//actionPerformed
    //========================

    //========================
    public void initInstance() {
        mapUrl.clear();
        listUrl.clear();
        mapBrowser.clear();
        listBrowser.clear();
        mapResult.clear();
        listDate.clear();
        mapDate.clear();

        v.getJtaMakey().setText("");
        browserKeys = null;
        most403 = 0;
        most200 = 0;
        most404 = 0;
        startIdx = 0;
        endIdx = 0;
        Rate = "";
        sb = null;
    }//reset
    //========================

    //===================================
    //시작과 끝 범위 유효성검사
    public boolean checkLine() {

        if (!(info.getJtfStartLine().getText().equals("")) && !info.getJtfendLine().getText().equals("")) {
            try {
                startIdx = Integer.parseInt(info.getJtfStartLine().getText());
                endIdx = Integer.parseInt(info.getJtfendLine().getText());

                if (startIdx < 0) {
                    JOptionPane.showMessageDialog(info, "startIndex에 유효하지 않은" + startIdx + "(음수)값이 들어가 있습니다.");
                    return false;
                }

                if (startIdx > endIdx) {
                    JOptionPane.showMessageDialog(info, "시작범위가 종료범위보다 더 큽니다.!");
                    return false;
                } else if (endIdx > lineCnt) {
                    JOptionPane.showMessageDialog(info, getFile + "의 라인 수는 " + lineCnt + "줄 입니다. 확인 부탁바랍니다.");
                    return false;
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(info, "숫자만 입력 가능합니다.");
                return false;
            }

        }//end if

        else {
            JOptionPane.showMessageDialog(info, "시작라인과 마지막라인의 필수값을 입력 부탁드립니다.");
            return false;
        }

        return true;
    }//checkLine
    //========================


    //========================
    public void getInfo1() throws IOException {
        fdUpload = new FileDialog(info, "파일 선택", FileDialog.LOAD);
        String getPath = "";
        getFile = "";
        fdUpload.setVisible(true);
        if (fdUpload.getFile() != null) {
            getPath = fdUpload.getDirectory();
            getFile = fdUpload.getFile();
        }//end if

        file = new File(getPath + getFile);

        fisUpload = new FileInputStream(file);

        if (!(getFile.contains(".log"))) {
            JOptionPane.showMessageDialog(info, ".log 확장자 파일이 아닙니다.");
        } else {
            info.getJtfPath().setText(getPath + getFile);
        }//end else

        info.getJtaLogText().setText("");
        lineCnt = 0;

        isrUpload = new InputStreamReader(fisUpload, "UTF-8");
        brUpload = new BufferedReader(isrUpload);

        String getLogReadLine = "";
        while ((getLogReadLine = brUpload.readLine()) != null) {
            info.getJtaLogText().append(getLogReadLine + "\n");
            lineCnt++;
        }//end while

        brUpload.close();

    }//getPath
    //========================


    //========================

    /**
     * 파일을 입력받고 리스트에 값들을 추가한다.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setInfoList() throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        listResult = new ArrayList<>();

        String getLine = "";
        String tempWord = "";

        StringTokenizer stk;
        for (int i = 0; i < lineCnt; i++) {
            stk = new StringTokenizer(getLine = br.readLine(), "[]");

            while (stk.hasMoreTokens()) {
                listResult.add(stk.nextToken());
                listUrl.add(stk.nextToken());
                listBrowser.add(stk.nextToken());
                listDate.add(stk.nextToken());
            }//end while
        }//end for
    }//setInfoList
    //========================


    //========================

    /**
     * 최다 사용 키를 찾는다.
     */
    public String getMaxkeyUrl() {

        for (int i = 0; i < listUrl.size(); i++) {
            String tmpList = listUrl.get(i).toString();
            String a = "";
            if (tmpList.contains("key")) {
                a = tmpList.substring(tmpList.indexOf("=") + 1, tmpList.indexOf("&"));
            }
            if (!(mapUrl.containsKey(a))) {
                mapUrl.put(a, 1);
            } else {
                mapUrl.put(a, mapUrl.get(a) + 1);
            }//end else
        }//end for

        String maxkey = "";

        Collection<Integer> values = mapUrl.values();//value값들 넣기
        for (String key : mapUrl.keySet()) {
            if (Collections.max(values) == mapUrl.get(key)) {
                maxkey = key;
            }
        }
        return maxkey;
    }//getMaxkeyUrl
    //=================================


    //=================================

    /**
     * 브라우저별 접속횟수와 비율을 구한다.
     */
    public String getBrowserInfo() {
        String tmpList = "";
        for (int i = 0; i < listBrowser.size(); i++) {
            tmpList = listBrowser.get(i).toString();

            if (!(mapBrowser.containsKey(tmpList))) {
                mapBrowser.put(tmpList, 1);
            } else {
                mapBrowser.put(tmpList, mapBrowser.get(tmpList) + 1);
            }//end else
        }//end for

        sb = new StringBuilder();

        for (String key : mapBrowser.keySet()) {
            Rate = sb.append(key).append("- ").append(mapBrowser.get(key)).append("회 (").append(String.format("%.2f", ((mapBrowser.get(key) / (double) listBrowser.size())) * 100)).append("%)\n").toString();
        }

        return Rate;

    }//getBrowserInfo

    /**
     * 요청시간이 가장 많은 시간
     */
    public String getDateInfo() {

        String tmpList = "";
        for (int i = 0; i < listDate.size(); i++) {
            tmpList = listDate.get(i).substring(listDate.get(i).indexOf(" "), listDate.get(i).indexOf(":"));
            if (!(mapDate.containsKey(tmpList))) {
                mapDate.put(tmpList, 1);
            } else {
                mapDate.put(tmpList, mapDate.get(tmpList) + 1);
            }//end else
        }//end for

        String maxkey = "";

        Collection<Integer> values = mapDate.values();//value값들 넣기
        for (String key : mapDate.keySet()) {
            if (Collections.max(values) == mapDate.get(key)) {
                maxkey = key;
            }
        }

        return maxkey;

    }//getDateInfo


    public void getResponseResult() {

        String tmpList = "";
        for (int i = 0; i < listResult.size(); i++) {
            tmpList = listResult.get(i).toString();

            if (!(mapResult.containsKey(tmpList))) {
                mapResult.put(tmpList, 1);
            } else {
                mapResult.put(tmpList, mapResult.get(tmpList) + 1);
            }//end else
        }//end for

        most200 = mapResult.get("200");
        most403 = mapResult.get("403");
        most404 = mapResult.get("404");

    }//end for


    public String getUserResult() {

        mapUserResult = new HashMap<>();

        String str = "";
        for (int i = startIdx; i <= endIdx; i++) {
            str = listUrl.get(i);
            if (str.contains("key")) {
                str = str.substring(str.indexOf("=") + 1, str.indexOf("&"));
            }
            if (!mapUserResult.containsKey(str)) {
                mapUserResult.put(str, 1);
            } else {
                mapUserResult.put(str, mapUserResult.get(str) + 1);
            }
        }//end for

        String maxkey = "";

        Collection<Integer> values = mapUserResult.values();//value값들 넣기
        for (String key : mapUserResult.keySet()) {
            if (Collections.max(values) == mapUserResult.get(key)) {
                maxkey = key;
            }
        }
        return maxkey;
    }//getUserResult

    //==============================================================================
    //Getter

    public Info getInfo() {
        return info;
    }


    public String getMaxKeyVal() {
        return maxKeyVal;
    }

    public HashMap<String, Integer> getMapResult() {
        return mapResult;
    }

    public HashMap<String, Integer> getMapUrl() {
        return mapUrl;
    }

    public HashMap<String, Integer> getMapBrowser() {
        return mapBrowser;
    }

    public HashMap<String, Integer> getMapDate() {
        return mapDate;
    }

    public int getMost403() {
        return most403;
    }

    public int getMost200() {
        return most200;
    }

    public int getMost404() {
        return most404;
    }

    public String getRate() {
        return Rate;
    }

    public int getStartIdx() {
        return startIdx;
    }

    public int getEndIdx() {
        return endIdx;
    }

    public String getUserRate() {
        return UserRate;
    }

    public HashMap<String, Integer> getMapUserResult() {
        return mapUserResult;
    }

    public File getFile() {
        return file;
    }

    public String getMostDate() {
        return MostDate;
    }
}//class