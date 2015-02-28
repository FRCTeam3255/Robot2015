package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto1Tote extends CommandGroup {
    
    public  Auto1Tote() {
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
    	
    	addSequential(new CollectorWheelsClose());
    	addSequential(new AutoDriveForwardPickupTote(RobotPreferences.auto1ToteStartSpeed(), RobotPreferences.auto1ToteStartDistance(), true, true));
    	addSequential(new DoDelay(RobotPreferences.auto1ToteDelay()));
    	addSequential(new RotateLeftLowSpeed());
    	addSequential(new DriveDistanceReverse(RobotPreferences.auto1ToteRevSpeed(), RobotPreferences.auto1ToteRevDistance(), false, true));
    	addSequential(new CassetteUnloadAndBackup());
    	addSequential(new Rotate180());
    }
}
