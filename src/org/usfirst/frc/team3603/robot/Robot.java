
package org.usfirst.frc.team3603.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Joystick driveStick = new Joystick(0);
	Joystick otherstick = new Joystick(2);
	RobotDrive mainDrive = new RobotDrive(0,1,2,3);
	int autoLoopCounter;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	/**Joystick driveStick = new Joystick(0);
    	Joystick otherstick = new Joystick(2);
    	RobotDrive mainDrive = new RobotDrive(0,1,2,3);
    	*/
    	
    	

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	if(autoLoopCounter < 100) {
    		mainDrive.mecanumDrive_Polar(1.0, 1.0, 90);
    		autoLoopCounter++;
    	} else {
    		mainDrive.mecanumDrive_Polar(0, 0, 0);
    	}

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	mainDrive.mecanumDrive_Cartesian(driveStick.getAxis(Joystick.AxisType.kX), driveStick.getAxis(Joystick.AxisType.kY), otherstick.getAxis(Joystick.AxisType.kY), 0);
    	//mainDrive.mecanumDrive_Cartesian(driveStick.getX(), driveStick.getY(), otherstick.getZ(), 0);
    	
    	if(otherstick.getRawButton(4)) {
    		mainDrive.mecanumDrive_Polar( 0, 0, -90);
    	}
    	if(otherstick.getRawButton(5)) {
    		mainDrive.mecanumDrive_Polar( 0, 0, 90);
    	}
    	if(otherstick.getRawButton(6)) {
    		mainDrive.mecanumDrive_Polar( 0, .5, 0);
    	}
    	if(otherstick.getRawButton(11)) {
    		mainDrive.mecanumDrive_Polar( 0, .5, 0);
    	}
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
