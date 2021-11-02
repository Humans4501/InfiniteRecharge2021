/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimelightAim;

public class Aim extends CommandBase {

  DriveTrain driveTrain;
  LimelightAim limeLightAim;
  /**
   * Creates a new Aim.
   */
  public Aim(DriveTrain drivetrain, LimelightAim limelightAim) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = drivetrain;
    limeLightAim = limelightAim;
    addRequirements(drivetrain, limelightAim);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    limeLightAim.setSetpoint(0);
    limeLightAim.enable();
    Robot.setLimelightLed(3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // limeLightAim.setSetpoint(-RobotContainer.ahrs.getYaw());
    if(Robot.getLimelightV() == 1){
      driveTrain.drive2(0,limeLightAim.currOutput);
    }
    // System.out.println("I am running");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.drive2(0,0);
    limeLightAim.disable();
    Robot.setLimelightLed(1);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
