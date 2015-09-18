package org.usfirst.frc.team3255.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorEjectTotesOnStep extends CommandGroup {
    
    public  CollectorEjectTotesOnStep() {
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
    	
    	// Old Code
    	/*addSequential(new CassetteUnlock());
    	addSequential(new CollectorWheelsOpen());
    	addSequential(new DoDelay(0.1));
    	addSequential(new CassetteMoveToStep());
    	addSequential(new CassetteLock());
    	addSequential(new CollectorDeployToteEjector());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteReleaseTote());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CollectorRetractToteEjector());
    	addSequential(new DriveReverseFromTote());*/
    	
    	addSequential(new CassetteUnlock());
    	addSequential(new CollectorWheelsOpen());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteMoveToStepHigh());
    	addSequential(new CassetteLock());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CollectorOLDDeployToteEjector());
    	addSequential(new CassetteUnlock());
    	addSequential(new DoDelay(0.5));
    	addSequential(new CassetteMoveToStepLow());
    	addSequential(new CollectorOLDRetractToteEjector());
    	addSequential(new DoDelay(0.5));
    	addSequential(new DriveReverseFromTote());
    	addSequential(new CassettePickupTote());
    }
}
