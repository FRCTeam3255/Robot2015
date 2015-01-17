package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.OI;
import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.commands.DriveArcade;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Motor Controllers
	Talon leftFrontTalon = null;
	Talon leftBackTalon = null;
	Talon rightFrontTalon = null;
	Talon rightBackTalon = null;
	
	// Robot Drive
	RobotDrive robotDrive = null;

	public Gyro gyro = null;
	
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
		
		robotDrive = new RobotDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
		
		gyro = new Gyro(RobotMap.DRIVETRAIN_GYRO);
	}
	
	public void setSpeed(double s) {
		leftFrontTalon.set(s);
		leftBackTalon.set(s);
		rightFrontTalon.set(-s);
		rightBackTalon.set(-s);
	}

	public void tankDrive() {
		robotDrive.tankDrive(OI.driverStick.getRawAxis(RobotMap.AXIS_TANK_LEFT),
				OI.driverStick.getRawAxis(RobotMap.AXIS_TANK_RIGHT));
	}
	
	public void arcadeDrive() {
		robotDrive.arcadeDrive(OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_MOVE),
				OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_ROTATE));
	}
	
	public double getSpeed() {
		return leftFrontTalon.get();
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveArcade());
    }

	public void resetGyro() {
		gyro.reset();
	}

	public double getGyro() {
		return gyro.getAngle();
	}
}

