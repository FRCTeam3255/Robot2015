package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Stabilizer extends Subsystem {
	
	// DoubleSolenoids
	DoubleSolenoid stabilizerSolenoid = null;
	
	public Stabilizer() {
		stabilizerSolenoid = new DoubleSolenoid(RobotMap.STABILIZER_PCM, RobotMap.STABILIZER_PADDLE_DEPLOY, RobotMap.STABILIZER_PADDLE_RETRACT);
		
		// set initial condition
		close();
	}
	
	public void close() {
		stabilizerSolenoid.set(Value.kForward);
	}
	
	public void open() {
		stabilizerSolenoid.set(Value.kReverse);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

