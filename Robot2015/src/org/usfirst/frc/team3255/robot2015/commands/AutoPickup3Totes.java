package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPickup3Totes extends CommandGroup {
    
    public  AutoPickup3Totes() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new DriveForwardPickupTote());
    	addSequential(new DriveForwardPickupTote());
    	addSequential(new DriveForwardPickupTote());
    	// TODO Find DriveStrafeTime(seconds) based off of testing.
    	double speed = RobotPreferences.autoStrafeSpeed();
    	double time = RobotPreferences.autoStrafeTime();
    	addSequential(new DriveStrafeTime(speed, time));
    	addSequential(new CassetteUnloadAndBackup());
    }
}
