package group_prj_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class InfoEvt implements ActionListener {

    Info info;
    File file;
    FileDialog fdUpload;
    FileInputStream fisUpload;
    InputStreamReader isrUpload;
    BufferedReader brUpload;
    int lineCnt;
    int startIdx;
    int endIdx;
    Map<String,Integer> getResult;
    Map<String,Integer> getUrl;
    Map<String,Integer> getBrowser;
    Map<String,Integer> getDate;
    List listResult;




    public InfoEvt(Info info) {
        this.info = info;
    }//InfoEvt

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == info.getJbtnLogFileOpen()) {
            try {
                getInfo();
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(info, "파일 경로가 잘못 되었습니다.");
            } catch (IOException ie) {
                JOptionPane.showMessageDialog(info, "오류가 발생하였습니다.");
            }//end catch
        }//end if

        if(ae.getSource() == info.getJbtnView()){
            initInstance();
            checkLine();
            try {
                setInfoList();
            }catch(FileNotFoundException fnfe){
                JOptionPane.showMessageDialog(info,"파일 경로를 찾을 수 없습니다. 확인 부탁드립니다.");
            }catch (IOException e) {
                JOptionPane.showMessageDialog(info,"오류가 발생하였습니다.");
                e.printStackTrace();
            }
        }//end if

    }//actionPerformed

    public void initInstance(){


    }//reset

    public void checkLine(){

        if(!(info.getJtfStartLine().getText().equals("")) && !info.getJtfendLine().getText().equals("")){
            startIdx = Integer.parseInt(info.getJtfStartLine().getText());
            endIdx = Integer.parseInt(info.getJtfendLine().getText());

            if(startIdx > endIdx){
                JOptionPane.showMessageDialog(info,"시작범위가 종료범위보다 더 큽니다.!");
            }
        }

    }//checkLine

    public void getInfo() throws IOException {
        fdUpload = new FileDialog(info, "파일 선택", FileDialog.LOAD);
        String getPath = "";
        String getFile = "";
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

        System.out.println(lineCnt);
        brUpload.close();

    }//getPath


    public void setInfoList() throws FileNotFoundException,IOException {

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String getLine = "";
        String tempWord = "";
        while((getLine = br.readLine()) != null){
            StringTokenizer stk = new StringTokenizer(getLine, "[]");

            System.out.println(stk.nextElement());
        }
    }//setInfoList

}//class