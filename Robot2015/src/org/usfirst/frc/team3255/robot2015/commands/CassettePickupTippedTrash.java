package org.usfirst.frc.team3255.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CassettePickupTippedTrash extends CommandGroup {
    
    public  CassettePickupTippedTrash() {
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
    	
    	// Start: home, closed, and locked
    	// Ends: trash hold, open, and locked
    	
    	addSequential(new CassetteReleaseTote());
    	addSequential(new CassetteUnlock());
    	addSequential(new DoDelay(0.1));
    	addSequential(new CassetteMoveToTotePickup());
    	// In this case WaitForTote actually waits for trash. Looks for limitSwitch closed.
    	addSequential(new WaitForTote());
    	addSequential(new DoDelay(0.1));
    	addSequential(new DeployTrashCorrector());
    	addSequential(new DoDelay(1.0));
    	addSequential(new CassetteMoveToTrashHold());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteMoveToTotePickup());
    	addSequential(new DoDelay(0.1));
    	addSequential(new RetractTrashCorrector());
    	addSequential(new DoDelay(0.1));
    	addSequential(new CassettePickupTrash());
    }
}
