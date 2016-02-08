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

    /*public ArrayList<ListElement> getAddressesAsListElements(){
        ArrayList<ListElement> addressesAsElements = new ArrayList<>();
        for (Address ad: addresses) {
            String adStreetNrSide = ad.street() + " " + ad.house() + " " + ad.floor() + " " + ad.side();
            String adPostCity = ad.postcode() + " " + ad.city();
            addressesAsElements.add(new ListElement(adStreetNrSide, adPostCity));
        }
        return addressesAsElements;
    }*/

}
