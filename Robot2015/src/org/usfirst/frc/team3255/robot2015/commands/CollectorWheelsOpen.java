package org.usfirst.frc.team3255.robot2015.commands;

/**
 *
 */
public class CollectorWheelsOpen extends CommandBase {

    public CollectorWheelsOpen() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	// requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	collector.openCollectorWheels();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
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
