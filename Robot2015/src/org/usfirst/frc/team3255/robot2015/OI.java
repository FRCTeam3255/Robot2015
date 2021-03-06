
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
	
	Button D1 = new JoystickButton(driverStick, 1);
	Button D2 = new JoystickButton(driverStick, 2);
	Button D3 = new JoystickButton(driverStick, 3);
	Button D4 = new JoystickButton(driverStick, 4);
	Button D5 = new JoystickButton(driverStick, 5);
	Button D6 = new JoystickButton(driverStick, 6);
	Button D7 = new JoystickButton(driverStick, 7);
	Button D8 = new JoystickButton(driverStick, 8);
	Button D9 = new JoystickButton(driverStick, 9);
	Button D10 = new JoystickButton(driverStick, 10);
	
	Button M1 = new JoystickButton(manipulatorStick, 1);
	Button M2 = new JoystickButton(manipulatorStick, 2);
	Button M3 = new JoystickButton(manipulatorStick, 3);
	Button M4 = new JoystickButton(manipulatorStick, 4);
	Button M5 = new JoystickButton(manipulatorStick, 5);
	Button M6 = new JoystickButton(manipulatorStick, 6);
	Button M7 = new JoystickButton(manipulatorStick, 7);
	Button M8 = new JoystickButton(manipulatorStick, 8);
	Button M9 = new JoystickButton(manipulatorStick, 9);
	Button M10 = new JoystickButton(manipulatorStick, 10);
	Button M11 = new JoystickButton(manipulatorStick, 11);
	Button M12 = new JoystickButton(manipulatorStick, 12);
	
	public OI()	{
		// driverStick
		D1.whenPressed(new RotateLeftLowSpeed());
		D2.whenPressed(new Rotate180());
		D3.whenPressed(new RotateRightLowSpeed());
		D4.whenPressed(new DriveStop());
		D5.whenPressed(new ArcadeFullSpeedDisabled());
		D6.whenPressed(new ArcadeFullSpeedEnabled());
		D7.whenPressed(new DriveStrafeDisable()); 
		D8.whenPressed(new DriveStrafeEnable());

		// manipulatorStick joystick
		M1.whenPressed(new PickupTote2ToFeeder());
		M2.whenPressed(new UnloadAndBackup());
		M3.whenPressed(new PickupBottomToHoldTote2());
		M4.whenPressed(new PickupBottomToFeeder());
		M5.whenPressed(new CassetteUnload());
		M6.whenPressed(new CassetteTransportStack());
		M7.whenPressed(new CassetteUnlock());
		M7.whileHeld(new CassetteManualDrive());
		M8.whenPressed(new CassetteLock());
		M9.whenPressed(new CollectorWheelsOpen());
		M10.whenPressed(new CollectorWheelsClose());
		M11.whenPressed(new CassetteMoveToKnockCan());
		M12.whenPressed(new CycleWheels());
	}
}

