package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public AnalogPotentiometer pot = null;
	public DoubleSolenoid solenoid = null;
	public DigitalInput limitswitch = null;
	
	public Claw() {
		super();
		
		init();
	}

	public Claw(String name) {
		super(name);
		
		init();
	}

	public void init() {
		pot = new AnalogPotentiometer(RobotMap.CLAW_POT, 1, 0);
		solenoid = new DoubleSolenoid(RobotMap.CLAW_SOLENOID_OPEN, RobotMap.CLAW_SOLENOID_CLOSE);
		limitswitch = new DigitalInput(RobotMap.CLAW_LIMITSWITCH);
	}
	
	public void open() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void disable() {
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

