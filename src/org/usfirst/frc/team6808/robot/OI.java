/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6808.robot;

import org.usfirst.frc.team6808.robot.commands.LiftMotor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick driverLeft = new Joystick(0);
	Joystick driverRight = new Joystick(1);
	
	Joystick driverController = new Joystick(2);
	Joystick driverX = new Joystick(3);
	
	//Buttons
	Button xboxA_Driver			  = new JoystickButton(driverX, 1);
	Button xboxB_Driver			  = new JoystickButton(driverX, 2);
	Button xboxX_Driver			  = new JoystickButton(driverX, 3);
	Button xboxY_Driver			  = new JoystickButton(driverX, 4);
	Button xboxLeftBumper_Driver  = new JoystickButton(driverX, 5);
	Button xboxRightBumper_Driver = new JoystickButton(driverX, 6);
	Button xboxBack_Driver		  = new JoystickButton(driverX, 7);
	Button xboxStart_Driver		  = new JoystickButton(driverX, 8);
	Button xboxL3_Driver		  = new JoystickButton(driverX, 9);
	Button xboxR3_Driver		  = new JoystickButton(driverX, 10);
	
	Button xboxA_Operator			= new JoystickButton(driverLeft, 1);
	Button xboxB_Operator			= new JoystickButton(driverLeft, 2);
	Button xboxX_Operator			= new JoystickButton(driverLeft, 3);
	Button xboxY_Operator			= new JoystickButton(driverLeft, 4);
	Button xboxLeftBumper_Operator  = new JoystickButton(driverLeft, 5);
	Button xboxRightBumper_Operator = new JoystickButton(driverLeft, 6);
	Button xboxBack_Operator		= new JoystickButton(driverLeft, 7);
	Button xboxStart_Operator		= new JoystickButton(driverLeft, 8);
	Button xboxL3_Operator		  	= new JoystickButton(driverLeft, 9);
	Button xboxR3_Operator		  	= new JoystickButton(driverLeft, 10);
	
	public OI() {
		
		xboxX_Driver.whenPressed(new LiftMotor(1));
		
	}
	
	public Joystick getJoystickLeft() {
		return driverLeft;
	}
	
	public Joystick getJoystickRight() {
		return driverRight;
	}

	public Joystick getJoystickC() {
		return driverController;
	}
	public Joystick getJoystickX() {
		return driverX;
	}
}
