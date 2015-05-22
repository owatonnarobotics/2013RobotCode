/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.BackAutonomousCommand;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.MasterCommand;
import edu.wpi.first.wpilibj.templates.commands.StopEverything;
import edu.wpi.first.wpilibj.templates.commands.TiltSensorDetect;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    //Before the robot starts running, initialize some command variables
    //that are to be run by the scheduler.
    Command autonomousCommand; //The autonomous command
    Command teleOpCommand; //The teleop command
    Command stopEverything; //A command that resets all variables (called when disabled)
    RobotDrive drive = new RobotDrive(RobotMap.FIRSTDRIVE, RobotMap.SECONDDRIVE); // The drivetrain class grabbed from the WPI API
    Joystick joystick1 = OI.joystick1; //One of the joysticks
    Joystick joystick2 = OI.joystick2; //ditto
    Watchdog watchDog;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous and teleop periods
        autonomousCommand = new BackAutonomousCommand();
        teleOpCommand = new MasterCommand();
        stopEverything = new StopEverything();
        watchDog = Watchdog.getInstance();
        // Initialize all subsystems
        CommandBase.init();
    }
    
    
    //Called when the autonomous enable button is pressed on the dashboard
    public void autonomousInit() {
        if (!watchDog.getEnabled()){
            watchDog.setEnabled(true);
        }
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        TiltSensorDetect.check();
        watchDog.feed();
    }

    public void teleopInit() {
        if (!watchDog.getEnabled()){
            watchDog.setEnabled(true);
        }
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        teleOpCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drive.tankDrive(joystick1, joystick2);
        TiltSensorDetect.check();
        watchDog.feed();
        //SmartDashboard.putNumber("speed", Shooter.speed);
    }
    
    public void disabledInit(){
        teleOpCommand.cancel();
        stopEverything.start();
        watchDog.setEnabled(false);
    }
    
    public void disabledPeriodic(){
        Scheduler.getInstance().run();
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
