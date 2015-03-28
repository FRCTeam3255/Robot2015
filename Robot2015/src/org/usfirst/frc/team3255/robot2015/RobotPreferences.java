package org.usfirst.frc.team3255.robot2015;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {
	
	public static double cassetteRaiseSpeed() {
		double liftSpeed = Preferences.getInstance().getDouble("CassetteLiftSpeed", 1.0);
		/*double minLiftSpeed = Preferences.getInstance().getDouble("CassetteMinLiftSpeed", 0.4);
		double maxLiftSpeed = Preferences.getInstance().getDouble("CassetteMaxLiftSpeed", 0.5);
		double stickValue = OI.manipulatorStick.getRawAxis(RobotMap.AXIS_CASSETTE_SPEED_FACTOR);
		
		// stickValue is +1 at minimum and -1 at max.
		// Need to convert to 0 at minimum and +1 at max
		
		//stickValue = (stickValue + 1) / 2.0;
		
		// when stickValue = 0 we want maxLiftSpeed, and 1 = minLiftSpeed
		
		double speed = maxLiftSpeed + (stickValue * (minLiftSpeed - maxLiftSpeed));*/
		return liftSpeed;
	}
	
	public static double cassetteLowerSpeed() {
		// always set the speed in the preferences window to a positive value
		return Preferences.getInstance().getDouble("CassetteLowerSpeed", 0.5);
	}
	
	public static double driveSensitivity() {
		return Preferences.getInstance().getDouble("DriveSensitivity", 1.0);
	}
	
	public static double driveStrafeSensitivity() {
		return Preferences.getInstance().getDouble("DriveStrafeSensitivity", 1.0);
	}
	
	public static double unloadSpeed() {
		return Preferences.getInstance().getDouble("UnloadSpeed", 0.6);
	}
	
	public static double unloadDistance() {
		return Preferences.getInstance().getDouble("UnloadDistance", 2.5);
	}
	
	
	// Rotation
	public static double rotateLeftLowSpeed() {
		return Preferences.getInstance().getDouble("RotateLeftLowSpeed", 0.5);
	}
	
	public static double rotateLeftHighSpeed() {
		return Preferences.getInstance().getDouble("RotateLeftHighSpeed", 0.7);
	}

	public static double rotateLeftAngle() {
		return Preferences.getInstance().getDouble("RotateLeftAngle", 90.0);
	}
	
	public static double rotateRightLowSpeed() {
		return Preferences.getInstance().getDouble("RotateRightLowSpeed", 0.5);
	}
	
	public static double rotateRightHighSpeed() {
		return Preferences.getInstance().getDouble("RotateRightHighSpeed", 0.7);
	}
	
	public static double rotateRightAngle() {
		return Preferences.getInstance().getDouble("RotateRightAngle", 90.0);
	}
	
	public static double rotate180Angle() {
		return Preferences.getInstance().getDouble("Rotate180Angle", 180.0);
	}
	
	// Encoders
	public static double getPulsesPer5Feet() {
		return Preferences.getInstance().getDouble("PulsesPer5Feet", 1200.0);
	}

	public static double deployCorrectorDelay() {
		return Preferences.getInstance().getDouble("DeployCorrectorDelay", 0.1);
	}

	// Camera
	public static String cameraName() {
        return Preferences.getInstance().getString("CameraName", "cam2");
		// return "cam1";
	}
	
	public static double cameraRightAngle() {
		return Preferences.getInstance().getDouble("CameraRotateRightAngle", 90.0);
	}

	public static double cameraLeftAngle() {
		return Preferences.getInstance().getDouble("CameraRotateLeftAngle", -90.0);
	}

	public static double cameraUpAngle() {
		return Preferences.getInstance().getDouble("CameraRotateUpAngle", 90.0);
	}
	
	public static double cameraDownAngle() {
		return Preferences.getInstance().getDouble("CameraRotateDownAngle", -90.0);
	}

	// Autonomous Preferences
	public static double autoDelay() {
		return Preferences.getInstance().getDouble("AutoDelay", 0.0);
	}
	
	public static double autoFwdSpeed() {
		return Preferences.getInstance().getDouble("AutoFwdSpeed", 0.5);
	}

	public static double autoFwdDistance() {
		return Preferences.getInstance().getDouble("AutoFwdDistance", 6.5);
	}
	
		// 1 Tote
	public static double auto1ToteStartDistance() {
		return Preferences.getInstance().getDouble("Auto1ToteStartDistance", 2.0);
	}
	
	public static double auto1ToteStartSpeed() {
		return Preferences.getInstance().getDouble("Auto1ToteStartSpeed", 0.5);
	}
	
	public static double auto1ToteEndDistance() {
		return Preferences.getInstance().getDouble("Auto1ToteEndDistance", 9.5);
	}
	
	public static double auto1ToteEndSpeed() {
		return Preferences.getInstance().getDouble("Auto1ToteEndSpeed", 0.5);
	}
	
	public static double auto1ToteDelay() {
		return Preferences.getInstance().getDouble("Auto1ToteDelay", 2.0);
	}
	
	public static double auto1ToteSpinOutTime() {
		return Preferences.getInstance().getDouble("Auto1ToteSpinOutTime", 1.0);
	}
	
		// 3 Tote
	public static double auto3ToteStartDistance() {
		return Preferences.getInstance().getDouble("Auto3ToteStartDistance", 0.5);
	}
	
	public static double auto3ToteStartSpeed() {
		return Preferences.getInstance().getDouble("Auto3ToteStartSpeed", 0.5);
	}
	
	public static double auto3ToteEndDistance() {
		return Preferences.getInstance().getDouble("Auto3ToteEndDistance", 10.0);
	}
	
	public static double auto3ToteEndSpeed() {
		return Preferences.getInstance().getDouble("Auto3ToteEndSpeed", 0.6);
	}
	
	public static double auto3ToteDelay() {
		return Preferences.getInstance().getDouble("Auto3ToteDelay", 0.0);
	}
	
		// Trash
	public static double autoTrashDistance() {
		return Preferences.getInstance().getDouble("AutoTrashDistance", 0.5);
	}
	
	public static double autoTrashSpeed() {
		return Preferences.getInstance().getDouble("AutoTrashSpeed", 0.5);
	}
	
	public static double autoTrashDelay() {
		return Preferences.getInstance().getDouble("AutoTrashDelay", 0.5);
	}

	
	// Cassette Positions
	public static double getCassettePulsesPerFoot() {
		return Preferences.getInstance().getDouble("CassettePulsesPerFoot", 1200.0);
	}

	public static double cassetteStepPositionHigh() {
		return Preferences.getInstance().getDouble("CassetteStepPositionHigh", -13.0);
	}
	public static double cassetteStepPositionLow() {
		return Preferences.getInstance().getDouble("CassetteStepPositionLow", -2.0);
	}
	public static double cassetteToteHoldPosition() {
		return Preferences.getInstance().getDouble("CassetteToteHoldPosition", 22.0);
	}
	public static double cassetteTotePickupPosition() {
		return Preferences.getInstance().getDouble("CassetteTotePickupPosition", 0.0);
	}
	public static double cassetteTrashHoldPosition() {
		return Preferences.getInstance().getDouble("CassetteTrashHoldPosition", 0.0);
	}
	public static double cassetteFeederPickupPosition() {
		return Preferences.getInstance().getDouble("CassetteFeederPickupPosition", -23.0);
	}
	public static double cassetteFeederTopPosition() {
		return Preferences.getInstance().getDouble("CassetteFeederTopPosition", 18.0);
	}
	
	public static int waitForToteDelay() {
		return Preferences.getInstance().getInt("WaitForToteDelay", 3);
	}
	
	// Collector
	public static double collectorSpinOutSpeed() {
		return Preferences.getInstance().getDouble("CollectorSpinOutSpeed", 0.5);
	}
	public static double collectorSpinOutTime() {
		return Preferences.getInstance().getDouble("CollectorSpinOutTime", 1.0);
	}
	public static double collectorSpeed() {
		return Preferences.getInstance().getDouble("CollectorSpeed", 1.0);
	}
}
