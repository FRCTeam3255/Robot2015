package org.usfirst.frc.team3255.robot2015.commands;

/**
 *
 */
public class DriveDistanceForward extends CommandBase {
	
	double setPoint;
	double speed;

    public DriveDistanceForward(double s, double feet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    	speed = s;
    	setPoint = feet;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetEncoders();
    	drivetrain.updateEncoderRatio();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(drivetrain.getForwardDistance() >= setPoint);
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
