import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;

public class tools {

    public static double sidecalc(int intAngleA, int intAngleB, int intSideB){
        // angle angle side calculations
        
        if((intAngleA+intAngleB) >= 180){
            // checking if triangle can be formed
            return 0;
        }else{
            // switching integer values into double
            double dblSideA;
            double dblAngleA = intAngleA;
            double dblAngleB = intAngleB;
            double dblSideB = intSideB;

            // converting degrees to radians
            dblAngleA = Math.toRadians(dblAngleA);
            dblAngleB = Math.toRadians(dblAngleB);

            // using sine rule to find side a and rounding the result
            dblSideA = (dblSideB * Math.sin(dblAngleA))/Math.sin(dblAngleB);
            dblSideA = Math.round(dblSideA*100.0)/100.0;
            return dblSideA;
        }
    }

    public static double anglecalc(int intSideA, int intSideB, int intAngleB){
        // side side angle calculation
        // switching integer values to double
        double dblAngleA;
        double dblSideA = intSideA;
        double dblSideB = intSideB;
        double dblAngleB = intAngleB;

        // converting degrees to radians
        dblAngleB = Math.toRadians(dblAngleB);

        // finding angle A with sine law and returning the value
        dblAngleA = Math.asin((dblSideA * Math.sin(dblAngleB))/dblSideB);
        dblAngleA = Math.toDegrees(dblAngleA);
        dblAngleA = Math.round(dblAngleA*100.0)/100.0;
        
        dblAngleB = Math.toDegrees(dblAngleB);
        if((dblAngleA+dblAngleB) >= 180){
            // checking if triangle can be formed
            return 0;
        }else{
            return dblAngleA;
        }
    }

    
}
