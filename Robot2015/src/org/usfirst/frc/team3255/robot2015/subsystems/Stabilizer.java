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
	DoubleSolenoid stabilizerDeploy = null;
	
	public Stabilizer() {
		stabilizerDeploy = new DoubleSolenoid(RobotMap.COLLECTOR_PCM, RobotMap.STABILIZER_PADDLE_DEPLOY, RobotMap.STABILIZER_PADDLE_RETRACT);
	}
	
	public void deployStabilizer() {
		stabilizerDeploy.set(Value.kForward);
	}
	
	public void retractStabilizer() {
		stabilizerDeploy.set(Value.kReverse);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

