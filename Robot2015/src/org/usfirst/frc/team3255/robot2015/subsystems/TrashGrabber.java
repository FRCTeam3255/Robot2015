package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TrashGrabber extends Subsystem {
	
	// DoubleSolenoids
	DoubleSolenoid trashGrabberSolenoid = null;
	
	public TrashGrabber() {
		trashGrabberSolenoid = new DoubleSolenoid(RobotMap.TRASHGRABBER_PCM, RobotMap.TRASH_GRABBER_PADDLE_DEPLOY, RobotMap.TRASH_GRABBER_PADDLE_RETRACT);
		
		// set initial condition
		close();
	}
	
	public void close() {
		trashGrabberSolenoid.set(Value.kForward);
	}
	
	public void open() {
		trashGrabberSolenoid.set(Value.kReverse);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

