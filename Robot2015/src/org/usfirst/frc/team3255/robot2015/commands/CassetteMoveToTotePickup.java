package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.subsystems.Cassette;

/**
 *
 */
public class CassetteMoveToTotePickup extends CommandBase {

    public CassetteMoveToTotePickup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.setLiftSpeed(-Cassette.LIFT_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// isTotePickupSwitchOpen will return false when we are at the tote pickup position
    	// so keep going until isTotePickupSwitchOpen returns false
    	return(cassette.isTotePickupSwitchOpen() == false);
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
