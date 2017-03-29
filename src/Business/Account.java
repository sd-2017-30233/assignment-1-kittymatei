package Business;
import DataAccess.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Created by Cristina on 3/22/2017.
 */
public class Account
{
    public boolean createAccount(String clientName, String type)
    {
        ClientGateway c=new ClientGateway();
        AccountGateway a=new AccountGateway();
        int id=c.findIdClientByName(clientName);
        if(id!=0)
        {
            LocalDate localDate = LocalDate.now();
            a.addAccount(id,type,0,DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate));
            return true;
        }
        return false;
    }

    public boolean depositAmount(int id, float newAmount)
    {
        AccountGateway a=new AccountGateway();
        float amount=a.findAmount(id);
        if(amount >= 0)
        {
            a.updateAmount(id,amount+newAmount);
            return true;
        }
        return false;
    }

    public boolean deleteAccount(int id)
    {
        AccountGateway a=new AccountGateway();
        float amount=a.findAmount(id);
        if(amount >= 0)
        {
            a.deleteAccount(id);
            return true;
        }
        return false;
    }

    public String viewAccount(String clientName)
    {
        ClientGateway c=new ClientGateway();
        AccountGateway a=new AccountGateway();
        int id=c.findIdClientByName(clientName);
        if(id!=0)
        {
            return a.viewAccounts(id);
        }
        return null;
    }

    public String transferMoney(int idSource, int idDest, float amount)
    {
        AccountGateway a=new AccountGateway();
        float amount1 =a.findAmount(idSource);
        float amount2 =a.findAmount(idDest);
        if(amount1<0)
            return "The account "+idSource+" does not exist!";
        else
            if(amount2<0)
                return "The account "+idDest+" does not exist!";
            else
                if(amount1<amount)
                    return "Insufficient funds!";
                else
                {
                    a.updateAmount(idSource,amount1-amount);
                    a.updateAmount(idDest,amount2+amount);
                    return "Successful operation!";
                }
    }


    public String processBill(int id,float amount)
    {
        AccountGateway a=new AccountGateway();
        float amount1 =a.findAmount(id);
        if(amount1<0)
            return "The account "+id+" does not exist!";
        else
            if(amount1<amount)
                return "Insufficient funds!";
            else
            {
                a.updateAmount(id,amount1-amount);
                return "Successful operation!";
            }

    }
}
