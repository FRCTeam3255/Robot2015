package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.OI;
import org.usfirst.frc.team3255.robot2015.RobotMap;

/**
 *
 */
public class WaitForTote extends CommandBase {

    public WaitForTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return cassette.isToteDetected();
    	
    	// stickValue is +1 at minimum and -1 at max.
    	// when up tote detect disabled
    	if (OI.manipulatorStick.getRawAxis(RobotMap.AXIS_CASSETTE_FEEDER_MODE) <= -0.9) {
    		return false;
    	}
		return  cassette.isToteDetected();
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
