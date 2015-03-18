package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CassetteMoveToStepDown extends CommandBase {

    public CassetteMoveToStepDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.unlock();
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
    	// return cassette.isStepSwitchClosed();
    	return (cassette.isStepSwitchClosed() || cassette.getLiftDistance() <= RobotPreferences.cassetteStepPosition());
    }

    // Called once after isFinished returns true
    protected void end() {
    	cassette.setSpeed(0.0);
    	// TODO remove Lock
    	cassette.lock();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
