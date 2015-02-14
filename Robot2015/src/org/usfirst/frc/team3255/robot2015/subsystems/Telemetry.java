package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.OI;
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
		SmartDashboard.putData("Drive Forward", new DriveForward());
		SmartDashboard.putData("Drive Reverse", new DriveReverse());
		SmartDashboard.putData("Drive Stop", new DriveStop());
		SmartDashboard.putData("Drive Gyro Reset", new DriveTrainResetGyro());
		
		SmartDashboard.putData("Rotate Left", new DrivetrainRotateRight());
		
		SmartDashboard.putData("Deploy Ejector", new CollectorDeployToteEjector());
		SmartDashboard.putData("Retract Ejector", new CollectorRetractToteEjector());
		
		SmartDashboard.putData("Release Trash", new RetractTrashCorrector());
		SmartDashboard.putData("Deploy Trash", new DeployTrashCorrector());
		
		LiveWindow.addSensor("DriveTrain", "Gyro", CommandBase.drivetrain.gyro);

		LiveWindow.addActuator("Cassette", "Motor 1", CommandBase.cassette.leftLiftTalon);
		LiveWindow.addActuator("Cassette", "Motor 2", CommandBase.cassette.rightLiftTalon);
	}
	
	public void update() {
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getSpeed());
		SmartDashboard.putNumber("Strafe Speed", CommandBase.drivetrain.getStrafeSpeed());
		SmartDashboard.putNumber("Drive Gyro", CommandBase.drivetrain.getGyro());
		SmartDashboard.putNumber("Drive Forward Distance", CommandBase.drivetrain.getForwardDistance());
		SmartDashboard.putNumber("Drive Reverse Distance", CommandBase.drivetrain.getReverseDistance());
		
		SmartDashboard.putNumber("Joysticks POV", OI.driverStick.getPOV());
		
		SmartDashboard.putNumber("Cassette Talon 1 Speed", CommandBase.cassette.leftLiftTalon.get());
		SmartDashboard.putNumber("Cassette Raise Speed", RobotPreferences.cassetteRaiseSpeed());

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

