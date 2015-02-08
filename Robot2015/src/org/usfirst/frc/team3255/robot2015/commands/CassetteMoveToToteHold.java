package org.usfirst.frc.team3255.robot2015.commands;

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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cassette.raise();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// stop if we hit top
    	if (cassette.isTopSwitchClosed()) {
    		return true;
    	}
    	return cassette.isToteHoldSwitchClosed();
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
