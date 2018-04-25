package org.usfirst.frc.team6808.robot.autonomous;

import org.usfirst.frc.team6808.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Auto extends Command {

	public double speed;
	public boolean doneTraveling;
	public double time;
	
	
    public Drive_Auto(double doubSpeed, double d) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    	speed = doubSpeed;
    	time = d;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("first");
    	Robot.driveTrain.AutoDrive(-(100/speed), 0);
    	
    	Timer.delay(time);
    	
    	Robot.driveTrain.AutoDrive(0, 0);
    	System.out.println("Success");
    	
    	doneTraveling = true;
    	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return doneTraveling;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.AutoDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
