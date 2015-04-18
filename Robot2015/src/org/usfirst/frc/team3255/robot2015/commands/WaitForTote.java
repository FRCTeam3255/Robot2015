package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class WaitForTote extends CommandBase {
	
	int count = 0;

    public WaitForTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	count = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (cassette.isToteDetected()) {
    		count = (count +1);
    	}
    	else {
    		count = 0;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return cassette.isToteDetected();
    	
    	// stickValue is +1 at minimum and -1 at max.
    	// when up tote detect disabled
    	/*if (OI.manipulatorStick.getRawAxis(RobotMap.AXIS_CASSETTE_FEEDER_MODE) <= -0.9) {
    		return false;
    	}*/
		return  (count > RobotPreferences.waitForToteDelay());
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
