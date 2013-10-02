
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author bradmiller
 */
public class ShooterWheel extends CommandBase {
    int position;
    
    public ShooterWheel(int way) {
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
        position = way;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //motor.motorDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
            return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.motorMove(position);
        SmartDashboard.putNumber("speed", Shooter.speed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
