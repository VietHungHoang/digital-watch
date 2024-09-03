package digitalwatch;

import javax.swing.JFrame;

public class DigitalWatch extends JFrame{
    
    int WIDTH = 300;
    int HEIGHT = 200;

    DigitalWatch(){
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new DigitalWatch();
    }
    
}
