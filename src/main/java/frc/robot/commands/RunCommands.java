package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class RunCommands extends Command{ // You will have to add 'extends Command' here to make this have command capabilities

/*
    Commands start like any other function, but you do not define what the command does here.
    Here you will tell the commands how to run, and you can bind them to buttons in RobotContainer (found in ButtonBindings)

    You want this following line to be at the start of the file for it to not error:
        private RunCommands(){}
    Note that 'RunCommands' will change depending on file name. Do not call it RunCommands, that is a placeholder.
*/

/*
    Similar to defining a normal function, it has a type, name, and dependencies.
    The dependencies are for later when you actually have to tell the command what to do, but you pass them in here.
    In the curly brackets you put the actual function to be run, tpyically in a seperate file (the subsystem to be run in)
    After that, you put the subsystem to be run in. All three subsystems in the different parts of the command should be consistent.

    Example for the climber used in 2025:

        public static Command extendClimber(Climber climbSubsystem){
            return Commands.run(() -> {
                climbSubsystem.extend();
            }, climbSubsystem);
        }

        public static Command retractClimber(Climber climbSubsystem){
            return Commands.run(() -> {
                climbSubsystem.retract();
            }, climbSubsystem);
        }

    This entire process is basically three steps in three files:
    RobotContainer button press -> Command file and organization for a mechanism -> the subsystem in which things actually get done
    This is because: a) organization and b) button presses want commands and the third file is not a command, the second file is, hence the three-step process.
            
    }
 */
} 
