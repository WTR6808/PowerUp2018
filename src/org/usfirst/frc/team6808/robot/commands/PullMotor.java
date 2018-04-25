package org.usfirst.frc.team6808.robot.commands;

import org.usfirst.frc.team6808.robot.Robot;
import org.usfirst.frc.team6808.robot.subsystems.DriveTrain_Subsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PullMotor extends Command {
	
	public int  motorSpeed;

    public PullMotor(int speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.motorPull);       
        motorSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveTrain.testMotor(motorSpeed);
    	Robot.motorPull.pullMotorSpeed(motorSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.motorPull.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.motorPull.Stop();
    }
}
