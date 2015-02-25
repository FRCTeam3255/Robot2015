package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.commands.StabilizerClose;

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
	}
	
	public void deployStabilizer() {
		stabilizerSolenoid.set(Value.kForward);
	}
	
	public void retractStabilizer() {
		stabilizerSolenoid.set(Value.kReverse);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StabilizerClose());
    }
}

