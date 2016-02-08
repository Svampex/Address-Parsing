package MVC;

import MyGUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class View extends JFrame {
    AddressList list = new AddressList(new Rect(10, 100, 200, 250));
    Canvas canvas;
    MyTextField textfield = new MyTextField(10, 50, 300, 30);

    public View(Controller controller) {
        canvas = new Canvas();
        canvas.addMouseListener(controller);
        setLayout(new BorderLayout());
        getContentPane().add(canvas, BorderLayout.CENTER);
        setSize(512, 512);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        //Add listeners (motion listener is added to canvas because of different mousePosition
        addMouseWheelListener(controller);
        addKeyListener(controller);
    }

    public void mouseWheel(int w, Point mousePos){
        list.scrollList(w, mousePos);
        repaint();
    }

    public void keyInput(char character, int key){
        textfield.write(character, key);
        repaint();
    }

    public void selectComponent(Point mousePos){
        if(textfield.fieldContains(mousePos)){
            textfield.select();
            repaint();
        } else{
            textfield.unselect();
            repaint();
        }
    }

    public String getText(){
        return textfield.getTextAndClear();
    }

    public void setAddresses(ArrayList<Address> newAddresses){
        list.setElements(newAddresses);
        repaint();
    }

    public void addNewAddress(Address ad){
        list.addNewElement(ad);
    }

    class Canvas extends JComponent{
        public void paint(Graphics g) {
            g.setColor(MyColor.appBackground);
            g.fillRect(0,0, getWidth(), getHeight());
            list.drawList(g);
            textfield.drawTextField(g);
        }
    }
}
