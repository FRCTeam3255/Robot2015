package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteMoveToToteHold extends CommandBase {
	
    public CassetteMoveToToteHold() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.unlock();
    	cassette.resetEncoders();
    	cassette.retractStabilizer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cassette.raise();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// old code based on mag switches
    	// return cassette.isToteHoldSwitchClosed();
    	
    	if (cassette.isTopSwitchClosed()) {
    		return true;
    	}
    	else{
    		return (cassette.getLiftDistance() >= RobotPreferences.cassetteToteHoldPosition());
    		/*if (OI.manipulatorStick.getRawAxis(RobotMap.AXIS_CASSETTE_FEEDER_MODE) <= -0.9) {
    			return (cassette.getLiftDistance() >= RobotPreferences.cassetteToteHoldPosition());
    		}
    		// Relative to last position
    		return (cassette.getLiftDistance() >= RobotPreferences.cassetteLandfillPosition());*/  
    	}	
    }

    // Called once after isFinished returns true
    protected void end() {
    	cassette.setSpeed(0.0);
    	cassette.deployStabilizer();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
