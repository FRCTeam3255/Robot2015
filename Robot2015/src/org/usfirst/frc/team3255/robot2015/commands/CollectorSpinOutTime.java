package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class CollectorSpinOutTime extends CommandBase {

    public CollectorSpinOutTime() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(collector);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(RobotPreferences.auto1ToteSpinOutTime());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	collector.spinOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
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
