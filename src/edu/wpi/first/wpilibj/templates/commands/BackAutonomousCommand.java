/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;


public class BackAutonomousCommand extends CommandBase{
    private final int delay = 2;
    public BackAutonomousCommand(){
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
        requires(motor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //camera.init();
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
        shooter.autonomousPrepare(delay);
        for(int i = 0; i < 3; i++){
            motor.linearFeeder();
            Timer.delay(2);
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
