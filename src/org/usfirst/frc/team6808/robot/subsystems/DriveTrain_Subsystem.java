package org.usfirst.frc.team6808.robot.subsystems;

import org.usfirst.frc.team6808.robot.RobotMap;
import org.usfirst.frc.team6808.robot.commands.TankDrive_Command;
import org.usfirst.frc.team6808.robot.OI;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain_Subsystem extends Subsystem{

	Spark m_frontLeft = new Spark(1);
	   Spark m_midLeft = new Spark(2);
	   Spark m_rearLeft = new Spark(3);
	   SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_midLeft, m_rearLeft);

	   Spark m_frontRight = new Spark(4);
	   Spark m_midRight = new Spark(5);
	   Spark m_rearRight = new Spark(6);
	   SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_midRight, m_rearRight);

	   DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive_Command());
		
	}
	
	public void TeleopDrive(Joystick Left, Joystick Right) {
		m_drive.tankDrive(-(Left.getY()+1)/2, -(Right.getY()+1)/2);
	}
	
	public void Stop() {
		m_drive.tankDrive(0, 0);
	}
	
	
	
}
