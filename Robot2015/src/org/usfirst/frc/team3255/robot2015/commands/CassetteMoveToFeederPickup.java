package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteMoveToFeederPickup extends CommandBase {

	boolean moveUp = true;
	
    public CassetteMoveToFeederPickup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.unlock();
    	
    	if(cassette.getLiftDistance() < RobotPreferences.cassetteFeederPickupPosition()) {
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
    		return (cassette.getLiftDistance() >= RobotPreferences.cassetteFeederPickupPosition());
    	}
    	else {
        	// stop if we hit bottom
        	if (cassette.isBottomSwitchClosed()) {
        		return true;
        	}
        	return (Math.abs(cassette.getLiftDistance()) >= RobotPreferences.cassetteFeederPickupPosition());   
    		//return (cassette.getLiftDistance() <= RobotPreferences.cassetteFeederPickupPosition());   
        	
        	/* Untested code
        	 if (cassette.isBottomSwitchClosed()) {
        		return true;
        	}
        	else {
        		if (cassette.isEncoderZeroAtTop()) {
        			return (Math.abs(cassette.getLiftDistance()) >= RobotPreferences.cassetteFeederPickupPosition());
        		}
        		return (cassette.getLiftDistance() <= RobotPreferences.cassetteFeederPickupPosition());
        	}
        	 */
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
