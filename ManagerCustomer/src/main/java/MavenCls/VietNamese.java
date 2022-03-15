package MavenCls;

import java.util.HashMap;

public class VietNamese extends Customer{
    public VietNamese(String name, int consumption, String phoneNumber, String birthday) {
        super(name, consumption, phoneNumber, birthday);
    }

    public VietNamese() {
    }
    public double sumConsum(int consumption){
        Customer x= new Customer();
        HashMap<String,String> gData= new HashMap<String,String>();
        gData=x.getData();
        int ConsumLimit=Integer.parseInt(gData.getOrDefault("ConsumLimitVietNam","0")) ;
        int price= Integer.parseInt(gData.getOrDefault("PriceVietNam","0")) ;
        double a=0.0;
        if(consumption>=ConsumLimit) a=consumption*price*1.25;
        else a=consumption*price;
        return a;
    }
    @Override
    public void showData(){
        Customer customer= new Customer();
        HashMap<String,String> gData= new HashMap<String,String>();
        gData=customer.getData();
        int conSumLimit=Integer.parseInt(gData.getOrDefault("ConsumLimitVietNam","0")) ;
        System.out.println("Customer VietNam[Name=" +this.getName() + ", Consumption=" + this.getConsumption() +
                ", phoneNumber=" + this.getPhoneNumber()
                + ", birthDay=" + this.getBirthday()+",ConsumLimit= "+conSumLimit+"," +
                "Sum Cost="+sumConsum(this.getConsumption())+"]");
    }
}
