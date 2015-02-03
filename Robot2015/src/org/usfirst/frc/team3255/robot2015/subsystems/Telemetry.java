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
		SmartDashboard.putData("Drive Gyro Reset", new DriveTrainResetGyro());
		SmartDashboard.putData("Arcade Drive", new DriveArcade());
		SmartDashboard.putData("Tank Drive", new DriveTank());
		
		SmartDashboard.putData("Claw Open", new ClawOpen());
		SmartDashboard.putData("Claw Close", new ClawClose());
		SmartDashboard.putData("Claw Disable", new ClawDisable());
		
		SmartDashboard.putData("Cassette Enable", new CassetteEnable());
		SmartDashboard.putData("Cassette Disable", new CassetteDisable());
		SmartDashboard.putData("Cassette Encoder Reset", new CassetteResetEncoder());

		LiveWindow.addSensor("Claw", "POT", CommandBase.claw.pot);
		LiveWindow.addSensor("Claw", "Solenoid", CommandBase.claw.clawSolenoid);
		LiveWindow.addSensor("Claw", "Claw Top Switch", CommandBase.claw.clawTopSwitch);
		
		LiveWindow.addSensor("DriveTrain", "Gyro", CommandBase.drivetrain.gyro);
		
		LiveWindow.addSensor("Cassette", "Encoder", CommandBase.cassette.liftEncoder);
		LiveWindow.addActuator("Cassette", "Motor 1", CommandBase.cassette.leftLiftTalon);
		LiveWindow.addActuator("Cassette", "Motor 2", CommandBase.cassette.rightLiftTalon);
		LiveWindow.addActuator("Cassette", "PID Controller", CommandBase.cassette.getPIDController());
	}
	
	public void update() {
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getSpeed());
		SmartDashboard.putNumber("Drive Gyro", CommandBase.drivetrain.getGyro());
		SmartDashboard.putNumber("Drive Forward Distance", CommandBase.drivetrain.getForwardDistance());
		SmartDashboard.putNumber("Drive Reverse Distance", CommandBase.drivetrain.getReverseDistance());
		SmartDashboard.putNumber("Strafe Speed", CommandBase.drivetrain.getStrafeSpeed());
		SmartDashboard.putNumber("Last Strafe Speed", CommandBase.drivetrain.getCommandedStrafeSpeed());
		
		SmartDashboard.putNumber("Cassette PID Setpoint", CommandBase.cassette.getSetpoint());
		SmartDashboard.putNumber("Cassette PID Input", CommandBase.cassette.returnPIDInput());
		SmartDashboard.putNumber("Cassette Talon 1 Speed", CommandBase.cassette.leftLiftTalon.get());
		SmartDashboard.putBoolean("Cassette Encoder Stopped", CommandBase.cassette.liftEncoder.getStopped());
		SmartDashboard.putBoolean("Tote Pickup Position", CommandBase.cassette.isTotePickupSwitchClosed());
		SmartDashboard.putBoolean("Tote Hold Position", CommandBase.cassette.isToteHoldSwitchClosed());
		SmartDashboard.putBoolean("Trash Pickup Position", CommandBase.cassette.isTrashPickupSwitchClosed());
		SmartDashboard.putBoolean("Trash Hold Position", CommandBase.cassette.isTrashHoldSwitchClosed());
		SmartDashboard.putBoolean("Top Position", CommandBase.cassette.isTopSwitchClosed());
		
		if(SmartDashboard.getBoolean("Cassette Enabled", false) == true) {
			CommandBase.cassette.enable();
		}
		else {
			CommandBase.cassette.disable();
		}
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TelemetryUpdate());
    }
}

