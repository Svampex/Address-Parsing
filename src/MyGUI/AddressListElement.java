package MyGUI;


import MVC.Address;

import java.awt.*;

public class AddressListElement {
    private Rect elementRect;
    private String street;
    private String city;

    public AddressListElement(Address address){
        if(address.floor() != null && address.side() != null){
            street = address.street() + " " + address.house() + " " + address.floor() + " " + address.side();
        }else{
            street = address.street() + " " + address.house();
        }

        city = address.postcode() + " " + address.city();
    }

    public String getFullAddressString(){
        return street + " " + city;
    }

    public void setElementRect(int x, int y, int width){
        elementRect = new Rect(x, y, width, 45);
    }

    public void drawElement(Graphics g, Color color){
        g.setColor(color);
        g.fillRect(elementRect.getRectX(), elementRect.getRectY(), elementRect.getRectWidth(), elementRect.getRectHeight());
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString(street, elementRect.getRectX()+ 10, elementRect.getRectY() + elementRect.getRectHeight()/3);
        g.drawString(city, elementRect.getRectX() + 10, elementRect.getRectY() + (elementRect.getRectHeight()*2)/3);
    }
}