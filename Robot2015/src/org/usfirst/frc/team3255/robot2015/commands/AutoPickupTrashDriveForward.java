package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPickupTrashDriveForward extends CommandGroup {
    public AutoPickupTrashDriveForward() {
    	// addSequential(new CassetteMoveToTotePickup());
    	addParallel(new CassetteResetEncoder());
    	addParallel(new DriveDistanceForward(RobotPreferences.autoFwdSpeed(), 4.5, false, true));
    	addParallel(new AutoCassettePickupTrash());
    }
}
