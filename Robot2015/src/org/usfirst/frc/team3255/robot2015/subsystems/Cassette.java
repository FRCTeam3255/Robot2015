package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.RobotPreferences;
import org.usfirst.frc.team3255.robot2015.commands.WaitForToteAndPickup;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cassette extends Subsystem {

	//Motor Controllers
	Talon leftLiftTalon = null;
	Talon rightLiftTalon = null;
	
	//Limit Switches (false = closed)
	DigitalInput topSwitch = null;
	DigitalInput trashHoldSwitch = null;
	DigitalInput toteHoldSwitch = null;
	DigitalInput stepSwitch = null;
	DigitalInput totePickupSwitch = null;
	DigitalInput bottomSwitch = null;
	
	DigitalInput toteDetectSwitch =null;
	
	//Solenoids
	DoubleSolenoid lockSolenoid = null;
	Solenoid trashSolenoid = null;
	DoubleSolenoid paddleSolenoid = null;
	
    // Initialize your subsystem here
    public Cassette() {
    	leftLiftTalon = new Talon(RobotMap.CASSETTE_LEFT_LIFT_TALON);
		rightLiftTalon = new Talon(RobotMap.CASSETTE_RIGHT_LIFT_TALON);
		
		trashSolenoid = new Solenoid(RobotMap.CASSETTE_PCM,
				RobotMap.CASSETTE_TRASH_DEPLOY_SOLENOID);
		lockSolenoid = new DoubleSolenoid(RobotMap.CASSETTE_PCM,
				RobotMap.CASSTTE_LOCK_DEPLOY_SOLENOID, RobotMap.CASSTTE_LOCK_RETRACT_SOLENOID);
		paddleSolenoid = new DoubleSolenoid(RobotMap.CASSETTE_PCM,
				RobotMap.CASSETTE_PADDLE_DEPLOY_SOLENOID, RobotMap.CASSTTE_PADDLE_RETRACT_SOLENOID);
		
		topSwitch = new DigitalInput(RobotMap.CASSETTE_TOP_MAGSWITCH);
		trashHoldSwitch = new DigitalInput(RobotMap.CASSETTE_TRASH_HOLD_MAGSWITCH);
		toteHoldSwitch = new DigitalInput(RobotMap.CASSETTE_TOTE_HOLD_MAGSWITCH);
		stepSwitch = new DigitalInput(RobotMap.CASSETTE_STEP_MAGSWITCH);
		totePickupSwitch = new DigitalInput(RobotMap.CASSETTE_TOTE_PICKUP_MAGSWITCH);
		bottomSwitch = new DigitalInput(RobotMap.CASSETTE_BOTTOM_MAGSWITCH);
		
		toteDetectSwitch = new DigitalInput(RobotMap.CASSTTE_TOTE_DETECT_LIMITSWITCH);
		
		// Initialize Cassette Conditions
		lock();
	}
    
    public void raise() {
    	double s = RobotPreferences.cassetteRaiseSpeed();
    	setSpeed(s);
    }
    
    public void lower() {
    	double s = RobotPreferences.cassetteLowerSpeed();
    	setSpeed(s);
    }
    
    // positive speed moves up
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
    	trashSolenoid.set(true);
    }
    
    public void releaseTrash() {
    	trashSolenoid.set(false);
    }
    
    public void grabTote() {
    	paddleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void releaseTote() {
    	paddleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean isTopSwitchClosed() {
    	return (topSwitch.get() == false);
    }
    
    public boolean isTrashHoldSwitchClosed() {
    	return (trashHoldSwitch.get() == false);
    }
    
    public boolean isToteHoldSwitchClosed() {
    	return (toteHoldSwitch.get() == false);
    }
    
    public boolean isStepSwitchClosed() {
    	return (stepSwitch.get() == false);
    }
    
    public boolean isTotePickupSwitchClosed() {
    	return (totePickupSwitch.get() == false);
    }
    
    public boolean isBottomSwitchClosed() {
    	return (bottomSwitch.get() == false);
    }
    
    public boolean isToteDetected() {
    	return (toteDetectSwitch.get() == false);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new WaitForToteAndPickup());
    }
}
