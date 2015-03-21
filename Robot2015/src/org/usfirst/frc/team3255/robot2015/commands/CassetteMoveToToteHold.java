package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteMoveToToteHold extends CommandBase {

	boolean moveUp = true;
	
    public CassetteMoveToToteHold() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.unlock();
    	
    	if(cassette.getLiftDistance() < RobotPreferences.cassetteToteHoldPosition()) {
    		moveUp = true;
    	}
    	else {
    		moveUp = false;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(moveUp) {
    		cassette.raise();
    	}
    	else {
    		cassette.lower();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// old code based on mag switches
    	// return cassette.isToteHoldSwitchClosed();
    	
    	if(moveUp) {
        	// stop if we hit top
        	if (cassette.isTopSwitchClosed()) {
        		return true;
        	}
    		return (cassette.getLiftDistance() >= RobotPreferences.cassetteToteHoldPosition());
    	}
    	else {
        	// stop if we hit bottom
        	if (cassette.isBottomSwitchClosed()) {
        		return true;
        	}
    		return (cassette.getLiftDistance() <= RobotPreferences.cassetteToteHoldPosition());    		
    	}
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
