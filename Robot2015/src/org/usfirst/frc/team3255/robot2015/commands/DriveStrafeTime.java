package org.usfirst.frc.team3255.robot2015.commands;

/**
 *
 */
public class DriveStrafeTime extends CommandBase {
	
	double timeOut;
	double strafeSpeed;

    public DriveStrafeTime(double speed, double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	timeOut = seconds;
    	strafeSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.strafeEnable();
    	this.setTimeout(timeOut);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.setStrafeSpeed(strafeSpeed);
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
