package org.usfirst.frc.team3255.robot2015.commands;

/**
 *
 */
public class AutoDriveStrafeTime extends CommandBase {

    public AutoDriveStrafeTime() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.strafeEnable();
    	this.setTimeout(drivetrain.autoStrafeTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.autoStrafeSpeed();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.strafeDisable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
