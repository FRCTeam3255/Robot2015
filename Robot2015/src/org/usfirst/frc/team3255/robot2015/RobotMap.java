package org.usfirst.frc.team3255.robot2015;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_MANIPLUATOR = 0;
	
	// Axes
	public static final int AXIS_TANK_LEFT = 1;
	public static final int AXIS_TANK_RIGHT = 5;
	public static final int AXIS_ARCADE_MOVE = 1;
	public static final int AXIS_ARCADE_ROTATE = 4;
	
	// PWMs
	public static final int DRIVETRAIN_FRONT_LEFT_TALON = 2;
	public static final int DRIVETRAIN_BACK_LEFT_TALON = 1;
	public static final int DRIVETRAIN_FRONT_RIGHT_TALON = 3;
	public static final int DRIVETRAIN_BACK_RIGHT_TALON = 0;
	
	public static final int CASSETTE_TALON1 = 4;
	public static final int CASSETTE_TALON2 = 5;
	
	//Analog Inputs
	public static final int CLAW_POT = 0;
	public static final int DRIVETRAIN_GYRO = 1;
	
	//Solenoids
	public static final int CLAW_SOLENOID_OPEN = 0;
	public static final int CLAW_SOLENOID_CLOSE = 1;
	
	//Digital Inputs
	public static final int CLAW_LIMITSWITCH_1 = 0;
	public static final int CASSETTE_ENCODER_CHANNEL_A = 1;
	public static final int CASSETTE_ENCODER_CHANNEL_B = 2;
	
	//Zack
	public static final int DRIVETRAIN_CENTER_LEFT = 6;
	public static final int DRIVETRAIN_CENTER_RIGHT = 7;
	public static final int DRIVETRAIN_SOLENOID_OPEN = 2;
	public static final int DRIVETRAIN_SOLENOID_CLOSE = 3;
	public static final int DRIVETRAIN_ENCODER_LEFT_CHANNEL_A = 3;
	public static final int DRIVETRAIN_ENCODER_LEFT_CHANNEL_B = 4;
	public static final int DRIVETRAIN_ENCODER_RIGHT_CHANNEL_A = 5;
	public static final int DRIVETRAIN_ENCODER_RIGHT_CHANNEL_B = 6;
	public static final int CASSETTE_SOLENOID_TOTE_OPEN = 4;
	public static final int CASSETTE_SOLENOID_TOTE_CLOSE = 5;
	public static final int CASSETTE_SOLENOID_TRASH_OPEN = 6;
	public static final int CASSETTE_SOLENOID_TRASH_CLOSE = 7;
	public static final int CLAW_LIMITSWITCH_2 = 8;
	
}
