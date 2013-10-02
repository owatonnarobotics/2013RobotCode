/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Developer
 */
public class ShooterTilt extends MasterCommand{
    //One Direction
    public int direction;
    
    public ShooterTilt(int way){
        // Use requires() here to declare subsystem dependencies
        this.direction = way;
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
        shooter.tiltDirection(this.direction);
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
