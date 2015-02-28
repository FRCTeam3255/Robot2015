package org.usfirst.frc.team3255.robot2015.commands;

/**
 *
 */
public class DriveDistanceReverse extends CommandBase {
	
	double setPoint;
	double speed;
	boolean spin;
	boolean in;

	// this routine takes a positive speed and positive feet, but goes in reverse at that speed for that distance
    public DriveDistanceReverse(double s, double feet, boolean spin, boolean in) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    	requires(collector);
    	speed = s;
    	setPoint = feet;
    	this.spin = spin;
    	this.in = in;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetEncoders();
    	drivetrain.updateEncoderRatio();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.setSpeed(-speed);
    	if(spin) {
    		if(in) {
	    		collector.spinIn();
	    	}
	    	else {
	    		collector.spinOut();
	    	}
    	}
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
