import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class tools {
    public static Font loadFont(String strFileName, int intSize){    
        Font theFont = null;
        // Try to load the font from the jar file
        try{
        theFont = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Bold.ttf")); 
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
        theFont = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Bold.ttf")); 
        return theFont.deriveFont(Font.PLAIN, 20);
        }catch(Exception e){
        //System.out.println(e.toString());
        System.out.println("Unable to load default font file \"Hack-Regular.tff\".  Will default to Java's native font for your OS");
        }
        return theFont;
    }

    public static double sidecalc(int intAngleA, int intAngleB, int intSideB){
        double dblSideA;
        double dblAngleA = intAngleA;
        double dblAngleB = intAngleB;
        double dblSideB = intSideB;
        dblAngleA = Math.toRadians(dblAngleA);
        dblAngleB = Math.toRadians(dblAngleB);
        dblSideA = (dblSideB * Math.sin(dblAngleA))/Math.sin(dblAngleB);
        dblSideA = Math.round(dblSideA*100)/100;
        return dblSideA;
    }

    public static double anglecalc(int intSideA, int intSideB, int intAngleB){
        double dblAngleA;
        double dblSideA = intSideA;
        double dblSideB = intSideB;
        double dblAngleB = intAngleB;
        dblAngleB = Math.toRadians(dblAngleB);
        dblAngleA = Math.asin((dblSideA * Math.sin(dblAngleB))/dblSideB);
        dblAngleA = Math.round(dblAngleA*100)/100;
        return dblAngleA;
    }

    
}
