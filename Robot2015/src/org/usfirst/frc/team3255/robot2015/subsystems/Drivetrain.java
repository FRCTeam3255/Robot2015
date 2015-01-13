package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Accelerometer
	Accelerometer accel = null;
	
	//Motor Controllers
	Talon leftFrontTalon = null;
	Talon leftBackTalon = null;
	Talon rightFrontTalon = null;
	Talon rightBackTalon = null;
	
    public Drivetrain() {
		super();
		
		init();
	}

	public Drivetrain(String name) {
		super(name);
		
		init();
	}

	public void init() {
		leftFrontTalon = new Talon(RobotMap.DRIVETRAIN_FRONT_LEFT_TALON);
		leftBackTalon = new Talon(RobotMap.DRIVETRAIN_BACK_LEFT_TALON);
		rightFrontTalon = new Talon(RobotMap.DRIVETRAIN_FRONT_RIGHT_TALON);
		rightBackTalon = new Talon(RobotMap.DRIVETRAIN_BACK_RIGHT_TALON);
		
		accel = new BuiltInAccelerometer();
	}
	
	public void setSpeed(double s) {
		leftFrontTalon.set(s);
		leftBackTalon.set(s);
		rightFrontTalon.set(-s);
		rightBackTalon.set(-s);
	}
	
	public double getAccelX() {
		return accel.getX();
	}
	
	public double getAccelY() {
		return accel.getY();
	}
	
	public double getAccelZ() {
		return accel.getZ();
	}
	
	public double getSpeed() {
		return leftFrontTalon.get();
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

