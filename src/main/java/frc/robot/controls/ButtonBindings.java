package frc.robot.controls;

import edu.wpi.first.wpilibj.RobotBase;

// This class explains how to bind general buttons
// These are often put in RobotContainer, so this class is structured as such

public class ButtonBindings { // This would be called RobotContainer

    // You will need this line to actually bind the buttons
    //private void configureBindings()
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
        controller.button().onTrue(alternateSimulationCommand(requirement));
        */
    }

    /*
    The standard button bindings are placed outside of any of the other functions
    We often use povUp, rightTrigger, rightBumper, start, back, x
    (And all their respective alternate directions; leftBumper, y, povLeft)

        Example for formatting:
        controller.button().onTrue(MechanismCommands.specificCommand(requirement1, requirement2))

        Example that was actually used in 2025:
        operatorController.x().onTrue(EndEffectorCommands.changeSetpointCommand(endEffector, Constants.endEffectorConstants.Stowage));

    We wanted to move the end effector to its storage position, a defined constant -- we used these steps:

    We started by calling which controller we wanted to trigger the command (in this case, operator)
    Then we said the button to use (In this case, the X button)
    onTrue is most often used, schedules on initial button press -- this is what we used
    whileTrue can also be helpful and calls as long as the button is pressed.
    toggleOnTrue, the third option, will call, and then continue until the button is pressed a second time.
    Then we called the command itself, passing in the endEffector subsystem, and a constant number for the storage position
    */
}

}
