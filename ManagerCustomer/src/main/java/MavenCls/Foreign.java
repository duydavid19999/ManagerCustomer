package MavenCls;

import java.util.HashMap;

public class Foreign extends Customer{
    private String countryCode;

    public Foreign(String name, int consumption, String phoneNumber, String birthday, String countryCode) {
        super(name, consumption, phoneNumber, birthday);
        this.countryCode = countryCode;
    }

    public Foreign(){

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public double sumConsum(int consumption){
        Customer x= new Customer();
        HashMap<String,String> gData= new HashMap<String,String>();
        gData=x.getData();
        int ConsumLimit=Integer.parseInt(gData.getOrDefault("ConsumLimitForeign","0")) ;
        int price= Integer.parseInt(gData.getOrDefault("PriceForeign","0")) ;
        double a=0.0;
        if(consumption>=ConsumLimit) a=consumption*price*1.5;
        else a=consumption*price;
        return a;
    }
    @Override
    public void showData(){
        Customer customer= new Customer();
        HashMap<String,String> gData= new HashMap<String,String>();
        gData=customer.getData();
        int conSumLimit=Integer.parseInt(gData.getOrDefault("ConsumLimitForeign","0")) ;
        System.out.println("Customer Foreign[CountryCode="+this.getCountryCode()+",Name=" +this.getName() + ", Consumption=" + this.getConsumption() +
                ", phoneNumber=" + this.getPhoneNumber()
                + ", birthDay=" + this.getBirthday()+",ConsumLimit= "+conSumLimit+"," +
                "Sum Cost="+sumConsum(this.getConsumption())+"]");
    }
}
