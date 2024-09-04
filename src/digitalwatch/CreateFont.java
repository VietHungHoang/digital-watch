package digitalwatch;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class CreateFont {
    private GraphicsEnvironment ge; 

    CreateFont(){
        try {
            ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//             List<String> listFontFamily = Arrays.asList(ge.getAvailableFontFamilyNames());
//             for(String x : listFontFamily){
//                 System.out.println(x);
//             }
            List<File> listFont = Arrays.asList(
                new File("assets/fonts/DS-DIGI.TTF"), 
                new File("assets/fonts/DS-DIGIB.TTF"),
                new File("assets/fonts/DS-DIGII.TTF"),
                new File("assets/fonts/DS-DIGIT.TTF")
            );
            
            for(File font : listFont){
                if(font.exists()){
                    Font newFont = Font.createFont(Font.TRUETYPE_FONT, font);
//                    System.out.println(newFont.getFontName());
                    ge.registerFont(newFont);
                    
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot find font!");
        }
    }
}
