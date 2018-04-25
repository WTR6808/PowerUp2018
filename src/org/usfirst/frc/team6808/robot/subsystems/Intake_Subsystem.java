package org.usfirst.frc.team6808.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team6808.robot.commands.Intake_Command;
import org.usfirst.frc.team6808.robot.Robot;
import org.usfirst.frc.team6808.robot.subsystems.DriveTrain_Subsystem;
/**
 *
 */
public class Intake_Subsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Spark armRight = new Spark(6);
	Spark armLeft = new Spark(5);
	
	
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Intake_Command());
    	
    
    
    
    
    }
    public void MotorLift(Joystick x) {
    	
    }
    public void Intake(double d) {
    	armRight.setSpeed(d);
    	armLeft.setSpeed(d);
    	//System.out.println(X.getPOV());
    }
    public void Stop() {
    	armRight.setSpeed(0);
    	armLeft.setSpeed(0);
	}
    
    
    
}

