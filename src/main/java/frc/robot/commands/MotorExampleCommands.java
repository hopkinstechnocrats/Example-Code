package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.MotorExamples; //Imports the MotorExamples subystem
import frc.robot.Constants; // Imports the constants

public class MotorExampleCommands {

    public static Command SpinMotorPercentSpeed(MotorExamples motor){
            return Commands.run(() -> {
                motor.SpinMotorPercentSpeed(Constants.SubsystemConstants.kMotorSpeed);
            }, motor);
        }
}
