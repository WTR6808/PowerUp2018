package org.usfirst.frc.team6808.robot.subsystems;

import org.usfirst.frc.team6808.robot.RobotMap;
import org.usfirst.frc.team6808.robot.commands.ArcadeDrive_Command;
import org.usfirst.frc.team6808.robot.commands.TankDrive_Command;
import org.usfirst.frc.team6808.robot.OI;
import org.usfirst.frc.team6808.robot.Robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain_Subsystem extends Subsystem{

	Spark m_frontLeft = new Spark(0);
	   Spark m_rearLeft = new Spark(1);
	   SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	   Spark m_frontRight = new Spark(2);
	   Spark m_rearRight = new Spark(3);
	   SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

	   DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive_Command());
		m_drive.setSafetyEnabled(false);
	}
	
	public void TeleopTankDrive(Joystick Left, Joystick Right) {
		m_drive.tankDrive((Left.getY()/1.15), Right.getY()/1.15);
		//m_drive.arcadeDrive(Left.getY(),-(Left.getZ()));
		//m_drive.tankDrive(Left.getY(), Right.getY());
	}
	//public void TeleopDriveController(Joystick Left) {
		//m_drive.tankDrive(Left.getY(), Left.getRawAxis(3));
	//}
	public void TeleopArcadeDrive(Joystick x) {
		m_drive.arcadeDrive(x.getRawAxis(1)/1.15, x.getRawAxis(0)/1.15);
	}
	public void AutoDrive(double speed1, double speed2) {
		m_drive.arcadeDrive(speed1, speed2);
		
	}
	
	public void Stop() {
		m_drive.tankDrive(0,0);
		m_drive.arcadeDrive(0, 0);
	}
	
	
	
}
