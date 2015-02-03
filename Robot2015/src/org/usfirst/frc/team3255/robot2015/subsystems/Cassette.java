package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.commands.WaitForToteAndPickup;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Cassette extends PIDSubsystem {

	//Motor Controllers
	Talon leftLiftTalon = null;
	Talon rightLiftTalon = null;
	Talon leftCollectorTalon = null;
	Talon rightCollectorTalon = null;
	
	//Limit Switches (false = closed)
	DigitalInput totePickupSwitch = null;
	DigitalInput toteHoldSwitch = null;
	DigitalInput trashPickupSwitch = null;
	DigitalInput trashHoldSwitch = null;
	DigitalInput topSwitch = null;
	DigitalInput bottomSwitch = null;
	
	DigitalInput toteDetectSwitch =null;
	
	//Encoder
	public Encoder liftEncoder = null;
	
	//Solenoids
	DoubleSolenoid lockSolenoid = null;
	DoubleSolenoid trashSolenoid = null;
	DoubleSolenoid liftSolenoid = null;
	
	public static final double LIFT_SPEED = 0.5;
	
    // Initialize your subsystem here
    public Cassette() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0.0, 0.0, 0.0);
    	
    	leftLiftTalon = new Talon(RobotMap.CASSETTE_LEFT_LIFT_TALON);
		rightLiftTalon = new Talon(RobotMap.CASSETTE_RIGHT_LIFT_TALON);
		
		lockSolenoid = new DoubleSolenoid(0, RobotMap.CASSTTE_DEPLOY_LOCK_SOLENOID, RobotMap.CASSTTE_RETRACT_LOCK_SOLENOID);
		trashSolenoid = new DoubleSolenoid(0, RobotMap.CASSETTE_DEPLOY_TRASH_SOLENOID, RobotMap.CASSETTE_RETRACT_TRASH_SOLENOID);
		liftSolenoid = new DoubleSolenoid(1, RobotMap.CASSETTE_DEPLOY_LIFT_SOLENOID, RobotMap.CASSTTE_RETRACT_LIFT_SOLENOID);
		
		liftEncoder = new Encoder(RobotMap.CASSETTE_ENCODER_CHANNEL_A, RobotMap.CASSETTE_ENCODER_CHANNEL_B, false, Encoder.EncodingType.k4X);
		liftEncoder.setDistancePerPulse(0.01);
		
		bottomSwitch = new DigitalInput(RobotMap.CASSETTE_BOTTOM_MAGSWITCH);
		totePickupSwitch = new DigitalInput(RobotMap.CASSETTE_TOTE_PICKUP_MAGSWITCH);
		toteHoldSwitch = new DigitalInput(RobotMap.CASSETTE_TOTE_HOLD_MAGSWITCH);
		trashPickupSwitch = new DigitalInput(RobotMap.CASSETTE_TRASH_PICKUP_MAGSWITCH);
		trashHoldSwitch = new DigitalInput(RobotMap.CASSETTE_TRASH_HOLD_MAGSWITCH);
		topSwitch = new DigitalInput(RobotMap.CASSETTE_TOP_MAGSWITCH);
		
		toteDetectSwitch = new DigitalInput(RobotMap.CASSTTE_TOTE_DETECT_LIMITSWITCH);
		
		PIDController controller = this.getPIDController();
		controller.setPID(0.01, 0.0, 0.0);
		controller.setSetpoint(0.0);
	}
    
    public void setSpeed(double s) {
    	leftLiftTalon.set(s);
    	rightLiftTalon.set(s);
    }
    
    public void lock() {
    	lockSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void unlock() {
    	lockSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void grabTrash() {
    	trashSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void releaseTrash() {
    	trashSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void grabTote() {
    	liftSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void releaseTote() {
    	liftSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean isBottomSwitchClosed() {
    	return (bottomSwitch.get() == false);
    }
    
    public boolean isTotePickupSwitchClosed() {
    	return (totePickupSwitch.get() == false);
    }
    
    public boolean isToteHoldSwitchClosed() {
    	return (toteHoldSwitch.get() == false);
    }
    
    public boolean isTrashPickupSwitchClosed() {
    	return (trashPickupSwitch.get() == false);
    }
    
    public boolean isTrashHoldSwitchClosed() {
    	return (trashHoldSwitch.get() == false);
    }
    
    public boolean isTopSwitchClosed() {
    	return (topSwitch.get() == false);
    }
    
    public boolean isToteDetected() {
    	return (toteDetectSwitch.get() == false);
    }
    
    public double getLiftSpeed() {
    	return Preferences.getInstance().getDouble("CassetteLiftSpeed", Cassette.LIFT_SPEED);
    }
    
    public double getLowerSpeed() {
    	return -Preferences.getInstance().getDouble("CassetteLowerSpeed", Cassette.LIFT_SPEED);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new WaitForToteAndPickup());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return liftEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	// scale motor output to not exceed more than 50% motor power
    	if(output > 1.0) {
    		output = 1.0;
    	}
    	else if (output < -1.0) {
    		output = -1.0;
    	}
    	output = output * 0.15;
    	leftLiftTalon.set(output);
    	rightLiftTalon.set(output);
    }
}
