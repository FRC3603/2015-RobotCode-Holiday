
package org.usfirst.frc.team3603.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.RobotDrive.MotorType;
//import edu.wpi.first.wpilibj.communication.UsageReporting;
//import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
//import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Victor frontLeft = new Victor(0);
	Victor frontRight = new Victor(2);
	Victor rearLeft = new Victor(1);
	Victor rearRight = new Victor(3);
	Joystick driveStick = new Joystick(0);
	//Joystick otherstick = new Joystick(2);
	RobotDrive mainDrive = new RobotDrive(frontLeft,frontRight,rearLeft,rearRight);
	int autoLoopCounter = 0;
	
	//final int frontLeftChannel	= 2;
	//final int rearLeftChannel	= 3;
	//final int frontRightChannel	= 1;
	//final int rearRightChannel	= 0;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	/**Joystick driveStick = new Joystick(0);
    	Joystick otherstick = new Joystick(2);
    	RobotDrive mainDrive = new RobotDrive(0,1,2,3);
    	*/
    	mainDrive.setInvertedMotor(MotorType.kFrontLeft, true);	
    	mainDrive.setInvertedMotor(MotorType.kRearLeft, true);
    	

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	if(autoLoopCounter < 500) {
    		mainDrive.mecanumDrive_Polar(0, 0, .25);
    		autoLoopCounter++;
    	} else if(autoLoopCounter < 1000) {
    		mainDrive.mecanumDrive_Polar(0, .25, 0);   //not working currently
    		autoLoopCounter++; 
    	} else if(autoLoopCounter < 1500) {
    		mainDrive.mecanumDrive_Polar(.25, 0, 0);
    		autoLoopCounter++;
    	}

    	
    
    				
    	
    

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//getWatchdog().setEnabled(true);
    	while (isOperatorControl() && isEnabled()){
    	mainDrive.mecanumDrive_Cartesian(driveStick.getRawAxis(1), driveStick.getRawAxis(0), driveStick.getRawAxis(5), 0);
    	//mainDrive.mecanumDrive_Cartesian(driveStick.getX(), driveStick.getY(), otherstick.getZ(), 0);
    	/** public void mecanumDrive_Cartesian(double x, double y, double rotation, double gyroAngle) {
        if(!kMecanumCartesian_Reported) {
            UsageReporting.report(tResourceType.kResourceType_RobotDrive, getNumMotors(), tInstances.kRobotDrive_MecanumCartesian);
            kMecanumCartesian_Reported = true;
        }
        double xIn = x;
        double yIn = y;
        // Negate y for the joystick.
        yIn = -yIn;
        // Compensate for gyro angle.
        double rotated[] = rotateVector(xIn, yIn, gyroAngle);
        xIn = rotated[0];
        yIn = rotated[1];

        double wheelSpeeds[] = new double[kMaxNumberOfMotors];
        wheelSpeeds[MotorType.kFrontLeft_val] = xIn + yIn + rotation;
        wheelSpeeds[MotorType.kFrontRight_val] = -xIn + yIn - rotation;
        wheelSpeeds[MotorType.kRearLeft_val] = -xIn + yIn + rotation;
        wheelSpeeds[MotorType.kRearRight_val] = xIn + yIn - rotation;

        normalize(wheelSpeeds);
        m_frontLeftMotor.set(wheelSpeeds[MotorType.kFrontLeft_val] * m_invertedMotors[MotorType.kFrontLeft_val] * m_maxOutput, m_syncGroup);
        m_frontRightMotor.set(wheelSpeeds[MotorType.kFrontRight_val] * m_invertedMotors[MotorType.kFrontRight_val] * m_maxOutput, m_syncGroup);
        m_rearLeftMotor.set(wheelSpeeds[MotorType.kRearLeft_val] * m_invertedMotors[MotorType.kRearLeft_val] * m_maxOutput, m_syncGroup);
        m_rearRightMotor.set(wheelSpeeds[MotorType.kRearRight_val] * m_invertedMotors[MotorType.kRearRight_val] * m_maxOutput, m_syncGroup);

        if (m_syncGroup != 0) {
            CANJaguar.updateSyncGroup(m_syncGroup);
        }

        if (m_safetyHelper != null) m_safetyHelper.feed();
    }*/
    	if(otherstick.getRawButton(4)) {
    		mainDrive.mecanumDrive_Polar( 0, 0, -.25);
    	}
    	if(otherstick.getRawButton(5)) {
    		mainDrive.mecanumDrive_Polar( 0, 0, .25);
    	}
    	if(otherstick.getRawButton(6)) {
    		mainDrive.mecanumDrive_Polar( 0, .25, 0);
    	}
    	if(otherstick.getRawButton(11)) {
    		mainDrive.mecanumDrive_Polar( 0, -.25, 0);
    	}
    	if(otherstick.getRawButton(1)) {
    		mainDrive.mecanumDrive_Polar( .25, 0, 0);
    	}
    	if(driveStick.getRawButton(1)) {
    		mainDrive.mecanumDrive_Polar( -.25, 0, 0);
    	}
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
