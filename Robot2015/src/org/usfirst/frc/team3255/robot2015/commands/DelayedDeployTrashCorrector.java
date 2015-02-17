package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class DelayedDeployTrashCorrector extends CommandBase {

    public DelayedDeployTrashCorrector() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    	requires(trashCorrector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.releaseTote();
    	this.setTimeout(RobotPreferences.deployCorrectorDelay());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	trashCorrector.grabTrash();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
