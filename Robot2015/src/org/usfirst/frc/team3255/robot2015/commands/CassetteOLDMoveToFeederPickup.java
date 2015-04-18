package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteOLDMoveToFeederPickup extends CommandBase {
	
    public CassetteOLDMoveToFeederPickup() {
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
    	// old code based on mag switches
    	// return cassette.isToteHoldSwitchClosed();
    	if (cassette.isBottomSwitchClosed()) {
        	return true;
        }
    	// Relative to last position (negative value)
    	return (cassette.getLiftDistance() <= RobotPreferences.cassetteFeederPickupPosition());    		
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
