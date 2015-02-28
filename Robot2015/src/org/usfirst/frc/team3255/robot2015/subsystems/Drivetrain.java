package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.OI;
import org.usfirst.frc.team3255.robot2015.RobotMap;
import org.usfirst.frc.team3255.robot2015.RobotPreferences;
import org.usfirst.frc.team3255.robot2015.commands.DriveArcade;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
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
	boolean strafeDeployed = false;
	boolean arcadeFullSpeedDisabled = true;
	
	//Motor Controllers
	Talon leftFrontTalon = null;
	Talon leftBackTalon = null;
	Talon rightFrontTalon = null;
	Talon rightBackTalon = null;
	Talon strafeRightTalon = null;
	Talon strafeLeftTalon = null;
	
	// Solenoids
	DoubleSolenoid strafeSolenoid = null;
	
	// Robot Drive
	RobotDrive robotDrive = null;
	
	// Encoders
	public Encoder leftEncoder = null;
	public Encoder rightEncoder = null;

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
		// Drivetrain outside wheels
		leftFrontTalon = new Talon(RobotMap.DRIVETRAIN_FRONT_LEFT_TALON);
		leftBackTalon = new Talon(RobotMap.DRIVETRAIN_BACK_LEFT_TALON);
		rightFrontTalon = new Talon(RobotMap.DRIVETRAIN_FRONT_RIGHT_TALON);
		rightBackTalon = new Talon(RobotMap.DRIVETRAIN_BACK_RIGHT_TALON);
		
		// DriveTrain inner strafe wheels
		strafeRightTalon = new Talon(RobotMap.DRIVETRAIN_STRAFE_RIGHT_TALON);
		strafeLeftTalon = new Talon(RobotMap.DRIVETRAIN_STRAFE_LEFT_TALON);
		
		// Delpoy Retract strafe wheels
		strafeSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_PCM, 
				RobotMap.DRIVETRAIN_STRAFE_DEPLOY_SOLENOID, RobotMap.DRIVETRAIN_STRAFE_RETRACT_SOLENOID);
		
		robotDrive = new RobotDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
		
		robotDrive.setSafetyEnabled(false);
		
		leftEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_LEFT_CHANNEL_A,
				RobotMap.DRIVETRAIN_ENCODER_LEFT_CHANNEL_B);
		rightEncoder = new Encoder(RobotMap.DRIVETRAIN_ENCODER_RIGHT_CHANNEL_A, 
				RobotMap.DRIVETRAIN_ENCODER_RIGHT_CHANNEL_B);
		
		gyro = new Gyro(RobotMap.DRIVETRAIN_GYRO);
		
		// Initialize Drivetrain Conditions
		strafeDisable();
		updateEncoderRatio();
	}
	
	public void setSpeed(double s) {
		leftFrontTalon.set(s);
		leftBackTalon.set(s);
		rightFrontTalon.set(-s);
		rightBackTalon.set(-s);
	}
	
	// positive rotation speed should rotate left
	public void setRotationSpeed(double rotSpeed) {
		// This will set talons so robot will rotate to the left
		robotDrive.arcadeDrive(0.0, -rotSpeed);
	}
	
	public void setStrafeSpeed(double s) {
		strafeLeftTalon.set(s);
		strafeRightTalon.set(s);
	}

	public void tankDrive() {
		robotDrive.tankDrive(OI.driverStick.getRawAxis(RobotMap.AXIS_TANK_LEFT),
				OI.driverStick.getRawAxis(RobotMap.AXIS_TANK_RIGHT));
	}
	
	public void arcadeDrive() {
		// negate the drive axis so that pushing stick forward is +1
		double moveSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_MOVE);
		double rotateSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_ROTATE);
		double arcadeSensitivity = RobotPreferences.driveSensitivity();
		
		if (arcadeFullSpeedDisabled) {
		robotDrive.arcadeDrive(moveSpeed * arcadeSensitivity, rotateSpeed * arcadeSensitivity);
		}
		else {
		robotDrive.arcadeDrive(moveSpeed * arcadeSensitivity, rotateSpeed * 1.0);
		}
	
		if(strafeDeployed) {
			double hSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_HDRIVE);
			double strafeSensitivity = RobotPreferences.driveStrafeSensitivity();
			hSpeed = hSpeed * strafeSensitivity;
			strafeLeftTalon.set(hSpeed);
			strafeRightTalon.set(hSpeed);
		}
		else {
			strafeLeftTalon.set(0.0);
			strafeRightTalon.set(0.0);
		}
	}
	
	public boolean arcadeFullSpeedDisabled() {
		return arcadeFullSpeedDisabled = true;
	}
	
	public boolean arcadeFullSpeedEnabled() {
		return arcadeFullSpeedDisabled = false;
	}
	
	public void strafeEnable() {
		strafeSolenoid.set(DoubleSolenoid.Value.kReverse);
		strafeDeployed = true;
	}
	
	public void strafeDisable() {
		strafeSolenoid.set(DoubleSolenoid.Value.kForward);
		strafeDeployed = false;
	}
	
	public double getSpeed() {
		return leftFrontTalon.get();
	}
	
	public double getStrafeSpeed() {
		return strafeLeftTalon.get();
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

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();	
	}
	
	public double getForwardCount() {
		// TODO Use the encoder that counts up when driving forward
		// TODO Determine if this should get or getRaw
		return leftEncoder.get();
	}
	
	public double getReverseCount() {
		// TODO Use the encoder that counts up when driving reverse
		// TODO Determine if this should get or getRaw
		return rightEncoder.get();
	}
	
	public double getForwardDistance() {
		return leftEncoder.getDistance();
	}
	
	public double getReverseDistance() {
//		return rightEncoder.getDistance();
		return -getForwardDistance();
	}
	
	public void updateEncoderRatio() {
		leftEncoder.setDistancePerPulse(5.0/RobotPreferences.getPulsesPer5Feet());
		rightEncoder.setDistancePerPulse(5.0/RobotPreferences.getPulsesPer5Feet());
	}
}

