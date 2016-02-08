package MyGUI;

import MVC.Address;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class AddressList extends JComponent{
    private Rect listRect;
    //Height of each element in the list
    private int elementHeight = 45;
    private int indexHeight;
    private ArrayList<AddressListElement> addressListElements = new ArrayList<>();

    public AddressList(Rect rect){
        listRect = rect;
    }

    public void scrollList(int mouseWheelRotation, Point mousePos){
        //Only allow to move the list if there are more elements to show
        if(listRect.contains(mousePos)){
            if(addressListElements.size()*elementHeight > listRect.getRectHeight()){
                if(indexHeight >= 0){
                    indexHeight += mouseWheelRotation*6;
                }
                if(indexHeight < 0){
                    indexHeight = 0;
                }
                if((addressListElements.size()*elementHeight - indexHeight) <= listRect.getRectHeight()){
                    indexHeight = addressListElements.size()*elementHeight - listRect.getRectHeight();
                }
            }
        }


    }

    public void setElements(ArrayList<Address> newElements){
        addressListElements = new ArrayList<>();
        for (Address ad: newElements) {
            addressListElements.add(new AddressListElement(ad));
        }
    }

    public void addNewElement(Address ad){
        addressListElements.add(new AddressListElement(ad));
    }

    public void drawListBox(Graphics g){
        g.setColor(MyColor.addressList);
        g.fillRect(listRect.getRectX(), listRect.getRectY(), listRect.getRectWidth(), listRect.getRectHeight());
    }

    public void drawListElements(Graphics g){
        for (AddressListElement element: addressListElements) {
            int YPos = listRect.getRectY() + addressListElements.indexOf(element)*elementHeight - indexHeight;
            element.setElementRect(listRect.getRectX(), YPos, listRect.getRectWidth());
        }
        //Set clip makes the graphics to only draw in the rectangle given as parameter.
        g.setClip(listRect.getRectX(), listRect.getRectY(), listRect.getRectWidth(), listRect.getRectHeight());
        for (AddressListElement element: addressListElements) {
            if(addressListElements.indexOf(element) % 2 == 0){
                element.drawElement(g, MyColor.evenListElement);
            } else{
                element.drawElement(g, MyColor.unevenListElement);
            }
        }
        //Remove the bounds of g
        g.setClip(null);
    }
}
