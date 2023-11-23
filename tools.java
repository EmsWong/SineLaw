import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class tools {
    public static Font loadFont(String strFileName, int intSize){    
        Font theFont = null;
        // Try to load the font from the jar file
        try{
        theFont = Font.createFont(Font.TRUETYPE_FONT, new File("CabinSketch-Bold.ttf")); 
        return theFont.deriveFont(Font.PLAIN, intSize);
        }catch(Exception e){
        //System.out.println(e.toString());
        }
        
        // Then try to load the font from the local filesystem
        try{
        theFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(strFileName)); 
        return theFont.deriveFont(Font.PLAIN, intSize);
        }catch(Exception e){
        //System.out.println(e.toString());
        System.out.println("Unable to load font file \""+strFileName+"\". Setting default font"); 
        }
        
        // Then load the default font if all else fails
        try{
        theFont = Font.createFont(Font.TRUETYPE_FONT, new File("CabinSketch-Bold.ttf")); 
        return theFont.deriveFont(Font.PLAIN, 20);
        }catch(Exception e){
        //System.out.println(e.toString());
        System.out.println("Unable to load default font file \"Hack-Regular.tff\".  Will default to Java's native font for your OS");
        }
        return theFont;
    }

    
}
