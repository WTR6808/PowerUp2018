/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6808.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6808.robot.autonomous.*;
import org.usfirst.frc.team6808.robot.subsystems.ArmLeft_Subsystem;
import org.usfirst.frc.team6808.robot.subsystems.Intake_Subsystem;
import org.usfirst.frc.team6808.robot.subsystems.DriveTrain_Subsystem;
import org.usfirst.frc.team6808.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team6808.robot.subsystems.IntakePivot;
import org.usfirst.frc.team6808.robot.subsystems.LiftMotor_Subsystem;
import org.usfirst.frc.team6808.robot.subsystems.PullMotor_Subsystem2;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static final ExampleSubsystem kExampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain_Subsystem driveTrain= new DriveTrain_Subsystem();
	//public static final LiftMotor_Subsystem motorLift= new LiftMotor_Subsystem();
	public static final PullMotor_Subsystem2 motorPull = new PullMotor_Subsystem2();
	public static final Intake_Subsystem intake = new Intake_Subsystem();          
	public static final IntakePivot intakePivot = new IntakePivot(); 
	public static OI m_oi; 
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>(); 
	//SendableChooser<String> m_start = new SendableChooser<>(); 
	
	//public String startingPlace;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Default Do Nothing", new DoNothing());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//CameraServer.getInstance().startAutomaticCapture();
		double speed = SmartDashboard.getNumber("AutoDrive Speed", 70);
		/*
		String gameData;
		
		m_start.addDefault("Center", "Center");
		m_start.addObject("Right", "Right");
		m_start.addObject("Left", "Left");
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(m_start.getSelected() == "Center") {
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'R') {
					SmartDashboard.putString("Auto State", "R");
					Cube_Middle_Right_Auto auto_left = new Cube_Middle_Right_Auto(-65,(0.60));
					auto_left.start();
				}else{
					SmartDashboard.putString("Default Do Nothing", "L");
					Drive_Auto auto_nothing = new Drive_Auto(-65,(0.60));
					auto_nothing.start();
				}
				
			}
		}else if(m_start.getSelected() == "Left") {
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'L') {
					SmartDashboard.putString("Auto State", "L");
					Cube_Left_Auto auto_left = new Cube_Left_Auto(-65,(0.60));
					auto_left.start();
				}else{
					SmartDashboard.putString("Auto Drive", "R");
					Drive_Auto auto_left = new Drive_Auto(-65,(0.60));
					auto_left.start();
				}
		}else if(m_start.getSelected() == "Right") {
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'R') {
					SmartDashboard.putString("Auto State", "R");
					Cube_Right_Auto auto_right = new Cube_Right_Auto(-65,(0.60));
					auto_right.start();
				}else{
					SmartDashboard.putString("Auto Drive", "L");
					Drive_Auto auto_left = new Drive_Auto(-65,(0.60));
					auto_left.start();
				}
			}
		}*/
		
		
		m_chooser.addObject("Default Drive 65 3/5 sec", new Drive_Auto (65, (.60)));
		m_chooser.addObject("Default Drive 65 1 sec", new Drive_Auto(65, 1));
		m_chooser.addObject("Default Drive Back 65 3/5 sec", new Drive_Auto (-65, (.60)));
		m_chooser.addObject("Default Drive Back 65 1 sec", new Drive_Auto(-65, 1));
		/*m_chooser.addObject("Default Drive 70 1 sec", new Drive_Auto(70, 1));
		m_chooser.addObject("Default Drive 80 1 sec", new Drive_Auto(80, 1));
		m_chooser.addObject("Default Drive 90 1 sec", new Drive_Auto(90, 1));
		m_chooser.addObject("Default Drive 100 1 sec", new Drive_Auto(100, 1));
		m_chooser.addObject("Default Drive 65 2 sec", new Drive_Auto(65, 2));
		m_chooser.addObject("Default Drive 70 2 sec", new Drive_Auto(70, 2));
		m_chooser.addObject("Default Drive 80 2 sec", new Drive_Auto(80, 2));
		m_chooser.addObject("Default Drive 90 2 sec", new Drive_Auto(90, 2));
		m_chooser.addObject("Default Drive 100 2 sec", new Drive_Auto(100, 2));*/
		
		
		
		
		
		
		SmartDashboard.putData("Auto mode", m_chooser);
		}
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		/*m_chooser.addDefault("Default Do Nothing", new DoNothing());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//CameraServer.getInstance().startAutomaticCapture();
		double speed = SmartDashboard.getNumber("AutoDrive Speed", 70);
		
		String gameData;
		
		m_start.addDefault("Center", "Center");
		m_start.addObject("Right", "Right");
		m_start.addObject("Left", "Left");
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(m_start.getSelected() == "Center") {
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'R') {
					SmartDashboard.putString("Auto State", "R");
					Cube_Middle_Right_Auto auto_left = new Cube_Middle_Right_Auto(-65,(0.60));
					auto_left.start();
				}else{
					SmartDashboard.putString("Default Do Nothing", "L");
					Drive_Auto auto_nothing = new Drive_Auto(-65,(0.60));
					auto_nothing.start();
				}
				
			}
		}else if(m_start.getSelected() == "Left") {
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'L') {
					SmartDashboard.putString("Auto State", "L");
					Cube_Left_Auto auto_left = new Cube_Left_Auto(-65,(0.60));
					auto_left.start();
				}else{
					SmartDashboard.putString("Auto Drive", "R");
					Drive_Auto auto_left = new Drive_Auto(-65,(0.60));
					auto_left.start();
				}
		}else if(m_start.getSelected() == "Right") {
			if(gameData.length() > 0)
			{
				if(gameData.charAt(0) == 'R') {
					SmartDashboard.putString("Auto State", "R");
					Cube_Right_Auto auto_right = new Cube_Right_Auto(-65,(0.60));
					auto_right.start();
				}else{
					SmartDashboard.putString("Auto Drive", "L");
					Drive_Auto auto_left = new Drive_Auto(-65,(0.60));
					auto_left.start();
				}
			}
		}
		}*/
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) m_autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) m_autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
