package org.usfirst.frc.team3255.robot2015.commands;

import org.usfirst.frc.team3255.robot2015.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDelay extends CommandGroup {

    public AutoDelay() {
    	addSequential(new DoDelay(RobotPreferences.autoDelay()));
    }
}
