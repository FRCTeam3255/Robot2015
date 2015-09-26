package org.usfirst.frc.team3255.robot2015.commands;

/**
 *
 */
public class CassetteMoveToBottom extends CommandBase {
	
    public CassetteMoveToBottom() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.unlock();
    	cassette.retractStabilizer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cassette.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return cassette.isBottomSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	cassette.setSpeed(0.0);
    	cassette.resetEncoders();
    	cassette.deployStabilizer();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
