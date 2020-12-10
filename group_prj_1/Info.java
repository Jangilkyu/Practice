package group_prj_1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Info extends JDialog {

    LoginEvt le;

    JTextField jtfPath;
    TitledBorder tbpath;
    JButton jbtnLogFileOpen;
    JTextArea jtaLogText;
    JScrollPane jspLogText;
    JList<String> list;
    DefaultListModel<String> dlmList;
    JScrollPane jspList;
    JTextArea jtaListText;
    JScrollPane jsplistText;
    JTextField jtfStartLine;
    JTextField jtfendLine;
    JButton jbtnView;
    JButton jbtnReport;

    public Info(/*LoginEvt le*/)  {
//        super(le.getMyLogin(),"로그파일 정보",true);

//        this.le = le;

        jtfPath = new JTextField();
        jtfPath.setBorder(new TitledBorder(".log확장자 파일 Path"));

        jbtnLogFileOpen = new JButton("+ logFileOpen");
        jtaLogText = new JTextArea();
        jtaLogText.setBorder(new TitledBorder(".log확장자 파일 내용"));
        jspLogText = new JScrollPane(jtaLogText);
        dlmList = new DefaultListModel<String>();
        dlmList.addElement("1) 최다 사용 키 (이름,횟수)");
        dlmList.addElement("2) 브라우저별 (접속 횟수,비율)");
        dlmList.addElement("3) 서비스 수행 횟수 성공(202),실패(404)");
        dlmList.addElement("4) 요청이 가장 많은 시간");
        dlmList.addElement("5) 비정상 요청 403 (발생 횟수,비율)");
        dlmList.addElement("6) 입력 라인정보에 대한 최다 사용 키(이름,횟수)");
        list = new JList<String>(dlmList);
        jspList = new JScrollPane(list);
        jspList.setBorder(new TitledBorder("InfoList"));
        jtaListText = new JTextArea();
        jtaListText.setBorder(new TitledBorder("ListOutput"));
        jtaListText.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        jsplistText = new JScrollPane(jtaListText);
        jtfStartLine = new JTextField();
        jtfendLine = new JTextField();
        jbtnView = new JButton("View");
        jbtnReport = new JButton("Report");
        getInfo();
    }//Info

    public void getInfo() {

        setLayout(null);

        jtfPath.setBounds(50,50,740,40);

        jbtnLogFileOpen.setBounds(795,50,115,40);
        jbtnLogFileOpen.setBackground(new Color(103,153,255));
        jbtnLogFileOpen.setFont(new Font(Font.DIALOG,Font.BOLD,12));
        jbtnLogFileOpen.setForeground(new Color(255,255,255));

        jspLogText.setBounds(50,110,855,200);
        jspList.setBounds(50,330,420,200);
        jsplistText.setBounds(500,330,410,200);

        jtfStartLine.setBounds(55,550,200,60);
        jtfendLine.setBounds(270,550,200,60);

        jbtnView.setBounds(650,550,115,40);
        jbtnView.setBackground(new Color(103,153,255));
        jbtnView.setFont(new Font(Font.DIALOG,Font.BOLD,12));
        jbtnView.setForeground(new Color(255,255,255));

        jbtnReport.setBounds(790,550,115,40);
        jbtnReport.setBackground(new Color(103,153,255));
        jbtnReport.setFont(new Font(Font.DIALOG,Font.BOLD,12));
        jbtnReport.setForeground(new Color(255,255,255));

        jtfStartLine.setBorder(new TitledBorder("StartLine"));
        jtfendLine.setBorder(new TitledBorder("EndLine"));


        InfoEvt ie = new InfoEvt(this);
        jbtnLogFileOpen.addActionListener(ie);
        jtfPath.addActionListener(ie);
        jbtnView.addActionListener(ie);
        jtfStartLine.addActionListener(ie);
        jtfendLine.addActionListener(ie);

        add(jtfPath);
        add(jbtnLogFileOpen);
        add(jspLogText);
        add(jspList);
        add(jsplistText);
        add(jtfStartLine);
        add(jtfendLine);
        add(jbtnView);
        add(jbtnReport);
        setBounds(300,50,960,680);

        setResizable(false);
        setVisible(true);

    }//end;

    public JButton getJbtnLogFileOpen() {
        return jbtnLogFileOpen;
    }

    public JTextField getJtfPath() {
        return jtfPath;
    }

    public JTextArea getJtaLogText() {
        return jtaLogText;
    }

    public JScrollPane getJspList() {
        return jspList;
    }

    public JTextField getJtfStartLine() {
        return jtfStartLine;
    }

    public JTextField getJtfendLine() {
        return jtfendLine;
    }

    public JButton getJbtnView() {
        return jbtnView;
    }

    public JButton getJbtnReport() {
        return jbtnReport;
    }
    public JList<String> getList() {
        return list;
    }

    public JTextArea getJtaListText() {
        return jtaListText;
    }//getJtaListText


    public static void main(String[] args) {
        new Info();
    }


}//class
