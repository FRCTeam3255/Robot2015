package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.OI;
import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.commands.CollectorArcade;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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
	DoubleSolenoid ejectSolenoid = null;
	
	// Robot Drive
	RobotDrive robotDrive = null;
	
	public Collector() {
		leftCollectorTalon = new Talon(RobotMap.COLLECTOR_LEFT_TALON);
		rightCollectorTalon = new Talon(RobotMap.COLLECTOR_RIGHT_TALON);
		
		ejectSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_PCM, 
				RobotMap.COLLECTOR_EJECTOR_DEPLOY_SOLENOID, RobotMap.COLLECTOR_EJECTOR_RETRACT_SOLENOID);
		
		robotDrive = new RobotDrive(leftCollectorTalon, rightCollectorTalon);
	}
	
	public void setSpeed(double s) {
		leftCollectorTalon.set(s);
		rightCollectorTalon.set(s);
	}
	
	public void arcadeDrive() {
		robotDrive.arcadeDrive(OI.manipulatorStick.getRawAxis(RobotMap.AXIS_COLLECTOR_SPEED),
				OI.manipulatorStick.getRawAxis(RobotMap.AXIS_COLLECTOR_PAN));
	}
	
	public void deployToteEjector() {
		ejectSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractToteEjector() {
		ejectSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CollectorArcade());
    }
}
