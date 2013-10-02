
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.OI;
//import java.awt.*;

/**
 *
 * @author bradmiller
 */
public class MasterCommand extends CommandBase {

    Joystick joystick1,joystick2;
    JoystickButton button1_1,button1_2,button1_3,button1_4, button1_5, button1_9, button1_11;
    JoystickButton button2_1,button2_2,button2_3,button2_4, button2_5, button2_9;
    DriverStationLCD m_dsLCD;
    int y = 0;
    
    
   
    
    
    
    public MasterCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
        joystick1 = OI.joystick1;
        joystick2 = OI.joystick2;
        button1_1 = new JoystickButton(joystick1,1);
        button1_2 = new JoystickButton(joystick1,2);
        button1_3 = new JoystickButton(joystick1,3);
        button1_4 = new JoystickButton(joystick1,4);
        button1_5 = new JoystickButton(joystick1,5);
        button1_9 = new JoystickButton(joystick1,9);
        button1_11 = new JoystickButton(joystick1, 11);
        
        button2_1 = new JoystickButton(joystick2, 1);
        //button2_2 = new JoystickButton(joystick2, 2);
        button2_3 = new JoystickButton(joystick2, 3);
        button2_4 = new JoystickButton(joystick2, 4);
        button2_5 = new JoystickButton(joystick2, 5);
        button2_9 = new JoystickButton(joystick2,9);
        m_dsLCD = DriverStationLCD.getInstance();
        
    }

    // Called just before this Command runs the first time
    protected void initialize(){  
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        
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
