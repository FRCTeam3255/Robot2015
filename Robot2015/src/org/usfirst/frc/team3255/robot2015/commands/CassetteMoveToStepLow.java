package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteMoveToStepLow extends CommandBase {
	
    public CassetteMoveToStepLow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.unlock();
    	cassette.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cassette.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        	// stop if we hit bottom
        	if (cassette.isBottomSwitchClosed()) {
        		return true;
        	}
        	// Relative to last position (negative)
    		return (cassette.getLiftDistance() <= RobotPreferences.cassetteStepPositionLow());    		
    }

    // Called once after isFinished returns true
    protected void end() {
    	cassette.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
