package group_prj_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Report implements ActionListener {

    private View view;
    private File file;
    StringBuilder sb;
    BufferedOutputStream bs;

    Report(View view) {
        this.view = view;
    }//Report

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view.getJbtnReport()) {
            getFile();
        }//end if
    }//actionPerformed


    public void getFile() {

        file = new File("C:\\Users\\jewel\\OneDrive\\문서\\temp\\report");

        if (!file.exists()){
            file.mkdir();
        }
        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar time = Calendar.getInstance();

        String format_time1 = format1.format(time.getTime());
        String format_time2 = format2.format(time.getTime());

        // 작업 내용 출력
        String a = "";
        try {
            bs = new BufferedOutputStream(new FileOutputStream("C:\\Users\\jewel\\OneDrive\\문서\\temp\\report\\" + format_time1 + ".dat"));
            sb = new StringBuilder();

           a = sb.append("───────────────────────────\n").append("파일명( ").append(view.getIe().getFile().getName()).append(" )　생성 날짜( ")
                   .append(format_time2).append(" )\n" + "───────────────────────────\n").append("1. 최다 사용 키와 횟수\n　　")
                   .append(view.getIe().getMaxKeyVal()).append(" / ").append(view.getIe().getMapUrl().get(view.getIe().getMaxKeyVal()))
                   .append("회").append("\n\n2. 서비스 수행 성공과 실패 횟수\n　　").append("성공 : ").append(view.getIe().getMost200()).append("회, 실패 : ")
                   .append(view.getIe().getMost404()).append("회").append("\n\n3. 브라우저별 접속 횟수, 비율\n").append(view.getIe().getRate())
                   .append("\n\n4. 요청이 가장 많은 시간\n　　").append("수정 요청시간").append("시").append("\n\n5. 비정상적인 요청(403) 발생 횟수, 비율\n")
                   .append(view.getIe().getMost403()).append("회").append("수정(비율)").append("%)").append("\n\n6. 입력된 라인의 추가 정보\n　　")
                   .append(view.getIe().getUserRate()).append(" ").append(view.getIe().getMapUserResult().get(view.getIe().getUserRate())).toString();

            bs.write(a.getBytes());

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                    bs.close();

            } catch (IOException e) {
                e.printStackTrace();
            } // end catch
        } // end finally



    }//getFile

}//class
