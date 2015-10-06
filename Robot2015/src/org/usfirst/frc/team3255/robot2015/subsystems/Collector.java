package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.OI;
import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.RobotPreferences;
import org.usfirst.frc.team3255.robot2015.commands.CollectorArcade;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	
	// Motor Controllers
	Talon leftCollectorTalon = null;
	Talon rightCollectorTalon = null;
	
	// DoubleSolenoids
	// DoubleSolenoid ejectSolenoid = null;
	DoubleSolenoid collectorSolenoid = null;
	
	// Robot Drive
	RobotDrive robotDrive = null;
	
	public Collector() {
		leftCollectorTalon = new Talon(RobotMap.COLLECTOR_LEFT_TALON);
		rightCollectorTalon = new Talon(RobotMap.COLLECTOR_RIGHT_TALON);
		
	/*	ejectSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_PCM, 
				RobotMap.COLLECTOR_EJECTOR_DEPLOY_SOLENOID, RobotMap.COLLECTOR_EJECTOR_RETRACT_SOLENOID);
	*/
		collectorSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_PCM, RobotMap.COLLECTOR_WHEEL_DEPLOY, RobotMap.COLLECTOR_WHEEL_RETRACT);
		
		robotDrive = new RobotDrive(leftCollectorTalon, rightCollectorTalon);
		robotDrive.setSafetyEnabled(false);
		
		// set initial conditions
		// retractToteEjector();
		closeCollectorWheels();
	}
	
	public void setSpeed(double s) {
		leftCollectorTalon.set(-s);
		rightCollectorTalon.set(s);
	}
	
	public void spinIn(double s) {
		setSpeed(s);
	}
	
	public void spinOut(double s) {
		setSpeed(-s);
	}
	
	public void arcadeDrive() {
		robotDrive.arcadeDrive(RobotPreferences.collectorSpeed()*(-OI.manipulatorStick.getRawAxis(RobotMap.AXIS_COLLECTOR_SPEED)),
				RobotPreferences.collectorSpeed()*(OI.manipulatorStick.getRawAxis(RobotMap.AXIS_COLLECTOR_PAN)));
	}
	/*
	public void deployToteEjector() {
		ejectSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractToteEjector() {
		ejectSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	*/
	
	public void closeCollectorWheels() {
		collectorSolenoid.set(Value.kForward);
	}
	
	public void openCollectorWheels() {
		collectorSolenoid.set(Value.kReverse);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CollectorArcade());
    }
}

