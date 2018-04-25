package org.usfirst.frc.team6808.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team6808.robot.Robot;
import org.usfirst.frc.team6808.robot.subsystems.DriveTrain_Subsystem;
/**
 *
 */
public class PullMotor_Subsystem2 extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	VictorSP pullMotor = new VictorSP(7);
	
	

	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    
    
    
    
    }
    public void MotorLift(Joystick x) {
    	
    }
    public void pullMotorSpeed(int speed) {
		pullMotor.setSpeed(speed*.3);
    	//System.out.println(X.getPOV());
    }
    public void Stop() {
    	pullMotor.setSpeed(0);
	}
    
    
    
}

