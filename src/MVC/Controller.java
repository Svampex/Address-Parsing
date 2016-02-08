package MVC;


import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

public class Controller implements KeyListener, MouseWheelListener, MouseInputListener{
    private Model model = Model.getInstance();
    private View view = new View(this);

    private static Controller instance;

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    private Controller(){
        view.setAddresses(Model.getInstance().getAddresses());
    }

    private void textFieldInput(KeyEvent e){
        view.keyInput(e.getKeyChar(), e.getKeyCode());
        if(e.getKeyCode() == 10){
            String newAddress = view.getText();
            if(Address.parse(newAddress) != null){
                view.addNewAddress(model.addNewAddress(newAddress));
            }
        }
    }

    private void addressListControl(MouseWheelEvent e){
        view.mouseWheel((int)e.getPreciseWheelRotation(), new Point(e.getX(),e.getY()));
    }
    //All key events
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        textFieldInput(e);
    }

    //All mouse events
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        addressListControl(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        view.selectComponent(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e){

    }
}
