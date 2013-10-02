
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.DriverStationLCD;
//import java.awt.*;

/**
 *
 * @author bradmiller
 */
public class TiltSensorDetect extends CommandBase {

    
    static DriverStationLCD m_dsLCD;
    int y = 0;
    
    
   
    
    
    
    public TiltSensorDetect() {
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
        
        m_dsLCD = DriverStationLCD.getInstance();
        
    }

    // Called just before this Command runs the first time
    protected void initialize(){  
        
    }

    protected void execute(){
        
    }

    public static void check(){
        if (topSensor.get()){
            //System.out.println("Top Sensor Hit!");
            //y++;
            shooter.disableUp();
            //m_dsLCD = DriverStationLCD.getInstance();
            //m_dsLCD.println(DriverStationLCD.Line.kUser1, 1, "Top Sensor!");
            //m_dsLCD.println(DriverStationLCD.Line.kUser2, 2, "Sensors hit" + y + "times");
            //m_dsLCD.updateLCD();
        }
        else{
            shooter.enableUp();
        }
        if (bottomSensor.get()){
            //System.out.println("Bottom Sensor Hit!");
            //y++;
            shooter.disableDown();
            //m_dsLCD = DriverStationLCD.getInstance();
            //m_dsLCD.println(DriverStationLCD.Line.kUser1, 1, "Bottom Sensor!!");
            //m_dsLCD.println(DriverStationLCD.Line.kUser2, 2, "Sensors hit" + y + "times");
            //m_dsLCD.updateLCD();
        }
        else{
            shooter.enableDown();
        }
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
       
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
