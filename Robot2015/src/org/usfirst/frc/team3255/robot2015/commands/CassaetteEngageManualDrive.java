package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassaetteEngageManualDrive extends CommandBase {

    public CassaetteEngageManualDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.manualCassetteEnabled = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cassette.setSpeed((cassette.getManipulatorLiftSpeed())*(RobotPreferences.cassetteRaiseSpeed()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (cassette.isTopSwitchClosed() || cassette.isTotePickupSwitchClosed()) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	cassette.setSpeed(0.0);
    	cassette.manualCassetteEnabled = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
