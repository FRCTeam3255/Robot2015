package org.usfirst.frc.team3255.robot2015.subsystems;

import org.usfirst.frc.team3255.robot2015.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Cassette extends PIDSubsystem {

	//Motor Controllers
	Talon motor1 = null;
	Talon motor2 = null;
	
	//Encoder
	public Encoder encoder = null;
	
    // Initialize your subsystem here
    public Cassette() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(0.0, 0.0, 0.0);
    	
    	motor1 = new Talon(RobotMap.CASSETTE_TALON1);
		motor2 = new Talon(RobotMap.CASSETTE_TALON2);
		encoder = new Encoder(RobotMap.CASSETTE_ENCODER_CHANNEL_A, RobotMap.CASSETTE_ENCODER_CHANNEL_B, false, Encoder.EncodingType.k4X);
		encoder.setDistancePerPulse(0.01);
		
		PIDController controller = this.getPIDController();
		controller.setPID(0.01, 0.0, 0.0);
		controller.setSetpoint(0.0);
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return encoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	// scale motor output to not exceed more than 50% motor power
    	if(output > 1.0) {
    		output = 1.0;
    	}
    	else if (output < -1.0) {
    		output = -1.0;
    	}
    	output = output * 0.15;
    	motor1.set(output);
    	motor2.set(output);
    }
}
