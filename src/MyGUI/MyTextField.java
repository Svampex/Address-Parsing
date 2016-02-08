package MyGUI;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTextField extends JComponent {
    private Rect fieldRect;
    private String text = "";
    private Pattern inputPattern = Pattern.compile("[A-ZÆØÅa-zæøå,.0-9 ]*");
    private Boolean selected = false;

    public MyTextField(int x, int y, int width, int height){
        fieldRect = new Rect(x, y, width, height);
    }

    public Boolean fieldContains(Point point){
        if(fieldRect.contains(point)){
            return true;
        }
        else{
            return false;
        }
    }

    public void select(){
        selected = true;
    }

    public void unselect(){
        selected = false;
    }

    public Boolean isSelected(){
        return selected;
    }

    public void drawTextField(Graphics g){
        if(selected){
            g.setColor(MyColor.selectedTxtField);
        }else{
            g.setColor(MyColor.textField);
        }
        g.setClip(fieldRect.getRectX(), fieldRect.getRectY(), fieldRect.getRectWidth(), fieldRect.getRectHeight());
        g.fillRect(fieldRect.getRectX(), fieldRect.getRectY(), fieldRect.getRectWidth(), fieldRect.getRectHeight());
        g.setColor(MyColor.txtFieldTxt);
        g.drawString(text, fieldRect.getRectX() + 5, fieldRect.getRectY()+(fieldRect.getRectHeight()/2)+5);
        g.setClip(null);
    }

    public void write(char character, int key){
        if(selected){
            Matcher m = inputPattern.matcher(""+character);
            if(key != 8){
                if(m.matches()){
                    text += character;
                }
            }else{
                if(text.length() > 0){
                    text = text.substring(0, text.length()-1);
                }
            }
        }
    }

    public String getTextAndClear(){
        String oldText = text;
        text = "";
        return oldText;
    }
}
