package frc.robot.controls;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;

// This class explains how to bind general buttons
// These are often put in RobotContainer, so this class is structured as such

public class ButtonBindings { // This would be called RobotContainer
    
    private void configureBindings()
  {

    if (RobotBase.isSimulation())
    {
        /*
        The class has many different parts that make the robot run in different ways
        Even though they're not all for button bindings (usually), they can be useful
        All of them are set up like the section these comments are in, with two parts
        The first parts we use are either RobotBase, Robot, or DriverStation
        The second parts are isSimulation or isTest
        */
    } else
    { 
        /*
        They can all also have elses to provide an alternate set of commands
        Example:
        controller.buttonX().onTrue(alternateSimulationCommand(value));
        */
    }

    /*
    The standard button bindings are placed outside of any of the other functions
    We often use povUp, rightTrigger, rightBumper, start, back, x
    (And all their respective alternate directions; leftBumper, y, povLeft)
    These are defined in TODO
    
    */

    // Reset commands
    operatorController.povDown().onTrue(EndEffectorCommands.changeSetpointCommand(endEffector, Constants.endEffectorConstants.Stowage));
    operatorController.a().onTrue(new ElevatorSetpoint(elevator, 0.5, elevatorConstants.motorPowerResetLimit));

    // Elevator up commands
    operatorController.b().onTrue(new ScoreSequential(elevator, endEffector, elevatorConstants.L2Height, false));
    operatorController.x().onTrue(new ScoreSequential(elevator, endEffector, elevatorConstants.L3Height, false));
    operatorController.y().onTrue(new ScoreSequential(elevator, endEffector, elevatorConstants.L4Height, true));

    // Elevator down commands
    operatorController.povRight().onTrue(new ResetSequential(elevator, endEffector, elevatorConstants.L2Height));
    operatorController.povLeft().onTrue(new ResetSequential(elevator, endEffector, elevatorConstants.L3Height));
    operatorController.povUp().onTrue(new ResetSequential(elevator, endEffector, elevatorConstants.L4Height));

    // End effector commands
}

}
