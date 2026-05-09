// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.MotorExamples;
import frc.robot.commands.MotorExampleCommands;

public class RobotContainer {

  CommandXboxController operatorController = new CommandXboxController(Constants.SubsystemConstants.kOperatorControllerPort);
  final MotorExamples motorExamples = new MotorExamples();//Creates the MotorExamples subsystem

  public RobotContainer() {

    motorExamples.setDefaultCommand(MotorExampleCommands.Brake(motorExamples));
    configureBindings();
  }

  private void configureBindings() {
    operatorController.a().whileTrue(MotorExampleCommands.SpinMotorPercentSpeed(motorExamples));
    operatorController.b().whileTrue(MotorExampleCommands.SpinCIM(motorExamples));
    //runs the command from the commands file using the method from the subsystem file when a button is pressed
  }
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
