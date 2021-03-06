package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;
import org.usfirst.frc.team3255.robot2015.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Telemetry() {
		super();
		
		init();
	}

	public Telemetry(String name) {
		super(name);
		
		init();
	}

	public void init() {
		
		SmartDashboard.putData("Cassette Command", CommandBase.cassette);
		SmartDashboard.putData("DriveTrain Command", CommandBase.drivetrain);
		
		// Comp
		SmartDashboard.putData("Drive Forward", new DriveForward());
		SmartDashboard.putData("Drive Reverse", new DriveReverse());
		SmartDashboard.putData("Drive Stop", new DriveStop());
		SmartDashboard.putData("Drive Gyro Reset", new DrivetrainResetGyro());
		SmartDashboard.putData("Reset Drivetrain Encoders", new DrivetrainResetEncoder());
		SmartDashboard.putData("Update Drivetrain Encoder Ratio", new DrivetrainUpdateEncoderRatio());
		SmartDashboard.putData("Reset Cassette Encoders", new CassetteResetEncoder());
		SmartDashboard.putData("Update Cassette Encoder Ratio", new CassetteUpdateEncoderRatio());
		
		SmartDashboard.putData("Rotate Left High", new RotateLeftHighSpeed());
		SmartDashboard.putData("Rotate Right High", new RotateRightHighSpeed());
		
		SmartDashboard.putData("Deploy Ejector", new CollectorDeployToteEjector());
		SmartDashboard.putData("Retract Ejector", new CollectorRetractToteEjector());
		
		SmartDashboard.putData("Release Trash", new RetractTrashCorrector());
		SmartDashboard.putData("Deploy Trash", new DeployTrashCorrector());
		SmartDashboard.putData("Cassette Lock", new CassetteLock());
		SmartDashboard.putData("Cassette Unlock", new CassetteUnlock());
		
		SmartDashboard.putData("Move to Step", new CassetteMoveToStepHigh());
		
		SmartDashboard.putData("Deploy Collector Wheels", new CollectorWheelsClose());
		SmartDashboard.putData("Retract Collector Wheels", new CollectorWheelsOpen());
		SmartDashboard.putData("Deploy Grabber", new TrashGrabberDeploy());
		SmartDashboard.putData("Retract Grabber", new TrashGrabberRetract());
		
		SmartDashboard.putData("Camera Rotate Left", new CameraLeft());
		SmartDashboard.putData("Camera Rotate Right", new CameraRight());
		SmartDashboard.putData("Camera Rotate Up", new CameraUp());
		SmartDashboard.putData("Camera Rotate Down", new CameraDown());

		LiveWindow.addSensor("DriveTrain", "Gyro", CommandBase.drivetrain.gyro);

		LiveWindow.addActuator("Cassette", "Motor 1", CommandBase.cassette.leftLiftTalon);
		LiveWindow.addActuator("Cassette", "Motor 2", CommandBase.cassette.rightLiftTalon);
	}

	public void smallUpdate() {
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getSpeed());
		SmartDashboard.putNumber("Strafe Speed", CommandBase.drivetrain.getStrafeSpeed());
		SmartDashboard.putNumber("Drive Forward Distance", CommandBase.drivetrain.getForwardDistance());
		SmartDashboard.putNumber("Drive Reverse Distance", CommandBase.drivetrain.getReverseDistance());		
		
		SmartDashboard.putNumber("Cassette Raise Speed", RobotPreferences.cassetteRaiseSpeed());

		SmartDashboard.putBoolean("Tote Detected", CommandBase.cassette.isToteDetected());
		
		// Modes
		SmartDashboard.putBoolean("Home Mode", CommandBase.cassette.isHome());
		SmartDashboard.putBoolean("Trash Pickup Mode", CommandBase.cassette.isTrashPickup());
		SmartDashboard.putBoolean("High Speed Enabled", CommandBase.drivetrain.arcadeFullSpeedEnabled());
	}
	
	public void update() {
		
		// Modes
		SmartDashboard.putBoolean("Home Mode", CommandBase.cassette.isHome());
		SmartDashboard.putBoolean("Trash Pickup Mode", CommandBase.cassette.isTrashPickup());
		SmartDashboard.putBoolean("High Speed Enabled", CommandBase.drivetrain.arcadeFullSpeedEnabled());
		
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getSpeed());
		SmartDashboard.putNumber("Strafe Speed", CommandBase.drivetrain.getStrafeSpeed());
		SmartDashboard.putNumber("Drive Gyro", CommandBase.drivetrain.getGyro());
		SmartDashboard.putNumber("Drive Forward Count", CommandBase.drivetrain.getForwardCount());
		SmartDashboard.putNumber("Drive Forward Distance", CommandBase.drivetrain.getForwardDistance());
		SmartDashboard.putNumber("Drive Reverse Count", CommandBase.drivetrain.getReverseCount());
		SmartDashboard.putNumber("Drive Reverse Distance", CommandBase.drivetrain.getReverseDistance());		
		
		SmartDashboard.putNumber("Cassette Talon 1 Speed", CommandBase.cassette.leftLiftTalon.get());
		SmartDashboard.putNumber("Cassette Raise Speed", RobotPreferences.cassetteRaiseSpeed());
		SmartDashboard.putNumber("Cassette Lift Count", CommandBase.cassette.getLiftCount());
		SmartDashboard.putNumber("Cassette Lift Distance", CommandBase.cassette.getLiftDistance());

		SmartDashboard.putBoolean("Top Position", CommandBase.cassette.isTopSwitchClosed());
		SmartDashboard.putBoolean("Trash Hold Position", CommandBase.cassette.isTrashHoldSwitchClosed());
		SmartDashboard.putBoolean("Tote Hold Position", CommandBase.cassette.isToteHoldSwitchClosed());
		SmartDashboard.putBoolean("Step Position", CommandBase.cassette.isStepSwitchClosed());
		SmartDashboard.putBoolean("Tote Pickup Position", CommandBase.cassette.isTotePickupSwitchClosed());
		SmartDashboard.putBoolean("Bottom Position", CommandBase.cassette.isBottomSwitchClosed());
		SmartDashboard.putBoolean("Tote Detected", CommandBase.cassette.isToteDetected());
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TelemetryUpdate());
    }
}

