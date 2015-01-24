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
	public DoubleSolenoid clawSolenoid = null;
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
		clawSolenoid = new DoubleSolenoid(RobotMap.CLAW_OPEN_SOLENOID, RobotMap.CLAW_CLOSE_SOLENOID);
		limitswitch = new DigitalInput(RobotMap.CLAW_LIMITSWITCH_1);
	}
	
	public void open() {
		clawSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close() {
		clawSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void disable() {
		clawSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

