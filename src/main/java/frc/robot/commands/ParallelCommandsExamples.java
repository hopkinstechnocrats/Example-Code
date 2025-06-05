package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ParallelCommandsExamples extends SequentialCommandGroup{ //Even for parallels, you generally need this (for the second method)

/*
    Often this file would replace the 'second file' in the chain of files mentioned in RunCommands and CommandSubsystem.

    These can be done in various different ways with differing levels of complexity.
    You can technically get away with not having a different file at all, and incorporating .alongWith() into RobotContainer.
    Here's a brief example of how to do that:

        operatorController.a().onTrue(new ElevatorSetpoint(elevator, 0.5, 0.5).alongWith(new EndEffectorSetpoint(elevator, 0.1, 0.3)));

    All this does is do both an elevator command and an end effector command at the same time.
    NOTE: Parenthesis order is incredibly important here. If you put the .alongWIth outside of the specified parenthesis, it will break.
    It will break due to being outside of the order (and then end up either not going at all or just starting before/after the command was supposed to).

    There are only really has two ways of doing parallels (sequentials have three). The other is recommended over the previous.
    Here is an example:

        addCommands(

            new ParallelCommandGroup(
                new ExampleCommand1(subsystem)
                new ExampleCommand3(subsystem)
                new ExampleCommand2(subsystem)
            )

        );

    The ExampleCommands and subsystem were both placeholders, but the other words are not.
    Change ExampleCommand to the actual command name (same with subsystem).
    You would put this code in curly brackets right after the constructor.

 */

}
