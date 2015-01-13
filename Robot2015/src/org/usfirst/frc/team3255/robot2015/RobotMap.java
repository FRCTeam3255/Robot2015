package org.usfirst.frc.team3255.robot2015;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Controller Inputs
	public static final int JOYSTICK_LEFT = 0;
	public static final int JOYSTICK_RIGHT = 1;
	
	//Motor Controllers
	public static final int DRIVETRAIN_FRONT_LEFT_TALON = 0;
	public static final int DRIVETRAIN_BACK_LEFT_TALON = 1;
	public static final int DRIVETRAIN_FRONT_RIGHT_TALON = 2;
	public static final int DRIVETRAIN_BACK_RIGHT_TALON = 3;
	
	//Analog Inputs
	public static final int CLAW_POT = 0;
	public static final int CLAW_GYRO = 1;
	
	//Solenoids
	public static final int CLAW_SOLENOID_OPEN = 0;
	public static final int CLAW_SOLENOID_CLOSE = 1;
	
	//Digital Inputs
	public static final int CLAW_LIMITSWITCH = 0;
}
