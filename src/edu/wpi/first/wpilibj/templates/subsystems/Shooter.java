package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem {
    //The driver station to send messages to
    DriverStationLCD m_dsLCD;
    //The motor for the wheel that shoots the disk
    Jaguar wheelJaguar = new Jaguar(RobotMap.WHEELMOTOR);
    //The motor for the system that tilts the shooter
    public Jaguar tiltShooter = new Jaguar(RobotMap.TILTSHOOTER);
    
    //The speed of the wheel motor
    public static double speed = 0;
    
    public boolean upIsDisabled = false;
    public boolean downIsDisabled = false;
    
    
    public int tiltWay = 0;
    
    //Increases or decreases the motor wheel
    public void motorMove(int direction){
        // 1 = increase
        // 2 = stop
        // 3 = decrease
        // 4 = stop all
        // 5 = jump to constant
        int theSwitch = direction;
        
        //Keeps the speed from going above 100%
        if(theSwitch == 1 && speed >= 1){
            theSwitch = 2;
        }
        //Keeps the speed from going above -100%
        else if (theSwitch == 3 && speed <= -1){
            theSwitch = 2;
        }
        else{}
        
        //Tells which way to increase the wheel motor
        switch(theSwitch){
            case 1: speed += 0.05; break; //Increase
            case 2: speed = 0; break;     //Stop (Because of max/min)
            case 3: speed -= 0.05; break; //Decrease
            case 4: speed = 0; tiltShooter.set(0); break;     //StopEverything(Because of button 11)
            case 5: speed = RobotMap.WHEELCONSTANT; break;
            default: speed = 0; break;    //Stop(Because of error)
        }
        
        wheelJaguar.set(speed);
    }
    
    // Tilts the motor in a specific direction
    public void tiltDirection(int direction){
        switch(direction){
            case 1: 
                if (!upIsDisabled){
                    tiltShooter.set(1); tiltWay = 1;
                }
                    break;//up
            case 2: 
                tiltShooter.set(0); tiltWay = 0; break;  //stop
            case 3: 
                if (!downIsDisabled){
                tiltShooter.set(-1); tiltWay = -1;
                }
                break; //down
            default: 
                tiltShooter.set(0); tiltWay = 0; break; //stop(error handler)
        }
    }
    public void disableUp(){
        upIsDisabled = true;
        if (tiltWay == 1){
        tiltShooter.set(0);
        tiltWay = 0;
        }
    }
    
    public void enableUp(){
        upIsDisabled = false;
    }
    
    public void disableDown(){
        downIsDisabled = true;
        if (tiltWay == -1){
        tiltShooter.set(0);
        tiltWay = 0;
        }
    }
    
    public void enableDown(){
        downIsDisabled = false;
    }
    
    public void testTilter(){
        m_dsLCD = DriverStationLCD.getInstance();
        m_dsLCD.println(DriverStationLCD.Line.kUser1, 1, "We got to here");
        m_dsLCD.updateLCD();
        tiltShooter.set(1);
    }
    
    public void autonomousPrepare(int delay){
        wheelJaguar.set(RobotMap.WHEELCONSTANT); //Power up jaguar
        tiltShooter.set(1);   //Start tilting the shooter
        Timer.delay(delay);   //Delay before shutting of the tilting thing
        tiltShooter.set(0);   //Stop tilting the shooter
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

