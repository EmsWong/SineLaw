import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class tools {
    public static Font loadFont(String strFileName, int intSize){    
        Font theFont = null;
        try{
            theFont = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Bold.ttf")); 
            return theFont.deriveFont(Font.PLAIN, intSize);
        }catch(Exception e){
        }
        
        try{
            theFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(strFileName)); 
            return theFont.deriveFont(Font.PLAIN, intSize);
        }catch(Exception e){
            System.out.println("Unable to load font file \""+strFileName+"\". Setting default font"); 
        }
        
        try{
            theFont = Font.createFont(Font.TRUETYPE_FONT, new File("Raleway-Bold.ttf")); 
            return theFont.deriveFont(Font.PLAIN, 20);
        }catch(Exception e){
            System.out.println("Unable to load default font file \"Hack-Regular.tff\".  Will default to Java's native font for your OS");
        }
        return theFont;
    }

    public static double sidecalc(int intAngleA, int intAngleB, int intSideB){
        // angle angle side calculations
        if((intAngleA+intAngleB) >= 180){
            return 0;
        }else{
            double dblSideA;
            double dblAngleA = intAngleA;
            double dblAngleB = intAngleB;
            double dblSideB = intSideB;
            dblAngleA = Math.toRadians(dblAngleA);
            dblAngleB = Math.toRadians(dblAngleB);
            dblSideA = (dblSideB * Math.sin(dblAngleA))/Math.sin(dblAngleB);
            dblSideA = Math.round(dblSideA*100.0)/100.0;
            return dblSideA;
        }
    }

    public static double anglecalc(int intSideA, int intSideB, int intAngleB){
        // side side angle calculation
        double dblAngleA;
        double dblSideA = intSideA;
        double dblSideB = intSideB;
        double dblAngleB = intAngleB;
        dblAngleB = Math.toRadians(dblAngleB);
        dblAngleA = Math.asin((dblSideA * Math.sin(dblAngleB))/dblSideB);
        dblAngleA = Math.round(dblAngleA*100.0)/100.0;
        if((dblAngleA+dblAngleB)>= 180){
            return 0;
        }else{
            return dblAngleA;
        }
    }

    
}
