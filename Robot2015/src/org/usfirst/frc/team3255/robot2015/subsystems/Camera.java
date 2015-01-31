package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Servo servo = null;
			
    public Camera() {
		super();
		// TODO Auto-generated constructor stub
		servo = new Servo(RobotMap.CAMERA_SERVO);
		
	}

    public void setAngle(double angle) {
    	servo.setAngle(angle);
    }

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

