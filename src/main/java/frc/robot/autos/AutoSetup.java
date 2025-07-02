package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class AutoSetup extends SequentialCommandGroup{
/*
    This class will mostly explain how to setup the file that contains the auto commands.
    This is actually very similar to any of the standard command files.
    Unlike those files, however, you will generally not need to extend anything.

    The auto commands can just go directly into this location of the file.
    Many auto commands will be sequentials, like the following:
*/
        public Command forwardAuto(Subsystem subsystem) {
            return new SequentialCommandGroup(
                drive(subsystem, -1 ,0).withTimeout(1.5)
            );
        }
/*    
    This has a different layout to the typical one - it just uses withTimeout.
    withTimeout is just a delay - it is still sequential as it happens after the drive command.
    Others have the traditional appearance of the file mentioned in SequentialCommands:
*/
        public Command pushLeftAuto(Subsystem subsystem) {
            return new SequentialCommandGroup(
                drive(subsystem, -1,0 ).withTimeout(1.5),
                drive(subsystem, 0, 0).withTimeout(.5),
                drive(subsystem, 0, 1).withTimeout(.5),
                drive(subsystem, 0, 1).withTimeout(2),
                drive(subsystem, 0, 0).withTimeout(.5),
                drive(subsystem, 1, 0).withTimeout(.5),
                drive(subsystem, 1, 0).withTimeout(4)
            );
        }
/* 
    This one is easier to read, and just goes to many different set points on the field.
    There are also withTimeouts after every command, so it will move, then delay, then move again, etc.
    The DriveToPose function will get its own file, but the command to do it goes here in this class, same as others.
 */

    private Command drive(Subsystem subsystem, int i, int j) {
        throw new UnsupportedOperationException(); // This is just to make the file work without the other code
    }

}
