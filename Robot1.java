// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.lang.model.util.ElementScanner14;
import javax.management.loading.PrivateClassLoader;
import javax.swing.text.AbstractDocument.LeafElement;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

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

private Spark leftmotor1 = new Spark(0);
private Spark leftmotor2 = new Spark(1);
private Spark rightmotor1 = new Spark(2);
private Spark rightmotor2 = new Spark(3);

private Joystick joy1 = new Joystick(0);

private double startTime;
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    starTime = Timer.getFPGATimestamp()
  }
  @Override
  public void autonomousPeriodic() {}
    double time = Timer.getFPGATimestamp();

    if (time - starTime < 3)
      leftMotor1.set(0.6);
      leaftMotor2.set(0.6);
      rightMotor1.set(-0.6);
      rightMotor2.set(-0.6);
      Else {
      leftMotor1.set(0);
      leaftMotor2.set(0);
      rightMotor1.set(0);
      rightMotor2.set(0);
  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}
    double speed= -joy1.getRawAxis(1)* 0.6;
    double turn = joy1.getRawAxis(4)* 0.3;

    double left = speed + turn; 
    double right = speed -turn; 

  leftMotor1.set(left);
  leaftMotor2.set(left);
  rightMotor1.set(-right);
  rightMotor2.set(-right);

  @Override
    public int hashCode() {
      
    }

    @Override
    public boolean equals(Object obj) {
    }

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

  public Spark getLeftmotor1() {
    return leftmotor1;
  }

  public void setLeftmotor1(Spark leftmotor1) {
    this.leftmotor1 = leftmotor1;
  }

  public Spark getLeftmotor2() {
    return leftmotor2;
  }

  public void setLeftmotor2(Spark leftmotor2) {
    this.leftmotor2 = leftmotor2;
  }

  public Spark getRightmotor1() {
    return rightmotor1;
  }

  public void setRightmotor1(Spark rightmotor1) {
    this.rightmotor1 = rightmotor1;
  }

  public Spark getRightmotor2() {
    return rightmotor2;
  }

  public void setRightmotor2(Spark rightmotor2) {
    this.rightmotor2 = rightmotor2;
  }

  public Joystick getJoy1() {
    return joy1;
  }

  public void setJoy1(Joystick joy1) {
    this.joy1 = joy1;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }
}
