package group_prj_1;

import javax.swing.*;
import java.awt.*;

public class View extends JDialog {
    private InfoEvt ie;
    private JLabel jlblMaxkey;
    private JTextArea jtaMakey;

    private JLabel jlblSuccFail;
    private JTextArea jtaSuccFail;

    private JLabel jlblBrowser;
    private JTextArea jtaBrowser;

    private JLabel jlblDate;
    private JTextArea jtaDate;

    private JLabel jlblErrorKey;
    private JTextArea jtaErrorKey;

    private JLabel jlblUserSelect;
    private JTextArea jtaUserSelect;

    public View(InfoEvt ie) {
        super(ie.getInfo(), "a", true);
        this.ie = ie;
        jlblMaxkey = new JLabel("1. 최대사용키");
        jtaMakey = new JTextArea();

        jlblBrowser = new JLabel("2. 브라우저별 접속횟수 및 비율");
        jtaBrowser = new JTextArea();

        jlblDate = new JLabel("3. 요청시간이 가장 많은 시간");
        jtaDate = new JTextArea();

        jlblSuccFail = new JLabel("4. 서비스를 성공적으로 수행한 횟수, 실패(404) 횟수");
        jtaSuccFail = new JTextArea();

        jlblErrorKey = new JLabel("5. 비정상적인 요청(403)");
        jtaErrorKey = new JTextArea();

        jtaUserSelect = new JTextArea();
        jlblUserSelect = new JLabel(String.valueOf(ie.getStartIdx()) + "~" + String.valueOf(ie.getEndIdx()) + "번째 라인에 해당 한느 정보 중 최다 사용키의 이름과 횟수");

    }//View

    public void getLogInfo() {

        jlblMaxkey.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        jtaMakey.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        jtaMakey.setText(ie.getMaxKeyVal());
        jtaMakey.setEditable(false);

        jlblBrowser.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        jtaBrowser.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        jtaBrowser.setText(ie.getRate());
        jtaBrowser.setEditable(false);

        jlblDate.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        jtaDate.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        jtaDate.setText("");
        jtaDate.setEditable(false);

        jlblSuccFail.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        jtaSuccFail.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        jtaSuccFail.setText("200(성공): " + String.valueOf(ie.getMost200()) + "회\n404(실패): " + String.valueOf(ie.getMost404()) + "회");
        jtaSuccFail.setEditable(false);

        jlblErrorKey.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        jtaErrorKey.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        jtaErrorKey.setText(String.valueOf(ie.getMost200()));
        jtaErrorKey.setEditable(false);

        jlblUserSelect.setText(String.valueOf(ie.getStartIdx()) + "~" + String.valueOf(ie.getEndIdx()) + "번째 라인에 해당 한느 정보 중 최다 사용키의 이름과 횟수");
        jlblUserSelect.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        jtaUserSelect.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        jtaUserSelect.setText(ie.getUserRate() + " " +ie.getMapUserResult().get(ie.getUserRate()));
        jtaUserSelect.setEditable(false);

        setLayout(null);

        add(jlblMaxkey).setBounds(50, 30, 150, 30);
        add(jtaMakey).setBounds(50, 60, 100, 30);

        add(jlblBrowser).setBounds(50, 100, 300, 30);
        add(jtaBrowser).setBounds(50, 130, 150, 120);

        add(jlblDate).setBounds(50, 260, 300, 30);
        add(jtaDate).setBounds(50, 290, 100, 30);

        add(jlblSuccFail).setBounds(50, 340, 550, 30);
        add(jtaSuccFail).setBounds(50, 370, 150, 60);

        add(jlblErrorKey).setBounds(600, 30, 300, 30);
        add(jtaErrorKey).setBounds(600, 60, 100, 30);

        add(jlblUserSelect).setBounds(600, 100, 700, 30);
        add(jtaUserSelect).setBounds(600, 130, 100, 30);

        setBounds(100, 100, 1300, 500);
        setVisible(true);
    }//getInfo

    public JTextArea getJtaMakey() {
        return jtaMakey;
    }
}//class
