package org.usfirst.frc.team3255.robot2015;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	public static String cameraName() {
        return Preferences.getInstance().getString("CameraName", "cam0");
		// return "cam1";
	}
	
	public static double cassetteRaiseSpeed() {
		double minLiftSpeed = Preferences.getInstance().getDouble("CassetteMinLiftSpeed", 0.4);
		double maxLiftSpeed = Preferences.getInstance().getDouble("CassetteMaxLiftSpeed", 0.4);
		double stickValue = OI.manipulatorStick.getRawAxis(RobotMap.AXIS_CASSETTE_SPEED_FACTOR);
		
		// stickValue is +1 at minimum and -1 at max.
		// Need to convert to 0 at minimum and +1 at max
		stickValue = (stickValue + 1) / 2.0;
		
		// when stickValue = 0 we want maxLiftSpeed, and 1 = minLiftSpeed
		double speed = maxLiftSpeed + (stickValue * (minLiftSpeed - maxLiftSpeed));

		return speed;
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
	
	// TODO Too be determined
	public static double autoStrafeTime() {
		return Preferences.getInstance().getDouble("AutoStrafeTime", 5.0);
	}

	public static double autoToteDistance() {
		return Preferences.getInstance().getDouble("AutoToteDistance", 6.75);
	}
	
	public static double autoStartDistance() {
		return Preferences.getInstance().getDouble("AutoStartDistance", 2.0);
	}

	public static double gyroRotationSpeed() {
		return Preferences.getInstance().getDouble("RotationSpeed", 0.5);
	}

	public static double gyroRotateLeftAngle() {
		return Preferences.getInstance().getDouble("RotateLeftAngle", 90.0);
	}
	
	public static double gyroRotateRightAngle() {
		return Preferences.getInstance().getDouble("RotateRightAngle", 90.0);
	}
	
	public static double gyroRotate180Angle() {
		return Preferences.getInstance().getDouble("Rotate180Angle", 180.0);
	}

	public static double auto3ToteDealy() {
		return Preferences.getInstance().getDouble("Auto3ToteDealy", 1.0);
	}
	
	public static double getPulsesPer5Feet() {
		return Preferences.getInstance().getDouble("PulsesPer5Feet", 50.0);
	}

	public static double toteStepDelay() {
		return Preferences.getInstance().getDouble("ToteStepDelay", 0.5);
	}

	public static double deployCorrectorDelay() {
		return Preferences.getInstance().getDouble("DeployCorrectorDelay", 0.5);
	}
}
