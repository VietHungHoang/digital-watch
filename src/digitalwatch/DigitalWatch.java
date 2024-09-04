package digitalwatch;

import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DigitalWatch extends JFrame{
    
    int WIDTH = 300;
    int HEIGHT = 150;
    int BUTTON_WIDTH = WIDTH / 2;
    int BUTTON_HEIGHT = HEIGHT / 2;
    JButton b;
    int hour = 0, minutes = 0, seconds = 0;
    DigitalWatch(){
        this.setVisible(true);
        Insets i = this.getInsets();
        this.setSize(WIDTH + i.left + i.right, HEIGHT + i.top + i.bottom);
        
        b = new JButton();
        b.setBounds(WIDTH / 4, HEIGHT / 4, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(b);
        
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        

    }
    public static void main(String[] args) {
        new DigitalWatch();
    }
    
}
