package org.usfirst.frc.team3255.robot2015;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	public static String cameraName() {
        return Preferences.getInstance().getString("CameraName", "cam0");
	}
	
	public static double cassetteRaiseSpeed() {
		// always set the speed in the preferences window to a positive value
		return Preferences.getInstance().getDouble("CassetteLiftSpeed", 0.5);
	}
	
	public static double cassetteLowerSpeed() {
		// always set the speed in the preferences window to a positive value
		return Preferences.getInstance().getDouble("CassetteLowerSpeed", 0.3);
	}
	
	public static double driveSensitivity() {
		return Preferences.getInstance().getDouble("DriveSensitivity", 0.7);
	}
	
	public static double driveStrafeSensitivity() {
		return Preferences.getInstance().getDouble("DriveStrafeSensitivity", 1.0);
	}
	
	public static double unloadSpeed() {
		return Preferences.getInstance().getDouble("UnloadSpeed", 0.3);
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

	public static double rotationSpeed() {
		return Preferences.getInstance().getDouble("RobotRotationSpeed", 0.5);
	}

}
