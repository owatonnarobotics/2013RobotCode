
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.LinearFeeder;
import edu.wpi.first.wpilibj.templates.commands.LinearFeederTest;
import edu.wpi.first.wpilibj.templates.commands.ShooterTilt;
import edu.wpi.first.wpilibj.templates.commands.ShooterTiltTimed;
import edu.wpi.first.wpilibj.templates.commands.ShooterWheel;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    
    public static Joystick joystick1 = new Joystick(1);
    public static Joystick joystick2 = new Joystick(2);
   
    JoystickButton button1_1,button1_2,button1_3,button1_4, button1_5, button1_6, button1_9, button1_10, button1_11;
    JoystickButton button2_1,button2_2,button2_3,button2_4, button2_5, button2_9 ,button2_10, button2_11;
    
    public OI(){
        
        //Assigns buttons
        button1_1 = new JoystickButton(joystick1,1);
        button1_2 = new JoystickButton(joystick1,2);
        button1_3 = new JoystickButton(joystick1,3);
        button1_4 = new JoystickButton(joystick1,4);
        button1_5 = new JoystickButton(joystick1,5);
        button1_6 = new JoystickButton(joystick1,6);
        button1_9 = new JoystickButton(joystick1,9);
        button1_10 = new JoystickButton(joystick1,10);
        button1_11 = new JoystickButton(joystick1, 11);

        button2_1 = new JoystickButton(joystick2, 1);
        button2_2 = new JoystickButton(joystick2, 2);
        button2_3 = new JoystickButton(joystick2, 3);
        button2_4 = new JoystickButton(joystick2, 4);
        button2_5 = new JoystickButton(joystick2, 5);
        button2_9 = new JoystickButton(joystick2,9);
        button2_10 = new JoystickButton(joystick2,10);
        button2_11 = new JoystickButton(joystick2,11);

        //Spins the wheel, will be taken out
        button1_5.whenPressed(new ShooterWheel(1));  //faster
        button1_4.whenPressed(new ShooterWheel(3));  //slower
        button1_11.whenPressed(new ShooterWheel(4)); //stop everything
        button1_6.whenPressed(new ShooterWheel(5));
        
        //adjusts the tilt in a direction for the shooter
        button2_10.whenPressed(new ShooterTilt(1)); //up
        button2_10.whenReleased(new ShooterTilt(2)); //stop
        button2_11.whenPressed(new ShooterTilt(3)); //down
        button2_11.whenReleased(new ShooterTilt(2)); //stop
        
        //Moves the linear feeder, which goes forward
        button2_1.whenPressed(new LinearFeeder());
        button2_2.whenPressed(new LinearFeederTest());

    }
    
    
}

