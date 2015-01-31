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
	
	public static final int CASSETTE_LEFT_LIFT_TALON = 4;
	public static final int CASSETTE_RIGHT_LIFT_TALON = 5;
	
	public static final int COLLECTOR_LEFT_TALON = 6;
	public static final int COLLECTOR_RIGHT_TALON = 7;

	public static final int CAMERA_VERTICAL_SERVO = 8;
	public static final int CAMERA_HORIZONTAL_SERVO = 9;
	
	// CAN Talons
	public static final int DRIVETRAIN_STRAFE_LEFT_CAN_TALON = 0;
	public static final int DRIVETRAIN_STRAFE_RIGHT_CAN_TALON = 1;
	
	//Analog Inputs
	public static final int CLAW_POT = 0;
	public static final int DRIVETRAIN_GYRO = 1;
	
	// Module 0 Solenoids
	public static final int CLAW_OPEN_SOLENOID = 2;
	public static final int CLAW_CLOSE_SOLENOID = 3;
	public static final int CASSETTE_DEPLOY_LIFT_SOLENOID = 4;
	public static final int CASSTTE_RETRACT_LIFT_SOLENOID = 5;
	public static final int CASSETTE_DEPLOY_TRASH_SOLENOID = 6;
	public static final int CASSETTE_RETRACT_TRASH_SOLENOID = 7;
	public static final int CASSTTE_DEPLOY_LOCK_SOLENOID = 0;
	public static final int CASSTTE_RETRACT_LOCK_SOLENOID = 1;

	// Module 1 Solenoids
	public static final int DRIVETRAIN_STRAFE_DEPLOY_SOLENOID = 0;
	public static final int DRIVETRAIN_STRAFE_RETRACT_SOLENOID = 1;
	
	//Digital Inputs
	public static final int CLAW_LIMITSWITCH_1 = 0;
	public static final int CLAW_LIMITSWITCH_2 = 1;
	public static final int CASSETTE_ENCODER_CHANNEL_A = 2;
	public static final int CASSETTE_ENCODER_CHANNEL_B = 3;
	public static final int DRIVETRAIN_ENCODER_LEFT_CHANNEL_A = 4;
	public static final int DRIVETRAIN_ENCODER_LEFT_CHANNEL_B = 5;
	public static final int DRIVETRAIN_ENCODER_RIGHT_CHANNEL_A = 6;
	public static final int DRIVETRAIN_ENCODER_RIGHT_CHANNEL_B = 7;
	public static final int CASSETTE_TOTE_PICKUP_MAGSWITCH = 8;
	public static final int CASSETTE_TOTE_HOLD_MAGSWITCH = 9;
	public static final int CASSETTE_TRASH_PICKUP_MAGSWITCH = 10;
	public static final int CASSETTE_TRASH_HOLD_MAGSWITCH = 11;
	public static final int CASSETTE_TOP_MAGSWITCH = 12;
}
