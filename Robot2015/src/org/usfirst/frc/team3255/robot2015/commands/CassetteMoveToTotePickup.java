package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.subsystems.Cassette;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class CassetteMoveToTotePickup extends CommandBase {
	
	double speed = -Cassette.LIFT_SPEED;

    public CassetteMoveToTotePickup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(cassette);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cassette.grabTote();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (cassette.isTopSwitchClosed() || cassette.isBottomSwitchClosed()) {
    		speed = -speed;
        	cassette.setLiftSpeed(speed);
    		Timer.delay(Cassette.SWITCH_DELAY);
    	}
    	else {
    		cassette.setLiftSpeed(speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// isTotePickupSwitchOpen will return false when we are at the tote pickup position
    	// so keep going until isTotePickupSwitchOpen returns false
    	return cassette.isTotePickupSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	cassette.setLiftSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
