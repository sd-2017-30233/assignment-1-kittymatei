package Presentation;
import Business.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Created by Cristina on 3/25/2017.
 */
public class Controller
{
    public View view;
    int idEmployee;

    public Controller()
    {
        view=new View();
        idEmployee=0;
        view.logIn.addActionListener(new LogInListener());
        view.bLogOut2.addActionListener(new LogOut2Listener());
        view.bLogOut3.addActionListener(new LogOut3Listener());
        view.bAddEmpl.addActionListener(new AddEmployeeListener());
        view.bEditEmpl.addActionListener(new EditEmployeeListener());
        view.bDeleteEmpl.addActionListener(new DeleteEmployeeListener());
        view.bViewEmpl.addActionListener(new ViewEmployeeListener());
        view.bReportEmpl.addActionListener(new ReportListener());
        view.bAddClient.addActionListener(new AddClientListener());
        view.bEditClient.addActionListener(new EditClientListener());
        view.bViewClient.addActionListener(new ViewClientListener());
        view.bAddAcc.addActionListener(new CreateAccountListener());
        view.bDeleteAcc.addActionListener(new DeleteAccountListener());
        view.bViewAcc.addActionListener(new ViewAccountListener());
        view.bDeposit.addActionListener(new DepositAccountListener());
        view.bTransfer.addActionListener(new TransferListener());
        view.bPay.addActionListener(new PayListener());
    }

    class LogInListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String comboBox=(String)view.comboLog.getSelectedItem();
            String usr=view.tusr.getText();
            String pwd=view.tpwd.getText();
            if(usr.equals("") || pwd.equals(""))
                JOptionPane.showMessageDialog(null,"Empty fields!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                if(comboBox.equals("Admin"))
                {
                    AdminService a=new AdminService();
                    int id=a.logIn(usr,pwd);
                    if(id==0)
                        JOptionPane.showMessageDialog(null,"Username and/or password wrong!", null, JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        view.tusr.setText("");
                        view.tpwd.setText("");
                        view.panel1.setVisible(false);
                        view.panel2.setVisible(true);
                    }
                }
                else
                {
                    EmployeeService em=new EmployeeService();
                    int id=em.logIn(usr,pwd);
                    if(id==0)
                        JOptionPane.showMessageDialog(null,"Username and/or password wrong!", null, JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        view.tusr.setText("");
                        view.tpwd.setText("");
                        view.panel1.setVisible(false);
                        view.panel3.setVisible(true);
                        idEmployee=id;
                    }
                }
            }

        }
    }


    class LogOut2Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            view.panel2.setVisible(false);
            view.panel1.setVisible(true);
        }
    }

    class LogOut3Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            view.panel3.setVisible(false);
            view.panel1.setVisible(true);
        }
    }


    class AddEmployeeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=view.tAddEmplName.getText();
            String usr=view.tAddEmplUsr.getText();
            String pwd=view.tAddEmplPwd.getText();
            if(name.equals("") || usr.equals("") || pwd.equals(""))
                JOptionPane.showMessageDialog(null,"Empty fields!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                EmployeeService em=new EmployeeService();
                String msg=em.addEmployee(name,usr,pwd);
                if(msg.equals("Successful operation!"))
                {
                    JOptionPane.showMessageDialog(null,msg, null, JOptionPane.INFORMATION_MESSAGE);
                    view.tAddEmplName.setText("");
                    view.tAddEmplUsr.setText("");
                    view.tAddEmplPwd.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null,msg, null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class EditEmployeeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String usr=view.tEditEmplUsr.getText();
            String pwd=view.tEditEmplPwd.getText();
            if(usr.equals("") || pwd.equals(""))
                JOptionPane.showMessageDialog(null,"Empty fields!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                EmployeeService em=new EmployeeService();
                boolean ok=em.updatePassword(usr,pwd);
                if(ok)
                {
                    JOptionPane.showMessageDialog(null,"Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);
                    view.tEditEmplUsr.setText("");
                    view.tEditEmplPwd.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null,"The username "+usr+" does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class DeleteEmployeeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=view.tDeleteEmplName.getText();
            if(name.equals(""))
                JOptionPane.showMessageDialog(null,"Empty field!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                EmployeeService em=new EmployeeService();
                boolean ok=em.deleteEmployee(name);
                if(ok)
                {
                    JOptionPane.showMessageDialog(null,"Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);
                    view.tDeleteEmplName.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null,"The employee "+name+" does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ViewEmployeeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=view.tViewEmplName.getText();
            if(name.equals(""))
                JOptionPane.showMessageDialog(null,"Empty field!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                EmployeeService em=new EmployeeService();
                String msg=em.viewEmployee(name);
                if(msg!=null)
                {
                    JOptionPane.showMessageDialog(null,msg, null, JOptionPane.INFORMATION_MESSAGE);
                    view.tViewEmplName.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null,"The employee "+name+" does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ReportListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=view.tReportEmplName.getText();
            String from=view.tReportEmplFrom.getText();
            String to=view.tReportEmplTo.getText();
            if(name.equals("") || from.equals("") || to.equals(""))
                JOptionPane.showMessageDialog(null,"Empty fields!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                ActivityService a=new ActivityService();
                String msg=a.viewActivity(name,from,to);
                if(msg!=null)
                {
                    JOptionPane.showMessageDialog(null,msg, null, JOptionPane.INFORMATION_MESSAGE);
                    view.tReportEmplName.setText("");
                    view.tReportEmplFrom.setText("");
                    view.tReportEmplTo.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null,"The employee "+name+" does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class AddClientListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=view.tAddClientName.getText();
            String idc=view.tAddClientId.getText();
            String code=view.tAddClientCode.getText();
            String addr=view.tAddClientAddr.getText();
            if(name.equals("") || idc.equals("") || code.equals("") || addr.equals(""))
                JOptionPane.showMessageDialog(null,"Empty fields!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                ClientService c=new ClientService();
                boolean ok=c.addClient(name,idc,code,addr);
                if(ok)
                {
                    JOptionPane.showMessageDialog(null,"Successful Operation!", null, JOptionPane.INFORMATION_MESSAGE);
                    view.tAddClientName.setText("");
                    view.tAddClientId.setText("");
                    view.tAddClientCode.setText("");
                    view.tAddClientAddr.setText("");
                    ActivityService a=new ActivityService();
                    a.addActivity(idEmployee,"Add client "+ name);
                }
                else
                    JOptionPane.showMessageDialog(null,"The client "+name+" already exists!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class EditClientListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=view.tEditClientName.getText();
            String addr=view.tEditClientAddr.getText();
            if(name.equals("") || addr.equals(""))
                JOptionPane.showMessageDialog(null,"Empty fields!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                ClientService c=new ClientService();
                boolean ok=c.updateClientAddress(name,addr);
                if(ok)
                {
                    JOptionPane.showMessageDialog(null,"Successful Operation!", null, JOptionPane.INFORMATION_MESSAGE);
                    view.tEditClientName.setText("");
                    view.tEditClientAddr.setText("");
                    ActivityService a=new ActivityService();
                    a.addActivity(idEmployee,"Edit address from client "+ name);
                }
                else
                    JOptionPane.showMessageDialog(null,"The client "+name+" does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ViewClientListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String name=view.tViewClientName.getText();
            if(name.equals(""))
                JOptionPane.showMessageDialog(null,"Empty field!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                ClientService c=new ClientService();
                String msg=c.viewClient(name);
                if(msg!=null)
                {
                    JOptionPane.showMessageDialog(null,msg, null, JOptionPane.INFORMATION_MESSAGE);
                    view.tViewClientName.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null,"The client "+name+" does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class CreateAccountListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String name = view.tAddAccName.getText();
            String comboBox=(String)view.comboType.getSelectedItem();
            if (name.equals("") )
                JOptionPane.showMessageDialog(null, "Empty field!", null, JOptionPane.ERROR_MESSAGE);
            else {
                AccountService ac=new AccountService();
                boolean ok = ac.createAccount(name, comboBox);
                if (ok) {
                    JOptionPane.showMessageDialog(null, "Successful Operation!", null, JOptionPane.INFORMATION_MESSAGE);
                    view.tAddAccName.setText("");
                    ActivityService a = new ActivityService();
                    a.addActivity(idEmployee, "Create account for client " + name +" of type "+comboBox);
                } else
                    JOptionPane.showMessageDialog(null, "The client " + name + " does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class DeleteAccountListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(view.tDeleteAccId.getText());
                AccountService ac = new AccountService();
                boolean ok = ac.deleteAccount(id);
                if (ok) {
                    JOptionPane.showMessageDialog(null, "Successful Operation!", null, JOptionPane.INFORMATION_MESSAGE);
                    view.tDeleteAccId.setText("");
                    ActivityService a = new ActivityService();
                    a.addActivity(idEmployee, "Delete account " + id);
                } else
                    JOptionPane.showMessageDialog(null, "The account " + id + " does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }catch (NumberFormatException nfex)
            {
                JOptionPane.showMessageDialog(null,"The ID has to be an integer!", null, JOptionPane.ERROR_MESSAGE);

            }

        }
    }


    class ViewAccountListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String name = view.tViewAccName.getText();
            if (name.equals("") )
                JOptionPane.showMessageDialog(null, "Empty field!", null, JOptionPane.ERROR_MESSAGE);
            else {
                AccountService ac=new AccountService();
                String msg = ac.viewAccount(name);
                if (msg!=null) {
                    JOptionPane.showMessageDialog(null, "Client name : "+name+" \n\n"+msg, null, JOptionPane.INFORMATION_MESSAGE);
                    view.tViewAccName.setText("");
                } else
                    JOptionPane.showMessageDialog(null, "The client " + name + " does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    class DepositAccountListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(view.tDepositId.getText());
                float amount = Float.parseFloat(view.tDepositAmount.getText());
                AccountService ac = new AccountService();
                boolean ok = ac.depositAmount(id,amount);
                if (ok) {
                    JOptionPane.showMessageDialog(null, "Successful Operation!", null, JOptionPane.INFORMATION_MESSAGE);
                    view.tDepositId.setText("");
                    view.tDepositAmount.setText("");
                    ActivityService a = new ActivityService();
                    a.addActivity(idEmployee, "Deposit "+amount+" in account " + id);
                } else
                    JOptionPane.showMessageDialog(null, "The account " + id + " does not exist!", null, JOptionPane.ERROR_MESSAGE);
            }catch (NumberFormatException nfex)
            {
                JOptionPane.showMessageDialog(null,"The ID has to be an integer and the amount has to be a real!", null, JOptionPane.ERROR_MESSAGE);

            }

        }
    }


    class TransferListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {
                int id1 = Integer.parseInt(view.tTransferId1.getText());
                int id2 = Integer.parseInt(view.tTransferId2.getText());
                float amount = Float.parseFloat(view.tTransferAmount.getText());
                AccountService ac = new AccountService();
                String msg = ac.transferMoney(id1,id2,amount);
                if (msg.equals("Successful operation!")) {
                    JOptionPane.showMessageDialog(null, msg, null, JOptionPane.INFORMATION_MESSAGE);
                    view.tTransferId1.setText("");
                    view.tTransferId2.setText("");
                    view.tTransferAmount.setText("");
                    ActivityService a = new ActivityService();
                    a.addActivity(idEmployee, "Transfer "+amount+" from account " + id1+" to account "+id2);
                } else
                    JOptionPane.showMessageDialog(null, msg, null, JOptionPane.ERROR_MESSAGE);
            }catch (NumberFormatException nfex)
            {
                JOptionPane.showMessageDialog(null,"The ID has to be an integer and the amount has to be a real!", null, JOptionPane.ERROR_MESSAGE);

            }

        }
    }


    class PayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(view.tPayId.getText());
                float amount = Float.parseFloat(view.tPayAmount.getText());
                AccountService ac = new AccountService();
                String msg = ac.processBill(id,amount);
                if (msg.equals("Successful operation!")) {
                    JOptionPane.showMessageDialog(null, msg, null, JOptionPane.INFORMATION_MESSAGE);
                    view.tPayId.setText("");
                    view.tPayAmount.setText("");
                    ActivityService a = new ActivityService();
                    a.addActivity(idEmployee, "Process bill of "+amount+" from account "+id);
                } else
                    JOptionPane.showMessageDialog(null, msg, null, JOptionPane.ERROR_MESSAGE);
            }catch (NumberFormatException nfex)
            {
                JOptionPane.showMessageDialog(null,"The ID has to be an integer and the amount has to be a real!", null, JOptionPane.ERROR_MESSAGE);

            }

        }
    }





}
