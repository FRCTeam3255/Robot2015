package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Claw() {
		super();
		
		init();
	}

	public Claw(String name) {
		super(name);
		
		init();
	}
	
	public AnalogPotentiometer pot = null;
	
	// Double Solenoids
	public DoubleSolenoid clawSolenoid = null;
	
	// Limimt Switches
	DigitalInput clawBottomSwitch = null;
	DigitalInput clawTopSwitch = null;
	
	// Motor Controllers
	Talon clawLeftLiftTalon = null;
	Talon clawRightLiftTalon = null;
	
	public static final double CLAW_LIFT_SPEED = 0.5;
	public static final double CLAW_SWITCH_DELAY = 0.25;

	public void init() {
		pot = new AnalogPotentiometer(RobotMap.CLAW_POT, 1, 0);
		
		clawSolenoid = new DoubleSolenoid(RobotMap.CLAW_OPEN_SOLENOID, RobotMap.CLAW_CLOSE_SOLENOID);
		
		clawBottomSwitch = new DigitalInput(RobotMap.CLAW_BOTTOM_LIMITSWITCH);
		clawTopSwitch = new DigitalInput(RobotMap.CLAW_TOP_LIMITSWITCH);
		
		clawLeftLiftTalon = new Talon(RobotMap.CLAW_LEFT_LIFT_TALON);
		clawRightLiftTalon = new Talon(RobotMap.CLAW_RIGHT_LIFT_TALON);
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
	
	public boolean isClawBottomedOut() {
		return (clawBottomSwitch.get() == false);
	}
	
	public boolean isClawToppedOut() {
		return (clawTopSwitch.get() == false);
	}
	
	public void setClawLiftSpeed(double s) {
		clawLeftLiftTalon.set(s);
		clawRightLiftTalon.set(s);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

