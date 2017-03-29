package Presentation;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Cristina on 3/25/2017.
 */
public class View extends JFrame
{
    public JLabel logInAs=new JLabel("Log in as : ");
    public JLabel lusr=new JLabel("Username : ");
    public JLabel lpwd=new JLabel("Password : ");
    public JLabel lAddEmpl=new JLabel("ADD EMPLOYEE :    ");
    public JLabel lAddEmplName=new JLabel("Name : ");
    public JLabel lAddEmplUsr=new JLabel("Username : ");
    public JLabel lAddEmplPwd=new JLabel("Password : ");
    public JLabel lEditEmpl=new JLabel("EDIT EMPLOYEE PASSWORD :    ");
    public JLabel lEditEmplUsr=new JLabel("Username : ");
    public JLabel lEditEmplPwd=new JLabel("New Password : ");
    public JLabel lDeleteEmpl=new JLabel("DELETE EMPLOYEE :    ");
    public JLabel lDeleteEmplName=new JLabel("Name : ");
    public JLabel lViewEmpl=new JLabel("VIEW EMPLOYEE INFO :    ");
    public JLabel lViewEmplName=new JLabel("Name : ");
    public JLabel lReportEmpl=new JLabel("VIEW REPORT :    ");
    public JLabel lReportEmplName=new JLabel("Name : ");
    public JLabel lReportEmplFrom=new JLabel("Period : from");
    public JLabel lReportEmplTo=new JLabel(" to ");
    public JLabel lAddClient=new JLabel("ADD CLIENT :    ");
    public JLabel lAddClientName=new JLabel("Name : ");
    public JLabel lAddClientId=new JLabel("Identity card number : ");
    public JLabel lAddClientCode=new JLabel("Personal numerical code : ");
    public JLabel lAddClientAddr=new JLabel("Address : ");
    public JLabel lEditClient=new JLabel("EDIT CLIENT ADDRESS :    ");
    public JLabel lEditClientName=new JLabel("Name : ");
    public JLabel lEditClientAddr=new JLabel("New address : ");
    public JLabel lViewClient=new JLabel("VIEW CLIENT INFO :    ");
    public JLabel lViewClientName=new JLabel("Name : ");
    public JLabel lAddAcc=new JLabel("CREATE ACCOUNT :    ");
    public JLabel lAddAccName=new JLabel("Client name : ");
    public JLabel lAddAccType=new JLabel("Type : ");
    public JLabel lDeleteAcc=new JLabel("DELETE ACCOUNT :    ");
    public JLabel lDeleteAccId=new JLabel("Account ID : ");
    public JLabel lViewAcc=new JLabel("VIEW ACCOUNTS :    ");
    public JLabel lViewAccName=new JLabel("Client name : ");
    public JLabel lDeposit=new JLabel("DEPOSIT MONEY :    ");
    public JLabel lDepositId=new JLabel("Account ID : ");
    public JLabel lDepositAmount=new JLabel("Amount : ");
    public JLabel lTransfer=new JLabel("TRANSFER MONEY :    ");
    public JLabel lTransferId1=new JLabel("Source account : ");
    public JLabel lTransferId2=new JLabel("Destination account : ");
    public JLabel lTransferAmount=new JLabel("Amount : ");
    public JLabel lPay=new JLabel("PROCESS BILL :    ");
    public JLabel lPayId=new JLabel("Account ID: ");
    public JLabel lPayAmount=new JLabel("Amount : ");


    public JButton logIn=new JButton("Log In");
    public JButton bAddEmpl=new JButton("Add");
    public JButton bEditEmpl=new JButton("Edit");
    public JButton bDeleteEmpl=new JButton("Delete");
    public JButton bViewEmpl=new JButton("View");
    public JButton bReportEmpl=new JButton("View Report");
    public JButton bAddClient=new JButton("Add");
    public JButton bEditClient=new JButton("Edit");
    public JButton bViewClient=new JButton("View");
    public JButton bAddAcc=new JButton("Create");
    public JButton bDeleteAcc=new JButton("Delete");
    public JButton bViewAcc=new JButton("View");
    public JButton bDeposit=new JButton("Deposit");
    public JButton bTransfer=new JButton("Transfer");
    public JButton bPay=new JButton("Process");
    public JButton bLogOut2=new JButton("Log Out");
    public JButton bLogOut3=new JButton("Log Out");

    public JTextField tusr=new JTextField(10);
    public JTextField tpwd=new JTextField(10);
    public JTextField tAddEmplName=new JTextField(15);
    public JTextField tAddEmplUsr=new JTextField(15);
    public JTextField tAddEmplPwd=new JTextField(15);
    public JTextField tEditEmplUsr=new JTextField(15);
    public JTextField tEditEmplPwd=new JTextField(15);
    public JTextField tDeleteEmplName=new JTextField(15);
    public JTextField tViewEmplName=new JTextField(15);
    public JTextField tReportEmplName=new JTextField(15);
    public JTextField tReportEmplFrom=new JTextField(15);
    public JTextField tReportEmplTo=new JTextField(15);
    public JTextField tAddClientName=new JTextField(15);
    public JTextField tAddClientId=new JTextField(15);
    public JTextField tAddClientCode=new JTextField(15);
    public JTextField tAddClientAddr=new JTextField(15);
    public JTextField tEditClientName=new JTextField(15);
    public JTextField tEditClientAddr=new JTextField(15);
    public JTextField tViewClientName=new JTextField(15);
    public JTextField tAddAccName=new JTextField(15);
    public JTextField tDeleteAccId=new JTextField(15);
    public JTextField tViewAccName=new JTextField(15);
    public JTextField tDepositId=new JTextField(15);
    public JTextField tDepositAmount=new JTextField(15);
    public JTextField tTransferId1=new JTextField(15);
    public JTextField tTransferId2=new JTextField(15);
    public JTextField tTransferAmount=new JTextField(15);
    public JTextField tPayId=new JTextField(15);
    public JTextField tPayAmount=new JTextField(15);


    public JComboBox<Object> comboLog=new JComboBox<Object>(new String[]{"Admin","Employee"});
    public JComboBox<Object> comboType=new JComboBox<Object>(new String[]{"Saving Account","Spending Account"});

    public JPanel panel1=new JPanel();
    public JPanel panel2=new JPanel();
    public JPanel panel3=new JPanel();

    public View()
    {
        this.setTitle("Bank Application");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color c1=new Color(204,0,0);
        Color c2=new Color(255,255,204);
        Color c3=new Color(224,224,224);

        lAddAcc.setForeground(c1);
        lAddEmpl.setForeground(c1);
        lAddClient.setForeground(c1);
        lEditClient.setForeground(c1);
        lEditEmpl.setForeground(c1);
        lDeleteAcc.setForeground(c1);
        lDeleteEmpl.setForeground(c1);
        lDeposit.setForeground(c1);
        lViewAcc.setForeground(c1);
        lViewClient.setForeground(c1);
        lViewEmpl.setForeground(c1);
        lPay.setForeground(c1);
        lTransfer.setForeground(c1);
        lReportEmpl.setForeground(c1);

        bAddAcc.setBackground(c3);
        bAddEmpl.setBackground(c3);
        bLogOut2.setBackground(c3);
        bAddClient.setBackground(c3);
        bDeposit.setBackground(c3);
        bDeleteAcc.setBackground(c3);
        bDeleteEmpl.setBackground(c3);
        bViewAcc.setBackground(c3);
        bViewClient.setBackground(c3);
        bViewEmpl.setBackground(c3);
        bPay.setBackground(c3);
        bTransfer.setBackground(c3);
        bLogOut3.setBackground(c3);
        logIn.setBackground(c3);
        bReportEmpl.setBackground(c3);
        bEditClient.setBackground(c3);
        bEditEmpl.setBackground(c3);


        JPanel panel=new JPanel();
        JPanel panel11=new JPanel();
        JPanel panel12=new JPanel();
        JPanel panel13=new JPanel();
        JPanel panel21=new JPanel();
        JPanel panel22=new JPanel();
        JPanel panel23=new JPanel();
        JPanel panel24=new JPanel();
        JPanel panel25=new JPanel();
        JPanel panel31=new JPanel();
        JPanel panel32=new JPanel();
        JPanel panel33=new JPanel();
        JPanel panel34=new JPanel();
        JPanel panel35=new JPanel();
        JPanel panel36=new JPanel();
        JPanel panel37=new JPanel();
        JPanel panel38=new JPanel();
        JPanel panel39=new JPanel();

        panel.setBackground(c2);
        panel1.setBackground(c2);
        panel2.setBackground(c2);
        panel3.setBackground(c2);
        panel11.setBackground(c2);
        panel12.setBackground(c2);
        panel13.setBackground(c2);
        panel21.setBackground(c2);
        panel22.setBackground(c2);
        panel23.setBackground(c2);
        panel24.setBackground(c2);
        panel25.setBackground(c2);
        panel31.setBackground(c2);
        panel32.setBackground(c2);
        panel33.setBackground(c2);
        panel34.setBackground(c2);
        panel35.setBackground(c2);
        panel36.setBackground(c2);
        panel37.setBackground(c2);
        panel38.setBackground(c2);
        panel39.setBackground(c2);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        panel11.add(logInAs);
        panel11.add(comboLog);

        panel12.add(lusr);
        panel12.add(tusr);

        panel13.add(lpwd);
        panel13.add(tpwd);

        panel21.add(lAddEmpl);
        panel21.add(lAddEmplName);
        panel21.add(tAddEmplName);
        panel21.add(lAddEmplUsr);
        panel21.add(tAddEmplUsr);
        panel21.add(lAddEmplPwd);
        panel21.add(tAddEmplPwd);
        panel21.add(bAddEmpl);

        panel22.add(lEditEmpl);
        panel22.add(lEditEmplUsr);
        panel22.add(tEditEmplUsr);
        panel22.add(lEditEmplPwd);
        panel22.add(tEditEmplPwd);
        panel22.add(bEditEmpl);

        panel23.add(lDeleteEmpl);
        panel23.add(lDeleteEmplName);
        panel23.add(tDeleteEmplName);
        panel23.add(bDeleteEmpl);

        panel24.add(lViewEmpl);
        panel24.add(lViewEmplName);
        panel24.add(tViewEmplName);
        panel24.add(bViewEmpl);

        panel25.add(lReportEmpl);
        panel25.add(lReportEmplName);
        panel25.add(tReportEmplName);
        panel25.add(lReportEmplFrom);
        panel25.add(tReportEmplFrom);
        panel25.add(lReportEmplTo);
        panel25.add(tReportEmplTo);
        panel25.add(bReportEmpl);

        panel31.add(lAddClient);
        panel31.add(lAddClientName);
        panel31.add(tAddClientName);
        panel31.add(lAddClientId);
        panel31.add(tAddClientId);
        panel31.add(lAddClientCode);
        panel31.add(tAddClientCode);
        panel31.add(lAddClientAddr);
        panel31.add(tAddClientAddr);
        panel31.add(bAddClient);

        panel32.add(lEditClient);
        panel32.add(lEditClientName);
        panel32.add(tEditClientName);
        panel32.add(lEditClientAddr);
        panel32.add(tEditClientAddr);
        panel32.add(bEditClient);

        panel33.add(lViewClient);
        panel33.add(lViewClientName);
        panel33.add(tViewClientName);
        panel33.add(bViewClient);

        panel34.add(lAddAcc);
        panel34.add(lAddAccName);
        panel34.add(tAddAccName);
        panel34.add(lAddAccType);
        panel34.add(comboType);
        panel34.add(bAddAcc);

        panel35.add(lDeleteAcc);
        panel35.add(lDeleteAccId);
        panel35.add(tDeleteAccId);
        panel35.add(bDeleteAcc);

        panel36.add(lViewAcc);
        panel36.add(lViewAccName);
        panel36.add(tViewAccName);
        panel36.add(bViewAcc);

        panel37.add(lDeposit);
        panel37.add(lDepositId);
        panel37.add(tDepositId);
        panel37.add(lDepositAmount);
        panel37.add(tDepositAmount);
        panel37.add(bDeposit);

        panel38.add(lTransfer);
        panel38.add(lTransferId1);
        panel38.add(tTransferId1);
        panel38.add(lTransferId2);
        panel38.add(tTransferId2);
        panel38.add(lTransferAmount);
        panel38.add(tTransferAmount);
        panel38.add(bTransfer);

        panel39.add(lPay);
        panel39.add(lPayId);
        panel39.add(tPayId);
        panel39.add(lPayAmount);
        panel39.add(tPayAmount);
        panel39.add(bPay);

        panel1.add(panel11);
        panel1.add(panel12);
        panel1.add(panel13);
        panel1.add(logIn);

        panel2.add(panel21);
        panel2.add(panel22);
        panel2.add(panel23);
        panel2.add(panel24);
        panel2.add(panel25);
        panel2.add(bLogOut2);

        panel3.add(panel31);
        panel3.add(panel32);
        panel3.add(panel33);
        panel3.add(panel34);
        panel3.add(panel35);
        panel3.add(panel36);
        panel3.add(panel37);
        panel3.add(panel38);
        panel3.add(panel39);
        panel3.add(bLogOut3);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        panel3.setVisible(false);
        panel2.setVisible(false);

        this.setContentPane(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
