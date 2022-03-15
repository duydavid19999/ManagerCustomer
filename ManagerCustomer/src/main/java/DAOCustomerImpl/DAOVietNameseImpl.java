package DAOCustomerImpl;

import MavenCls.Customer;
import MavenCls.Foreign;
import MavenCls.VietNamese;
import MavenInterface.DAOCustomer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DAOVietNameseImpl extends VietNamese implements DAOCustomer {
    public void inputCustomer(ArrayList<Customer> danhSach){
        int n=0;
        Scanner scanner= new Scanner(System.in);
        System.out.print("Input number of Customer VN: ");
        n=checkInputInteger("Input number of Customer VN again: ");
        for (int i=0;i<n;i++) {
            System.out.println("==================" + (i + 1) + "=====================");
            VietNamese daoVietNam = new VietNamese();

            System.out.print("Input userName: ");
            String nameCus = checkInputString("Input Customer name again: ");
            daoVietNam.setName(nameCus);
            System.out.print("Input phoneNumber: ");
            String phoneNb = checkInputPhone("Input phoneNumber again: ");
            daoVietNam.setPhoneNumber(phoneNb);
            System.out.print("Input birthDay: ");
            String birthDayCus = checkInputDate("Input  Customer'S birrthday  (dd/mm/yyyy) : ");
            daoVietNam.setBirthday(birthDayCus);
            String inputConsump = "";
            System.out.print("Input consumption: ");
            do {

                inputConsump = scanner.nextLine();
                if (isDigit(inputConsump))
                    daoVietNam.setConsumption(Integer.parseInt(inputConsump));
                else
                    System.err.print("Input consumption:");
            } while (!isDigit(inputConsump));

            danhSach.add(daoVietNam);
        }

    }
    public void deleteIndexCustomer(ArrayList<Customer> T,int vt){
        if(vt<1 || vt>(T.size()))
        {
            System.out.println("Don't have that position");
        }
        else{
            T.remove(vt-1);
            System.out.println("---------------After Delete--------------");
            showListCustomer(T);
        }

    }


    @Override
    public void showListCustomer(ArrayList<Customer> T){
        Customer customer= new Customer();
        HashMap<String,String> gData= new HashMap<String,String>();
        gData=customer.getData();
        int ConsumLimit=Integer.parseInt(gData.get("ConsumLimitVietNam")) ;
        int i=1;
        for (Customer x: T) {
            System.out.print((i)+". "); x.showData();
            i++;
        }
    }
}
