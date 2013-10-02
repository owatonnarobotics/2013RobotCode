package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.SingleMotor;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {
    
    //creates an instance of the OI
    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static SingleMotor motor = new SingleMotor();
    public static Shooter shooter = new Shooter();
    public static DigitalInput topSensor;
    public static DigitalInput bottomSensor;
    
    
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        topSensor = new DigitalInput(RobotMap.DIGITALTOPSENSOR);
        bottomSensor = new DigitalInput(RobotMap.DIGITALBOTTOMSENSOR);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
