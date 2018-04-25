package org.usfirst.frc.team6808.robot.commands;

import org.usfirst.frc.team6808.robot.Robot;
import org.usfirst.frc.team6808.robot.subsystems.DriveTrain_Subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake_Command extends Command {
	
	public int  motorSpeed;

    public Intake_Command() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intake);       
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveTrain.testMotor(motorSpeed);
    	Joystick joystickX = Robot.m_oi.getopX();
    	//Joystick joystickX = Robot.m_oi.getopX();
    	if(joystickX.getRawAxis(2) > 0.2 ) {
    		Robot.intake.Intake(joystickX.getRawAxis(2)*.8);
    	}else if(joystickX.getRawAxis(3) > 0.2) {
    		Robot.intake.Intake(-joystickX.getRawAxis(3)*.8);
    		
    	}else {
    		Robot.intake.Intake(0);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.Stop();
    }
    
}
