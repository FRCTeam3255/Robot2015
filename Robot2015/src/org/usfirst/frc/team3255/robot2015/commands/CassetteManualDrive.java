package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.OI;
import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteManualDrive extends CommandBase {

    public CassetteManualDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.enableManualMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double s = OI.manipulatorStick.getRawAxis(RobotMap.AXIS_CASSETTE_SPEED);
    	s = s * RobotPreferences.cassetteRaiseSpeed();
    	
    	if (cassette.isBottomSwitchClosed() && s < 0.0) {
    		cassette.setSpeed(0.0);
    	}
    	if (cassette.isTopSwitchClosed() && s > 0.0) {
    		cassette.setSpeed(0.0);
    	}
    	cassette.setSpeed(s);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	/*if (cassette.isTopSwitchClosed() || cassette.isTotePickupSwitchClosed()) {
    		//cassette.setSpeed(0.0);
    		//return true;
    	}*/
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	cassette.disableManualMode();
    	cassette.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
