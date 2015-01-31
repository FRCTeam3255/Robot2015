package org.usfirst.frc.team3255.robot2015;

import org.usfirst.frc.team3255.robot2015.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	// Joysticks
	public static Joystick driverStick = new Joystick(RobotMap.JOYSTICK_DRIVER);
	public static Joystick manipulatorStick = new Joystick(RobotMap.JOYSTICK_MANIPLUATOR);
	
	Button D5 = new JoystickButton(driverStick, 5);
	Button D6 = new JoystickButton(driverStick, 6);
	Button D9 = new JoystickButton(driverStick, 9);
	Button D10 = new JoystickButton(driverStick, 10);
	
	Button M1 = new JoystickButton(manipulatorStick, 1);
	Button M2 = new JoystickButton(manipulatorStick, 2);
	Button M3 = new JoystickButton(manipulatorStick, 3);
	
	public OI()	{
		D5.whenPressed(new DriveStrafeDisable()); 
		D6.whenPressed(new DriveStrafeEnable()); 
		D9.whenPressed(new CameraReverse());
		D10.whenPressed(new CameraForward());
		
		
		M1.whenPressed(new CassetteUnload());
		M2.whenPressed(new CassetteUnloadBackup());
		M3.whenPressed(new CassettePickupTote());
	}
	
	
}

