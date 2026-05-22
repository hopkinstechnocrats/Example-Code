package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.MotorExamples; //Imports the MotorExamples subystem
import frc.robot.Constants; // Imports the constants for use in control loops

public class MotorExampleCommands extends Command {
/*
    these are commands! we use them to run methods from the subsystems on our robot.
    In the paramaters of the command, you put a variable for the command with the type being the subsystem you're calling from. 
    This variable name doesn't matter as long as its consistent among the appearences in the command.
    We set it to return a command, then set the command to we want it to do.
    The () -> {} sets a function within the command, with the parameters in the (), and the function itself in the {}.
    In this case, the function within the command runs the method through the variable with the subsystem type.
    Then, outside of the curly brackets, it specifies which subsystem to pull from in the function in the command.
    Now, we have a command that we can run in RobotContainer!
*/
        public static Command SpinMotorPercentSpeed(MotorExamples speed){
            return Commands.run(() -> {
                speed.SpinMotorPercentSpeed(Constants.SubsystemConstants.kMotorSpeed);
            }, speed);
        }
            /*because we're using "speed" as a variable in the method, we can call a different speed into the method in a different command
             This lets us have a reverse command without creating an entirely new method for it.*/
        public static Command ReverseSpinMotorPercentSpeed(MotorExamples speed){
            return Commands.run(() -> {
                speed.SpinMotorPercentSpeed(-Constants.SubsystemConstants.kMotorSpeed);
            }, speed);
        }

        public static Command SpinCIM(MotorExamples motor){
            return Commands.run(() -> {
                motor.SpinCIM();
            }, motor);
        }

        public static Command Brake(MotorExamples stop){
            return Commands.run(() -> {
                stop.Brake();
            }, stop);
        }
}
