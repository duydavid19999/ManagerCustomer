package com.Main;

import DAOCustomerImpl.DAOForeign;
import DAOCustomerImpl.DAOVietNameseImpl;
import MavenCls.Customer;
import MavenCls.Foreign;
import MavenInterface.DAOCustomer;

import java.io.*;
import java.util.*;


public class MainTest {
    public static void Menu(String style){


        if(style=="MENU"){
            System.out.println(" ---------- "+style.toUpperCase()+" ---------- ");
            System.out.println("1.   Add new Customer.\n"
                  + "2.   Delete Customer.\n"
                  + "3.	  Show List Customer.\n"
                  + "4.	  Edit Price and ConsumLimit.\n"
                  + "5.	  Show Price and ConsumLimit.\n"
                  + "0.   Exit");
        }
        else if(style == "OPTION"){
            System.out.println(" "+style.toUpperCase()+" ---------- ");

            System.out.println("1.   Option VN.\n"
                             + "2.   Option Foreign.\n"
                             + "0.   Exit Application.\n");
        }
        else{
            System.out.println("ERROR");
        }
    }

    //ACTION
    public static void Action() {
        int option=0;
        Customer customer= new Customer();
        System.out.println("Insert data config");
        customer.setData();
        DAOCustomer daoCustomer= new DAOVietNameseImpl();
        DAOCustomer daoCustomer1= new DAOForeign();
        ArrayList<Customer> customers= new ArrayList<>();

        do {
            Menu("MENU");
            System.out.print("Input option: ");
            option=customer.checkInputInteger("Input option again: ");
            switch (option){
                case 1:
                    int  optionCustomer;
                    do {
                        Menu("OPTION");
                        System.out.print("Input option: ");
                        optionCustomer=customer.checkInputInteger("Input option again: ");
                        if(optionCustomer==1)
                        {
                            daoCustomer.inputCustomer(customers);
                            break;

                        }
                        else if(optionCustomer==2){
                            daoCustomer1.inputCustomer(customers);
                            break;
                        }
                        else{
                            break;
                        }
                    }while (optionCustomer!=0||optionCustomer!=1||optionCustomer!=2);
                    break;

                case 2:
                    daoCustomer.showListCustomer(customers);
                    int vtDelete;
                    System.out.print("Input position which You want to delete: ");
                    vtDelete=customer.checkInputInteger("Input again position which You want to delete: ");
                    daoCustomer.deleteIndexCustomer(customers,vtDelete);
                    break;
                case 3:
                    daoCustomer.showListCustomer(customers);
                    break;
                case 4:
                    customer.setData();
                    break;
                case 5:
                    if(customer.getData().size() !=0)
                    System.out.println(customer.getData());
                    else
                    System.out.println("Didn't set data for Config file");
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR INPUT!!!!");
                    break;
            }
        }while (option!=0);
        System.out.println("BYE!!!");
    }
    public static void main(String[] args)  {
        Action();
    }

}
