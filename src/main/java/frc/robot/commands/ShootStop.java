/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootStop extends CommandBase {
  private final Shooter shooter;
  /**
   * Creates a new Shoot.
   */
  public ShootStop(Shooter subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = subsystem;
    addRequirements(shooter);
    // pidF1.enable();
    // pidF2.enable();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.shoot(0, 0);
    // System.out.println("aaaaaahhh43234234");
    // shooter.shoot(joystick.getRawAxis(2), joystick.getRawAxis(2));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
