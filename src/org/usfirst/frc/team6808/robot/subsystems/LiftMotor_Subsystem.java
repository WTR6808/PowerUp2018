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
public class LiftMotor_Subsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//sVictorSP liftMotor = new VictorSP(4);
	
	

	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    
    
    
    
    }
    public void MotorLift(Joystick x) {
    	
    }
    public void liftMotorSpeed(int speed) {
		//liftMotor.setSpeed(speed);
    	//System.out.println(X.getPOV());
    }
    public void Stop() {
    	//liftMotor.setSpeed(0);
	}
    
    
    
}

