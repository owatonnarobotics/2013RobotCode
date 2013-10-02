 
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;


/**
 *
 */
public class SingleMotor extends Subsystem {
    //The driver station to send messages to
    DriverStationLCD m_dsLCD;
    //The speed for the linear feeder
    public final double linear = 0.99;
    
    //The victor motor for the linear feeder
    Victor motorVictor = new Victor(RobotMap.LINEARFEEDERMOTOR);
    
    //The sensors used for the feeder
    DigitalInput backSensor = new DigitalInput(RobotMap.DIGITALBACKSENSOR);
    DigitalInput frontSensor = new DigitalInput(RobotMap.DIGITALFRONTSENSOR);
   
    //Used in some of the methods
    private int count = 0;
    int y = 0;
    boolean ableToStop = false;
    boolean go = true;
    boolean stopUpdating = false;
    
    //Detects the sensors and moves the gear thing based on it
    public boolean linearFeeder(){
            if(count == 0){
                motorVictor.set(-1*linear);
                System.out.println("first step");
                if(!frontSensor.get()){
                    count = 1;
                }
            }
            else if(count == 1){
                motorVictor.set(linear);
                System.out.println("second step");
                if(!backSensor.get()){
                    count = 2;
                }
            }
            else {
                System.out.println("third step");
                motorVictor.set(0);
                count = 0;
                return true;
            }
            return false;
    }
    
    //Stops the linear feeder
    public void stopLinearFeeder(){
        motorVictor.set(0);
    }
    
    
    //A test of the sensors
    public void test(boolean nothing){
        if(!backSensor.get()){
            y++;
            m_dsLCD = m_dsLCD.getInstance();
            m_dsLCD.println(DriverStationLCD.Line.kUser1, 1, "Back Sensor!");
            m_dsLCD.println(DriverStationLCD.Line.kUser1, 2, "Sensors hit" + y + "times");
            m_dsLCD.updateLCD();
            System.out.println("HERE");
        }
        if(!frontSensor.get()){
            y++;
            //motorVictor6.set(-1);
            //System.out.println("second");
            m_dsLCD = m_dsLCD.getInstance();
        
            m_dsLCD.println(DriverStationLCD.Line.kUser1, 1, "Front Sensor!");
            m_dsLCD.println(DriverStationLCD.Line.kUser1, 2, "Sensors hit" + y + "times");
            m_dsLCD.updateLCD();
            System.out.println("HERE2");
        }
    }
    
    //tests the linear feeder
    public void testLinearFeeder(){
            motorVictor.set(.5);
            System.out.println("TEST    ETSTST ETSSTE SET EST SET SETTE ET ET ");
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

