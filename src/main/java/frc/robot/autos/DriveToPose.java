package frc.robot.autos;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DriveToPose extends Command{
    
/*
    This is an expanded file for the DriveToPose command found in AutoSetup.
    It will go in the same location as the other commands in AutoSetup.
    This is a simple example of the command used in our auto:
*/
        public Command drive(Subsystem subsystem, double vx, double vy){
            return new RunCommand(
                () -> {
                    subsystem.drive(new Translation2d(vx,vy), 0, false);
                }, subsystem);
        }
/*
    It starts of similar to any command - it also uses the RunCommand feature mentioned in RunCommands.
    There is a helpful feature we can use - we can insert coordinates on the field (vx and vy).
    The swerve subsystem in this case already had a drive command that took those two coordinates and drove to that position.
    In this case, the 0 and the false would be _ respectively.

    In case there is not a drive command in the swerve subsystem, this file will also cover that.
    This is an example of the drive function in SwerveSubsystem:
*/
        public void drive(Translation2d translation, double rotation, boolean fieldRelative) {
            swerveDrive.drive(translation,
                rotation,
                fieldRelative,
                false);
        }
/*    
    In this case, we can use this function and pass in coordinates using the auto file.
    The difference with this and regular commands is that we have no button binding, so the values are just put in the auto file itself.
 */
}
