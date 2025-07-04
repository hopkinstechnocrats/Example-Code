package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class SequentialCommandsExamples extends SequentialCommandGroup{ //You will have to extend this for it to work.

/*
    Often this file would replace the 'second file' in the chain of files mentioned in RunCommands and CommandSubsystem.

    These, like parallels, can be done in various different ways with differing levels of complexity.
    There are even more ways for sequentials than there are for parallels. There are three that would generally work.
    However, two are generally better and will be the focus of this file.

    Same as parallels, you can technically get away with not having a different file at all, and incorporating .andThen() into RobotContainer.
    Here's a brief example of how to do that:

        operatorController.a().onTrue(new ElevatorSetpoint(elevator, 0.5, 0.5).andThen(new EndEffectorSetpoint(elevator, 0.1, 0.3)));

    All this would do is do an elevator command and after that, an end effector command.
    NOTE: Parenthesis order is incredibly important here. If you put the .andThen outside of the specified parenthesis, it will break.
    It will break due to being outside of the order (and then end up either not going at all or just starting before/after the command was supposed to).

    The other generally recommended variant is to do so with the same format as the 'second file'.
    Here is an example, with the first one being normal format and the second one being a sequential:

        public static Command extendClimber(Climber climbSubsystem){
            return Commands.run(() -> {
                climbSubsystem.extend();
            }, climbSubsystem);
        }

        public static Command brake(Climber climbSubsystem){
            return Commands.run(() -> {
                climbSubsystem.brake();
                climbSubsystem.brakeVictor();
            }, climbSubsystem);
        }

    This is the climber example again as these were actually used.
    It's fairly easy to do sequentials in this format as you can just add another command to run.
    Adding another command will just default to sequential automatically.
    However: the commands need a proper end function or the next sequential will just never trigger.
    In this example, calling the brake command would sequentially call the break function, then the brakeVictor function.

    There is a more recommended way of doing sequential command groups, however.
    It functions generally the same, but is more well-documented and easily readable.
    It still can work similar to the other:

        public Command driveLeft(SwerveSubsystem swerveSubsystem) {
            return new SequentialCommandGroup(
                drive(swerveSubsystem, -1,0 ).withTimeout(1.5),
                drive(swerveSubsystem, 0, 0).withTimeout(.5),
                drive(swerveSubsystem, 0, .1).withTimeout(.5),
                drive(swerveSubsystem, 0, 1).withTimeout(2),
                drive(swerveSubsystem, 0, 0).withTimeout(.5),
                drive(swerveSubsystem, .1, 0).withTimeout(.5),
                drive(swerveSubsystem, 1, 0).withTimeout(4)
            );
        }

    The main difference here is that instead of a sequence of commands, it is a sequential command group.
    Other than functionality, this change also lets it be written easier because commands can just be put with commas in between.
    Again, like the other, make sure the commands have a good finish function - else they will fail to run.
 */

}