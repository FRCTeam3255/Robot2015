package org.usfirst.frc.team3255.robot2015.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CassetteUnloadAndBackup extends CommandGroup {
    
	// Starts: Above tote pickup, open or closed, and locked or unlocked
	// Ends: Tote Hold, closed, and locked
    public  CassetteUnloadAndBackup() {
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
    	
    	addSequential(new StabilizerOpen());
    	addSequential(new CollectorWheelsOpen());
    	addSequential(new CassetteUnload());
    	addSequential(new DriveReverseFromTote());
    	addSequential(new CassetteMoveToToteHold());
    	addSequential(new CollectorWheelsClose());
    	addSequential(new StabilizerClose());
    	addSequential(new CassetteGrabTote());
    	addSequential(new CassetteLock());
    }
}
