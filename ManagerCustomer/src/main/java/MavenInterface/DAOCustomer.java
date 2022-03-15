package MavenInterface;

import MavenCls.Customer;

import java.util.ArrayList;

public interface DAOCustomer {
    void inputCustomer(ArrayList<Customer> T);
    void deleteIndexCustomer(ArrayList<Customer> T,int vt);
    void showListCustomer(ArrayList<Customer> T);
}
