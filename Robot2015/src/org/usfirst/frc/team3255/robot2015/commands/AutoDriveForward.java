package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {
    public AutoDriveForward() {
    	// addSequential(new CassetteMoveToTotePickup());
    	addSequential(new TrashGrabberDeploy());
    	addSequential(new DoDelay(RobotPreferences.autoTrashDelay()));
    	addSequential(new DriveDistanceForward(RobotPreferences.autoFwdSpeed(), RobotPreferences.autoFwdDistance(), false, true));
    	addSequential(new CassetteReset());
    	addSequential(new TrashGrabberRetract());
    }
}
