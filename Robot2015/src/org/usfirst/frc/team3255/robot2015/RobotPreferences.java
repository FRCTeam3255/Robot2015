package org.usfirst.frc.team3255.robot2015;

import org.usfirst.frc.team3255.robot2015.subsystems.Cassette;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {
	
	public static String cameraName() {
        return Preferences.getInstance().getString("CameraName", "cam0");
	}
	
	public static double cassetteRaiseSpeed() {
		return Preferences.getInstance().getDouble("CassetteLiftSpeed", Cassette.LIFT_SPEED);
	}
	
	public static double cassetteLowerSpeed() {
		return -Preferences.getInstance().getDouble("CassetteLowerSpeed", Cassette.LIFT_SPEED);
	}
	
	public static double driveSensitivity() {
		return Preferences.getInstance().getDouble("DriveSensitivity", 0.7);
	}
	
	public static double driveStrafeSensitivity() {
		return Preferences.getInstance().getDouble("DriveStrafeSensitivity", 1.0);
	}
	
	public static double unloadDistance() {
		return Preferences.getInstance().getDouble("UnloadDistance", 2.5);
	}
	
	// Autonomous Preferences
	public static double autoDriveSpeed() {
		return Preferences.getInstance().getDouble("AutoDriveSpeed", 1.0);
	}
	
	public static double autoDriveDistance() {
		return Preferences.getInstance().getDouble("AutoDriveDistance", 10.0);
	}
	
	public static double autoStrafeSpeed() {
		return Preferences.getInstance().getDouble("AutoStrafeSpeed", 1.0);
	}
	
	public static double autoStrafeTime() {
		return Preferences.getInstance().getDouble("AutoStrafeTime", 5.0);
	}

	public static double autoToteDistance() {
		return Preferences.getInstance().getDouble("AutoToteDistance", 5.0);
	}

}
