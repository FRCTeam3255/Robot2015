package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TrashCorrector extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Solenoid trashSolenoid = null;

    public TrashCorrector() {
		super();
		trashSolenoid = new Solenoid(RobotMap.TRASH_CORRECTOR_PCM,
				RobotMap.TRASH_CORRECTOR_DEPLOY_SOLENOID);
    }
    
    public void grabTrash() {
    	trashSolenoid.set(true);
    }
    
    public void releaseTrash() {
    	trashSolenoid.set(false);
    }

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

