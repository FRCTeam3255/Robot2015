package org.usfirst.frc.team3255.robot2015.commands;

/**
 *
 */
public class DriveDistanceReverse extends CommandBase {
	
	double setPoint;

    public DriveDistanceReverse(double feet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    	setPoint = feet;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.setSpeed(-0.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(drivetrain.getReverseDistance() >= setPoint);
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
