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
  //this defines the controller that we use as an input, creating it, and assinging it an ID found in constants.
  CommandXboxController operatorController = new CommandXboxController(Constants.SubsystemConstants.kOperatorControllerPort);
  final MotorExamples motorExamples = new MotorExamples();//Creates the MotorExamples subsystem in this file

  //the robotContainer initializer is where everything actually runs on the robot, so if we want things to update, we need to put them in the initializer
  public RobotContainer() {
    //this is the subsystems default command, It runs the Brake command that stops all the motors for this subsystems when there is no other command being ran.
    motorExamples.setDefaultCommand(MotorExampleCommands.Brake(motorExamples));
    
    //this allows the robot to actually take inputs when we press buttons that are defined in the configureBindings function.
    configureBindings();
  }

  private void configureBindings() {
    operatorController.a().whileTrue(MotorExampleCommands.SpinMotorPercentSpeed(motorExamples));
    operatorController.b().whileTrue(MotorExampleCommands.ReverseSpinMotorPercentSpeed(motorExamples));
    operatorController.x().whileTrue(MotorExampleCommands.SpinCIM(motorExamples));
    //runs the command from the commands file using the method from the subsystem that we defined earlier when a button is pressed.
  }
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
