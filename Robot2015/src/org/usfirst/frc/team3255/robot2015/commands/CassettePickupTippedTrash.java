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
    	/*
    	addSequential(new DeployTrashCorrector());
    	addSequential(new DoDelay(1.0));
    	addSequential(new CassetteUnlock());
    	addSequential(new DoDelay(0.1));
    	addSequential(new CassetteMoveToToteHold());
    	addSequential(new DoDelay(RobotPreferences.grabDelay()));
    	addSequential(new CassetteGrabTote());
    	addSequential(new CassetteMoveToTrashHold());
    	addSequential(new RetractTrashCorrector());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteMoveToStepDown());
    	addSequential(new CassetteReleaseTote());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteGrabTote());
    	addSequential(new CassetteMoveToTrashHold());
    	addSequential(new CassetteLock());
    	*/
    	
    	addSequential(new CassetteUnlock());
    	addSequential(new DoDelay(0.1));

    	// do the following two commands together
    	addParallel(new CassetteMovePastStep());
    	addSequential(new DelayedDeployTrashCorrector());
    	
    	/*
    	addSequential(new RetractTrashCorrector());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteMoveToStepDown());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteGrabTote());
    	addSequential(new CassetteMoveToTrashHold());
    	addSequential(new CassetteLock());
    	*/
    }
}
