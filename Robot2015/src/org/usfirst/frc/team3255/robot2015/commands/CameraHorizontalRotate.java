package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.OI;

/**
 *
 */
public class CameraHorizontalRotate extends CommandBase {

    public CameraHorizontalRotate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = OI.driverStick.getPOV(0);
    	if (angle > -1 ) {
        	camera.setHorizontalAngle(angle);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}