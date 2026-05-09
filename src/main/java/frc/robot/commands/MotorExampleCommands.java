package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.MotorExamples; //Imports the MotorExamples subystem
import frc.robot.Constants; // Imports the constants

public class MotorExampleCommands extends Command {

    public static Command SpinMotorPercentSpeed(MotorExamples motor){
            return Commands.run(() -> {
                motor.SpinMotorPercentSpeed(Constants.SubsystemConstants.kMotorSpeed);
            }, motor);
        }

        public static Command SpinCIM(MotorExamples motor){
            return Commands.run(() -> {
                motor.SpinCIM(Constants.SubsystemConstants.kMotorSpeed);
            }, motor);
        }

        public static Command Brake(MotorExamples motor){
            return Commands.run(() -> {
                motor.Brake();
            }, motor);
        }
}
