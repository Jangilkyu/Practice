package group_prj_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginEvt extends MouseAdapter implements ActionListener {

    Login login;

    public LoginEvt(Login login) {
        this.login = login;
    }//LoginEvt


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login.getJtfid()) {
            enterLogin();
        }//end if

        if (ae.getSource() == login.getJbtnLogin()) {
            getLogin();
        }//end if

    }//actionPerformed

    String userLogin;

    public void enterLogin() {
        JTextField jtfUserId = login.getJtfid();
        userLogin = jtfUserId.getText();

        JPasswordField jpsUserPwd = login.getJtfpassword();
        char[] userCharPwd = jpsUserPwd.getPassword();
        String userStrPwd = String.valueOf(userCharPwd);

        if (userLogin.isEmpty()) {
            jtfUserId.requestFocus();
            JOptionPane.showMessageDialog(login, "필수! 아이디를 입력해주세요. :( ");
        }//end if
        else {
            jpsUserPwd.requestFocus();
        }//end if

        if(!(userStrPwd.isEmpty())){
            login.getJbtnLogin().requestFocus();
        }//end if
        else {
            jpsUserPwd.requestFocus();
            JOptionPane.showMessageDialog(login,"필수! 비밀번호를 입력해주세요 :( ");
        }

    }//enterLogin

    public void getLogin() {
        String id = new String("admin");
        String pw = new String("1234");
        String id2 = new String("root");
        String pw2 = new String("1111");


        JPasswordField jpsUserPwd = login.getJtfpassword();
        char[] userCharPwd = jpsUserPwd.getPassword();
        String userStrPwd = String.valueOf(userCharPwd);
//        System.out.println(userLogin);

        if (((login.getJtfid().getText().equals(id)) && (userStrPwd.equals(pw))) || (((login.getJtfid().getText().equals(id2))) && (userStrPwd.equals(pw2)))) {
//            Info info = new Info(this);

        }
        else{
            JOptionPane.showMessageDialog(login,"아이디 또는 비밀번호를 확인하여 주시기 바랍니다.");
        }//end if

    }//getLogin


    //==================================MouseAdapter

    @Override
    public void mouseClicked(MouseEvent me) {

        if(me.getSource() == login.getJbtnSignUp()){
            JOptionPane.showMessageDialog(login,"추후 업데이트 예정인 기능입니다. :)");
        }//end if


    }//mouseClicked

    public Login getMyLogin(){
        return login;
    }

}//class
