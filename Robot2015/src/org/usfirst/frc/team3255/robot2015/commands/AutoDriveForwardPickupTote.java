package org.usfirst.frc.team3255.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForwardPickupTote extends CommandGroup {
    
    public  AutoDriveForwardPickupTote(double speed, double distance, boolean spin, boolean in) {
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
    	
    	// delay 1ToteDelay
    	// drive fwd dist=1ToteStartDistance, speed=1ToteStartSpeed
    	// rot left 1ToteRotLeft
    	// drive rev dist=1ToteRevDistance, speed=1ToteRevSpeed
    	// unload and backup
    	// rot 180
    	
    	addParallel(new DriveDistanceForward(speed, distance, spin, in));
    	addParallel(new WaitForToteAndPickup());
    }
}
