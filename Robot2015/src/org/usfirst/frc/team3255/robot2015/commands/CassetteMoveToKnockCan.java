package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteMoveToKnockCan extends CommandBase {

	boolean moveUp = true;
	
    public CassetteMoveToKnockCan() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    	requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.unlock();
    	collector.openCollectorWheels();
    	
    	if(cassette.getLiftDistance() < RobotPreferences.posKnockCan()) {
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
    	if(moveUp) {
        	// stop if we hit top
        	if (cassette.isTopSwitchClosed()) {
        		return true;
        	}
    		return (cassette.getLiftDistance() >= RobotPreferences.posKnockCan());
    	}
    	else {
        	// stop if we hit bottom
        	if (cassette.isBottomSwitchClosed()) {
        		return true;
        	}
    		return (cassette.getLiftDistance() <= RobotPreferences.posKnockCan());    		
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
