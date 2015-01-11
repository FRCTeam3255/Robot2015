package org.usfirst.frc.team3255.robot2015.subsystems;

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
		// TODO Auto-generated constructor stub
		init();
	}

	public Telemetry(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		init();
	}

	public void init() {
		SmartDashboard.putData("Drive Forward", new DriveForward());
		SmartDashboard.putData("Drive Reverse", new DriveReverse());
		SmartDashboard.putData("Drive Stop", new DriveStop());
		SmartDashboard.putData("Claw Open", new ClawOpen());
		SmartDashboard.putData("Claw Close", new ClawClose());
		SmartDashboard.putData("Claw Disable", new ClawDisable());
		SmartDashboard.putData("Claw Gyro Reset", new ClawResetGyro());
		
		LiveWindow.addSensor("Claw", "POT", CommandBase.claw.pot);
		LiveWindow.addSensor("Claw", "Solenoid", CommandBase.claw.solenoid);
		LiveWindow.addSensor("Claw", "Limit Switch", CommandBase.claw.limitswitch);
		LiveWindow.addSensor("Claw", "Gyro", CommandBase.claw.gyro);
	}
	
	public void update() {
		SmartDashboard.putNumber("Accel X", CommandBase.drivetrain.getAccelX());
		SmartDashboard.putNumber("Accel Y", CommandBase.drivetrain.getAccelY());
		SmartDashboard.putNumber("Accel Z", CommandBase.drivetrain.getAccelZ());
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getSpeed());
		
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TelemetryUpdate());
    }
}

