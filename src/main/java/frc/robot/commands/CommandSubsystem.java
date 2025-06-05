package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CommandSubsystem extends SubsystemBase{ //You'll need the 'extends SubsystemBase', for reasons similar to the RunCommands file
    
/*
    As mentioned in RunCommands, there are two files for organizing the commands (not counting RobotContainer)
    This one is the one where things actually happen - where you actually set the values for what you want to change.
    It is structured similar to the RunCommands file, though generally simpler.
    However, to actually move the robot, often you also have to define motors here.

    Example file structure that was used in 2025 (albeit shortened):

        public class Climber extends SubsystemBase{
            TalonFX climbMotor;
            VictorSP victorsp = new VictorSP(2);

            public Climber(){
                climbMotor = new TalonFX(14);
                climbMotor.setNeutralMode(NeutralModeValue.Brake);
            }

            public void extend(){
                climbMotor.set(-0.4);
            }
        }

    This shows a very small subsystem that would be used.
    It starts with the general sybsystem start (define motors or variables)
    The main part to look at for this section is the last one - the 'extend' function.
    In the RunCommands file, we also used the extract funtion; that leads here to this one.
    All this does is take the info supplied by the other file and use it to run this function.
    In this case, there were no dependencies and the function simply moves the climber motor.

    You can have as many of those functions as possible (like the RunCommands file).
 */

}
