package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.subsystems.Claw;

import edu.wpi.first.wpilibj.Preferences;

/**
 *
 */
public class ClawMoveDown extends CommandBase {

    double speed = -Claw.CLAW_LIFT_SPEED;
    Preferences prefs = Preferences.getInstance();
	
	public ClawMoveDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	speed = -prefs.getDouble("Claw Lower Seed", Claw.CLAW_LIFT_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	claw.setClawLiftSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return claw.isClawBottomedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	claw.setClawLiftSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
