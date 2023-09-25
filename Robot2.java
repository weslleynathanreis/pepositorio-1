// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

   private WPI_TalonSRX leftMaster = new WPI_TalonSRX(3);
   private WPI_TalonSRX rightMaster = new WPI_TalonSRX(1);
   private WPI_victorSPX leftSlave = new WPI_VictorSPX(1);
   private WPI_VictorSPX rightSlave = new WPI_VictorSPX(2);

   private WPI_TalonSRX armMotor= new WPI_TalonSRX(5);
   private WPI_VictorSPX armSlave = new WPI_VictorSPX(3);
   
   private WPI_TalonSRX rollerMotor = new WPI_TalonSRX(4);

   private Compressor compressor = new compressor();
   private DoubleSolenoid hatcchIntake = new DoubleSolenoid(0, 1); // PCM port 0, 1
   // joysticks
   private Joystick driveJoystick = new Joystick(0);
   private Joystick opertorJoystick = new Joystick(1);

   // unit conversion 
   private final double kdriveTick2feet = 1.0 / 4096 * 6 * Math.PI / 12;
   private final double kArmTick2deg = 360.0 / 512 *26 / 42 * 18 / 60 * 18 / 84;
  
  @Override
  public void robotInit() {
    // ierted settings
    leftMaster.setInverted(true);
    rightMaster.setInverted(true);
    armMotor.setInverted(false);

    // slave setups
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
    armSlave.follow(armMotor);

    leftSlave.setInverted(InvertType.FollowMaster);
    rightSlave.setInverted(InvertType.FollowMasdter);
    armSlave.setInverted(InvertType.FollowMaster);

    // init encords
    leftMaster.configSelectedFeedbackSensor(feedbackdevice.CTRE_MagEncoder_relative, 0, 10);
    rightMaster.configSelectedFeedbackSensor(feedbackdevice.CTRE_MagEncoder_relative, 0, 10);
    armMotor.configSelectedFeedbackSensor(feedbackdevice.quadencoder, 0, 10);

    leftMaster.setSensorPhase(false);
    rightMaster.setrSensorPhase(true);
    armMotor.setSensorPhase(true);

    // reset encoders to zero 
    leftMaster.configSelectedFeedbackSensorposition(0, 0, 10);
    rightMaster.configSelectedFeedbackSensorposition(0, 0, 10);
    armMotor.configSelectedFeedbackSensorposition(0, 0, 10);

  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNUmber("Arm Encoder Value", armMotor.getSelectedSensorposition() * kArmTick2deg);
    SmartDashboard.putNUmber("Left Drive Encoder Value", leftMaster.getSelectedSensorposition() * kdriveTick2feet);
    SmartDashboard.putNUmber("RIght Drive Encoder Value", rightMaster.getSelectedSensorposition() * kdriveTick2feet);
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
