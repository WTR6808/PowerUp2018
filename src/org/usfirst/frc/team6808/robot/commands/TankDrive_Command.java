package org.usfirst.frc.team6808.robot.commands;

import org.usfirst.frc.team6808.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive_Command extends Command {

    public TankDrive_Command() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.TeleopDrive(Robot.m_oi.getJoystickLeft(), Robot.m_oi.getJoystickRight());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
