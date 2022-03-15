package DAOCustomerImpl;

import MavenCls.Customer;
import MavenCls.Foreign;
import MavenCls.VietNamese;
import MavenInterface.DAOCustomer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DAOForeign extends Foreign implements DAOCustomer {
    public void inputCustomer(ArrayList<Customer> danhSach) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert number of Customer F: ");
        n = checkInputInteger("Insert number of Customer F again: ");
        for (int i = 0; i < n; i++) {
            System.out.println("==================" + (i + 1) + "=====================");
            Foreign daoForeign = new Foreign();
            System.out.print("Insert Code Country: ");
            String codeCus = checkInputString("Insert Code Country again: ");
            daoForeign.setCountryCode(codeCus);
            System.out.print("Insert userName: ");
            String nameCus = checkInputString("Insert Customer name again: ");
            daoForeign.setName(nameCus);
            System.out.print("Insert phoneNumber: ");
            String phoneNb = checkInputPhone("Insert phoneNumber again: ");
            daoForeign.setPhoneNumber(phoneNb);
            System.out.print("Insert birthDay: ");
            String birthDayCus = checkInputDate("Insert  Customer'S birrthday(dd/mm/yyyy) again: ");
            daoForeign.setBirthday(birthDayCus);
            String inputConsump = "";
            System.out.print("Insert consumption: ");
            do {

                inputConsump = scanner.nextLine();
                if (isDigit(inputConsump))
                    daoForeign.setConsumption(Integer.parseInt(inputConsump));
                else
                    System.err.print("Input consumption:");
            } while (!isDigit(inputConsump));

            danhSach.add(daoForeign);
        }
    }
    public void deleteIndexCustomer(ArrayList<Customer> T,int vt){
        T.remove(vt);
        System.out.println("---------------After Delete--------------");
        showListCustomer(T);
    }
    public double sumConsum(int consumption){
        Customer x= new Customer();
        HashMap<String,String> gData= new HashMap<String,String>();
        gData=x.getData();
        int ConsumLimit=Integer.parseInt(gData.get("ConsumLimitForeign")) ;
        int price= Integer.parseInt(gData.get("PriceForeign")) ;
        double a=0.0;
        if(consumption>=ConsumLimit) a=consumption*price*1.25;
        else a=consumption*price;
        return a;
    }
    @Override
    public void showListCustomer(ArrayList<Customer> T){

        Customer customer= new Customer();
        HashMap<String,String> gData= new HashMap<String,String>();
        gData=customer.getData();
        int ConsumLimit=Integer.parseInt(gData.get("ConsumLimitForeign")) ;
        int i=0;
        for (Customer x: T) {
            System.out.print((i+1)+". "); x.showData();
            i++;
        }
    }
}
