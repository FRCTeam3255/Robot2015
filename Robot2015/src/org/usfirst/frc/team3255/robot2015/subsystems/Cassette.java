package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.RobotPreferences;
import org.usfirst.frc.team3255.robot2015.commands.WaitForToteAndPickup;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
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
	
	DoubleSolenoid stabilizerPickUpSolenoid = null;
	DoubleSolenoid stabilizerClawSolenoid = null;
	DoubleSolenoid stabilizerBrakeSolenoid = null;
	
	//Encoders
	Encoder liftEncoder = null;
	
	private boolean toteGrabbed = true;
	private boolean manualMode = false;
	
    // Initialize your subsystem here
    public Cassette() {
    	leftLiftTalon = new Talon(RobotMap.CASSETTE_LEFT_LIFT_TALON);
		rightLiftTalon = new Talon(RobotMap.CASSETTE_RIGHT_LIFT_TALON);
		
		lockSolenoid = new DoubleSolenoid(RobotMap.CASSETTE_PCM,
				RobotMap.CASSTTE_LOCK_DEPLOY_SOLENOID, RobotMap.CASSTTE_LOCK_RETRACT_SOLENOID);
		
		stabilizerPickUpSolenoid = new DoubleSolenoid(RobotMap.CASSETTE_PCM, 
				RobotMap.CASSETTE_STABILIZER_DEPLOY_SOLENOID,
				RobotMap.CASSETTE_STABILIZER_RETRACT_SOLENOID);
		stabilizerClawSolenoid = new DoubleSolenoid(RobotMap.CASSETTE_PCM, 
				RobotMap.CASSETTE_STABILIZER_OPEN_SOLENOID,
				RobotMap.CASSETTE_STABILIZER_CLOSE_SOLENOID);
		stabilizerBrakeSolenoid = new DoubleSolenoid(RobotMap.CASSETTE_PCM, 
				RobotMap.CASSETTE_STABILIZER_BRAKE_ENGAGE_SOLENOID,
				RobotMap.CASSETTE_STABILIZER_BRAKE_DISENGAGE_SOLENOID);
		
		topSwitch = new DigitalInput(RobotMap.CASSETTE_TOP_MAGSWITCH);
		trashHoldSwitch = new DigitalInput(RobotMap.CASSETTE_TRASH_HOLD_MAGSWITCH);
		toteHoldSwitch = new DigitalInput(RobotMap.CASSETTE_TOTE_HOLD_MAGSWITCH);
		stepSwitch = new DigitalInput(RobotMap.CASSETTE_STEP_MAGSWITCH);
		totePickupSwitch = new DigitalInput(RobotMap.CASSETTE_TOTE_PICKUP_MAGSWITCH);
		bottomSwitch = new DigitalInput(RobotMap.CASSETTE_BOTTOM_MAGSWITCH);
		
		toteDetectSwitch = new DigitalInput(RobotMap.CASSTTE_TOTE_DETECT_LIMITSWITCH);
		
		liftEncoder= new Encoder(RobotMap.CASSETTE_LIFT_ENCODER_CHANNEL_A,
				RobotMap.CASSETTE_LIFT_ENCODER_CHANNEL_B, false);
		
		// Initialize Cassette Conditions
		lock();
		updateEncoderRatio();
	}
    
    public void raise() {
    	double s = RobotPreferences.cassetteRaiseSpeed();
    	setSpeed(s);
    }
    
    public void lower() {
    	double s = RobotPreferences.cassetteSpeed();
    	setSpeed(-s);
    }
    
    // positive speed moves up
    public void setSpeed(double s) {
    	leftLiftTalon.set(s);
    	rightLiftTalon.set(s);
    }
    
    // Solenoids
    public void lock() {
    	lockSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void unlock() {
    	lockSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean isToteGrabbed() {
    	return toteGrabbed;
    }
   
    // Encoders
    public void resetEncoders() {
		liftEncoder.reset();	
	}
	
	public double getLiftCount() {
		return liftEncoder.get();
	}
	
	// return cassette lift distance in inches from bottom
	public double getLiftDistance() {
		return liftEncoder.getDistance();
	}
	
	public void updateEncoderRatio() {
		// set encoder to return distance in inches
		liftEncoder.setDistancePerPulse(12.0/RobotPreferences.getCassettePulsesPerFoot());
	}
    
    // Switches
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
    
    // Modes
    public boolean isHome() {
    	return ((isToteGrabbed() == true) && (isToteHoldSwitchClosed() == true));
    }
    
    public boolean isTrashPickup() {
    	return ((isToteGrabbed() == false) && (isTotePickupSwitchClosed() == true));
    }
    
	public void enableManualMode() {
		manualMode = true;
		unlock();
	}

	public void disableManualMode() {
		manualMode = false;
	}

	public boolean isManualMode() {
		return manualMode;
	}
	
	public void deployStabilizer() {
		stabilizerPickUpSolenoid.set(DoubleSolenoid.Value.kForward);
    }

	public void retractStabilizer() {
		stabilizerPickUpSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
	
	public void openStabilizer() {
		stabilizerClawSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void closeStabilizer() {
		stabilizerClawSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void engageStablizerBrake() {
		stabilizerBrakeSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void disengageStabilizerBrake() {
		stabilizerBrakeSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new WaitForToteAndPickup());
    }
}
