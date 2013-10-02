/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Developer
 */
public class ShooterTiltTimed extends CommandBase{
    //One Direction
    public double delay;
    
    public ShooterTiltTimed(double time){
        // Use requires() here to declare subsystem dependencies
        this.delay = time;
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
            return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.tiltDirection(1);
        Timer.delay(delay);
        shooter.tiltDirection(2);
        //addParallel(new ParallelCommand());
        //shooter.testTilter();
        //MasterCommand.run();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
