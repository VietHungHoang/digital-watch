package digitalwatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class DigitalWatch extends JFrame{
    
    int WIDTH = 600;
    int HEIGHT = 500;
    Color textColor = new Color(211, 211, 211);
    Color backgroundColor = Color.BLACK;
    
    JButton b;
    JPanel header, body, footer;
    JLabel hLabel, bLabel, fLabel, tLabel, sLabel;
    Font dgMainFont, dgSubFont, dgSubSubFont;
    DigitalWatch(){
        this.setVisible(true);
        
        header = new JPanel();
        header.setLayout(null);
        hLabel = new JLabel();
        header.add(hLabel);
        
        body = new JPanel();
        body.setLayout(null);
        bLabel = new JLabel();
        tLabel = new JLabel();
        sLabel = new JLabel();
        body.add(bLabel);
//        body.add(tLabel);
        body.add(sLabel);


        footer = new JPanel();
        footer.setLayout(null);
        fLabel = new JLabel();
        footer.add(fLabel);
        
        // Font
        dgMainFont = new Font("DS-Digital", Font.PLAIN, 200);
        dgSubFont = new Font("DS-Digital", Font.PLAIN, 60);
        dgSubSubFont = new Font("DS-Digital", Font.PLAIN, 50);

        
        
        this.add(header);
        this.add(body);
        this.add(footer);
        this.setLayout(null);
//        this.setResizable(false);
        
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    
    public void run(){
        Insets i = this.getInsets();
        this.setSize(WIDTH + i.left + i.right, HEIGHT + i.top + i.bottom);
        
        updateTime();
        
        // Header
        header.setBounds(0, 0, WIDTH, HEIGHT * 25 / 100);
        hLabel.setFont(dgSubFont);
        hLabel.setBounds(0, 0, WIDTH, HEIGHT * 25 / 100);
        hLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        hLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hLabel.setForeground(textColor);
        
        body.setBounds(0, HEIGHT / 4, WIDTH, HEIGHT * 4 / 10);
        bLabel.setFont(dgMainFont);
        bLabel.setForeground(textColor);
        FontMetrics metrics = bLabel.getFontMetrics(dgMainFont);
        int textWidth = metrics.stringWidth(bLabel.getText());
        int textHeight = metrics.getHeight();
        bLabel.setBounds((WIDTH - textWidth) * 4 / 10, 0, WIDTH, HEIGHT * 4 / 10);
        bLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        tLabel.setFont(dgSubSubFont);
        tLabel.setText("P.M");
        tLabel.setBounds((WIDTH - textWidth) * 4 / 10 + textWidth, (HEIGHT * 4 / 10 - textHeight) / 2 - 55, 100, HEIGHT * 4 / 10);
        tLabel.setVerticalAlignment(SwingConstants.CENTER);
        tLabel.setForeground(textColor);
        
        sLabel.setFont(dgSubSubFont);
        sLabel.setBounds((WIDTH - textWidth) * 4 / 10 + textWidth + 10, 50, 100, HEIGHT * 4 / 10);
        sLabel.setVerticalAlignment(SwingConstants.CENTER);
        sLabel.setForeground(textColor);
        
        footer.setBounds(0, HEIGHT * 65 / 100, WIDTH, HEIGHT * 35 / 100);
        fLabel.setFont(dgSubFont);
        fLabel.setBounds(0, 0, WIDTH, HEIGHT * 35 / 100);
        fLabel.setVerticalAlignment(SwingConstants.TOP);
        fLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fLabel.setForeground(textColor);
        
        
        footer.setBackground(backgroundColor);
        body.setBackground(backgroundColor);
        header.setBackground(backgroundColor);
        this.setLocationRelativeTo(null);
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
        
    }
    
    public void updateTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        
        //set Time
        String time = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        bLabel.setText(time);
         
        //set Second
        String second = String.format("%02d", dateTime.getSecond());
        sLabel.setText(second);
        
        //set Date
        String date = dateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        fLabel.setText(date);
        
        //set day of week
        String dayOfWeek = dateTime.getDayOfWeek().toString();
        hLabel.setText(dayOfWeek);
    }

    public static void main(String[] args) {
        new CreateFont();
        DigitalWatch dw = new DigitalWatch();
        dw.run();
    }
    
}
