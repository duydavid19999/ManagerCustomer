package MavenCls;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    private String name;
    private int consumption;
    private String phoneNumber;
    private String birthday;

    public Customer(String name, int consumption, String phoneNumber, String birthday) {
        this.name = name;
        this.consumption = consumption;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void inputData(){

    }

    public void showData(){

    }

    public static boolean isDigit(String input) {
        // null hoặc length < 0 -> false.
        if (input == null || input.length() < 0)
            return false;
        // empty -> false
        input = input.trim();
        if ("".equals(input))
            return false;
        if (input.startsWith("-")) {
            // nếu là số âm thì cắt ký tự đầu tiên
            return input.substring(1).matches("[0-9]*");
        } else {
            // nếu là số dương cũng thực hiện kiểm tra qua
            return input.matches("[0-9]*");
        }
    }
    public static boolean isStringMes(String input) {
        boolean check=true;
        // null hoặc length < 0 -> false.
        if (input == null || input.length() < 0)
            check= false;
        // empty -> false
        input = input.trim();
        if ("".equals(input))
            check= false;
        return check;

    }
    //Check is Phone
    public static boolean isValid(String s)
    {

        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
    }

    //Check Date
    final static String DATE_FORMAT = "dd/MM/yyyy";
    public static boolean isValidDate(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public String checkInputString(String mess){
        String input="";
        String result="";
        Scanner scanner= new Scanner(System.in);

        do {

            input=scanner.nextLine();
            if(isStringMes(input))
                result=input;
            else
                System.err.print(mess);
        }while (!isStringMes(result));
        return result;
    }
    public String checkInputPhone(String mess){
        String input="";
        String result="";
        Scanner scanner= new Scanner(System.in);

        do {

            input=scanner.nextLine();
            if(isValid(input))
                result=input;
            else
                System.err.print(mess);
        }while (!isValid(result));
        return result;
    }
    public String checkInputDate(String mess){
        String input="";
        String result="";
        Scanner scanner= new Scanner(System.in);

        do {

            input=scanner.nextLine();
            if(isValidDate(input))
                result=input;
            else
                System.err.print(mess);
        }while (!isValidDate(result));
        return result;
    }
    public int checkInputInteger(String mes){
        String  inputConsump="";
        int result=0;
        Scanner scanner= new Scanner(System.in);
        do {

            inputConsump=scanner.nextLine();
            if(isDigit(inputConsump))
                result= Integer.parseInt(inputConsump);
            else
                System.err.print(mes);
        }while (!isDigit(inputConsump));
        return result;
    }
    //SetData
    public  void setData() {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            System.out.print("Insert ConsumLimit VN: ");
            int consumLimitVN= checkInputInteger("Insert ConsumLimit VN again: ");
            System.out.print("Insert VN's unit price: ");
            int priceVN= checkInputInteger("Insert VN's unit price again: ");

            System.out.print("Insert ConsumLimit Foreign: ");
            int consumLimitF= checkInputInteger("Insert ConsumLimit Foreign again: ");
            System.out.print("Insert Foreign's unit price: ");
            int priceF= checkInputInteger("Insert Foreign's unit price again: ");

            // set the properties value
            prop.setProperty("ConsumLimitVietNam", ""+consumLimitVN);
            prop.setProperty("PriceVietNam", ""+priceVN);
            prop.setProperty("ConsumLimitForeign", ""+consumLimitF);
            prop.setProperty("PriceForeign", ""+priceF);

            // save properties to project root folder
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //GetData from Config.properties
    public  HashMap<String,String> getData(){
        HashMap<String,String> hashMap= new HashMap<String,String>();
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            prop.entrySet().forEach(e -> hashMap.put(e.getKey().toString(),e.getValue().toString()));
        } catch (IOException ex) {

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hashMap;
    }
}
