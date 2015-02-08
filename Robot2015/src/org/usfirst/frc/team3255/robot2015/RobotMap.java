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
	public static final int JOYSTICK_MANIPLUATOR = 1;
	
	// Axes
	public static final int AXIS_TANK_LEFT = 1;
	public static final int AXIS_TANK_RIGHT = 5;
	public static final int AXIS_ARCADE_MOVE = 1;
	public static final int AXIS_ARCADE_ROTATE = 2;
	public static final int AXIS_HDRIVE = 0;
	
	public static final int AXIS_COLLECTOR_SPEED = 1;
	public static final int AXIS_COLLECTOR_PAN = 0;
	
	// PWMs
	public static final int DRIVETRAIN_FRONT_LEFT_TALON = 0;
	public static final int DRIVETRAIN_BACK_LEFT_TALON = 1;
	public static final int DRIVETRAIN_FRONT_RIGHT_TALON = 2;
	public static final int DRIVETRAIN_BACK_RIGHT_TALON = 3;

	public static final int DRIVETRAIN_STRAFE_LEFT_TALON = 4;
	public static final int DRIVETRAIN_STRAFE_RIGHT_TALON = 5;
	
	public static final int CASSETTE_LEFT_LIFT_TALON = 6;
	public static final int CASSETTE_RIGHT_LIFT_TALON = 7;
	
	public static final int COLLECTOR_LEFT_TALON = 8;
	public static final int COLLECTOR_RIGHT_TALON = 9;
	
	//Analog Inputs
	public static final int DRIVETRAIN_GYRO = 0;
	
	// Subsystem PCM Modules
	public static final int DRIVETRAIN_PCM = 0;
	public static final int CASSETTE_PCM = 0;
	public static final int COLLECTOR_PCM = 1;
	
	// Module 0 Solenoids
	public static final int DRIVETRAIN_STRAFE_DEPLOY_SOLENOID = 0;
	public static final int DRIVETRAIN_STRAFE_RETRACT_SOLENOID = 1;
	
	public static final int CASSETTE_PADDLE_DEPLOY_SOLENOID = 2;
	public static final int CASSTTE_PADDLE_RETRACT_SOLENOID = 3;
	public static final int CASSTTE_LOCK_DEPLOY_SOLENOID = 4;
	public static final int CASSTTE_LOCK_RETRACT_SOLENOID = 5;
	public static final int CASSETTE_TRASH_DEPLOY_SOLENOID = 6;

	// Module 1 Solenoids
	public static final int COLLECTOR_EJECTOR_DEPLOY_SOLENOID = 0;
	public static final int COLLECTOR_EJECTOR_RETRACT_SOLENOID = 1;
	
	//Digital Inputs
	public static final int DRIVETRAIN_ENCODER_LEFT_CHANNEL_A = 0;
	public static final int DRIVETRAIN_ENCODER_LEFT_CHANNEL_B = 1;
	public static final int DRIVETRAIN_ENCODER_RIGHT_CHANNEL_A = 2;
	public static final int DRIVETRAIN_ENCODER_RIGHT_CHANNEL_B = 3;
	
	public static final int CASSETTE_TOP_MAGSWITCH = 9;
	public static final int CASSETTE_TRASH_HOLD_MAGSWITCH = 8;
	public static final int CASSETTE_TOTE_HOLD_MAGSWITCH = 7;
	public static final int CASSETTE_STEP_MAGSWITCH = 6;
	public static final int CASSETTE_TOTE_PICKUP_MAGSWITCH = 5;
	public static final int CASSETTE_BOTTOM_MAGSWITCH = 4;
	
	public static final int CASSTTE_TOTE_DETECT_LIMITSWITCH = 10;
}
