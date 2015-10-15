package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPickupTrashDriveForward extends CommandGroup {
    public AutoPickupTrashDriveForward() {
    	// addSequential(new CassetteMoveToTotePickup());
    	addSequential(new CassettePrepareTrashPickup());
    	addSequential(new CassettePickupTrash());
    	addSequential(new DoDelay(0.1));
    	addSequential(new DriveDistanceForward(RobotPreferences.autoFwdSpeed(), RobotPreferences.autoFwdDistance(), false, true));
    }
}
