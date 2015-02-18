package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

/**
 *
 */
public class DrivetrainRotateLeft extends CommandBase {

    public DrivetrainRotateLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*if (drivetrain.arcadeFullSpeedDisabled()) {
    		drivetrain.setRotationSpeed(-RobotPreferences.gyroRotationSpeed());
    	}
    	drivetrain.setRotationSpeed(-1.0);
    	*/
    	drivetrain.setRotationSpeed(-RobotPreferences.gyroRotationSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// TODO check which degree will turn the robot to the left
    	// Turn left requires negative value and <= (Less Than) of RobotPreference
        return(drivetrain.getGyro() <= -RobotPreferences.gyroRotateLeftAngle());
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
