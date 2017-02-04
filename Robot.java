//we were working on adding a button that calls AutoDrive when pressed, but the when pressed function calls all the time and we cant implement the OI in the init statement
package org.usfirst.frc.team6418.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.AnalogInput;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	RobotDrive myRobot = new RobotDrive(0, 1);
	Joystick stick = new Joystick(0);
	Timer timer = new Timer();
	Button buttonA = new JoystickButton(stick, 1);
	AnalogInput ai,ai2;

	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	//	oi = new OI(stick, buttonA, myRobot);
	//	i.buttonPress();
	//	buttonA.whenPressed(func("hello"));
		System.out.println("Initializing Robot...");
		ai = new AnalogInput(0);
		ai2 = new AnalogInput(1);
		
	}

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	@Override
	public void autonomousInit() {
		System.out.println("Initializing Autonomous");
		timer.reset();
		timer.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (timer.get() < 2.0) {
			myRobot.drive(-0.5, 0.0); // drive forwards half speed
		} else {
			myRobot.drive(0.0, 0.0); // stop robot
		}
	}

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 * @param Button 
	 */
	//@Override
	public void teleopInit() {
		//buttonA = new JoystickButton(stick, 1);
	//	myRobot.setInvertedMotor(MotorType.kRearLeft, true);
		//myRobot.setInvertedMotor(MotorType.kFrontLeft, true);
		System.out.println("Initiating Teleop Mode");
		//int bits;
		//ai.setOversampleBits(10);
		//ai.setAverageBits(2);
		//ai2.setOversampleBits(10);
		//ai2.setAverageBits(2);
		//bits = ai.getAverageBits();
		//System.out.println(bits);
		//test = new AutoDrive();

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		myRobot.arcadeDrive(stick.getY(),-stick.getX());
		double volts = ai.getVoltage();
		System.out.println(volts);
		/*if (buttonA.get()){
			System.out.println("button is being pressed");
			if(!test.isRunning())
			{
				System.out.println("Running Autodrive");
				test.start();
			}
			
			
		}
		
		*/
	}



	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public void disabledInit(){
		System.out.println("Disabled Init");
	}
	
	public void disabledPeriodic(){
		//System.out.println("Disabled Periodic");
	}
	public void robotPeriodic(){
	//	System.out.println("Robot Periodic");
	}
	public void testInit(){
		System.out.println("Test Init...");
	}
	/*
	private Command func(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		return new AutoDrive();
	}*/
	
	
	
	
	public void testSensor() {
		
		
		
		
	}
	
	
	
	
	
}

