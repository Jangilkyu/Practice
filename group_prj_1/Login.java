package group_prj_1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Login  extends JFrame{

    ImageIcon ii;
    JLabel jlblImg;
    JRadioButton jrbSt;
    JRadioButton jrbTeacher;
    ButtonGroup bg;
    JPanel jp;
    JTextField jtfid;
    JPasswordField jtfpassword;
    JButton jbtnLogin;
    JButton jbtnSignUp;
    TitledBorder tbid;
    TitledBorder tbpw;

    public Login(){
        super("(주) SIST");
        ii = new ImageIcon("C:\\Prj\\src\\group_prj_1\\img\\쌍용logo.JPG");
        jlblImg = new JLabel(ii);
        jrbSt = new JRadioButton("일반",true);
        jrbSt.setOpaque(false);
        jrbTeacher = new JRadioButton("강사");
        jrbTeacher.setOpaque(false);
        bg = new ButtonGroup();
        jp = new JPanel();
        jtfid = new JTextField(8);
        jtfpassword = new JPasswordField(8);
        jbtnLogin = new JButton("로그인");
        jbtnSignUp = new JButton("회원가입");
        tbid = new TitledBorder("아이디");
        tbpw = new TitledBorder("비밀번호");
        setDesign();
    }//Login

    public void setDesign(){
        jp.setLayout(new GridLayout(1,2));
        bg.add(jrbSt);
        bg.add(jrbTeacher);

        jp.add(jrbSt);
        jp.add(jrbTeacher);

        add(jbtnLogin);
        add(jbtnSignUp);

        setLayout(null);

        add(jlblImg).setBounds(70,30,200,190);
        add(jp).setBounds(120,260,100,30);
        add(jtfid).setBounds(55,320,230,35);
        jtfid.setBorder(tbid);

        jtfpassword.setBorder(tbpw);
        add(jtfpassword).setBounds(55,370,230,35);
        add(jbtnLogin).setBounds(60,430,100,35);
        add(jbtnSignUp).setBounds(180,430,100,35);


        jp.setOpaque(false);
        jbtnLogin.setBackground(new Color(103,153,255));
        jbtnLogin.setFont(new Font(Font.DIALOG,Font.BOLD,12));
        jbtnLogin.setForeground(new Color(255,255,255));
        jbtnSignUp.setBackground(new Color(103,153,255));
        jbtnSignUp.setFont(new Font(Font.DIALOG,Font.BOLD,12));
        jbtnSignUp.setForeground(new Color(255,255,255));

        LoginEvt le = new LoginEvt(this);
        jtfid.addActionListener(le);
        jtfpassword.addActionListener(le);
        jbtnLogin.addActionListener(le);
        jbtnSignUp.addActionListener(le);
        jbtnSignUp.addMouseListener(le);


        setBounds(550,150,350,550);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }//setDesign

    public JTextField getJtfid() {
        return jtfid;
    }//getJtfid

    public JPasswordField getJtfpassword() {
        return jtfpassword;
    }//JPasswordField

    public JButton getJbtnLogin() {
        return jbtnLogin;
    }//getJbtnLogin

    public JButton getJbtnSignUp() {
        return jbtnSignUp;
    }//getJbtnSignUp


}//class