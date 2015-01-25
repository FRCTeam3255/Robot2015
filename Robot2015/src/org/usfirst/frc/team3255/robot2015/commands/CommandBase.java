package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.OI;
import org.usfirst.frc.team3255.robot2015.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class CommandBase extends Command {
	
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Cassette cassette = new Cassette();
	public static final Claw claw = new Claw();
    public static final Telemetry telemetry = new Telemetry();
	public static OI oi;
	
    public CommandBase() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

	public static void init() {
		// TODO Auto-generated method stub
		oi = new OI();	
	}
}
