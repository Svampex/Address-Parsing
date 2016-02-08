package MVC;

import java.util.*;

public class Model {
    ArrayList<Address> addresses = new ArrayList<>();
    private static Model instance;

    public static Model getInstance(){
        if(instance == null){
            instance = new Model();
        }
        return instance;
    }

    private Model(){

    }

    public Address addNewAddress(String address){
        Address ad = Address.parse(address);
        if (ad != null) {
            addresses.add(ad);
            return ad;
        }else{
            System.out.println("Address not valid!");
        }
        return null;
    }

    public ArrayList<Address> getAddresses(){
        return addresses;
    }

}
