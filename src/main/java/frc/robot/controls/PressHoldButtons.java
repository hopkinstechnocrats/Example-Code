package frc.robot.controls;

// This class explains how to bind press and hold buttons
// These are often put in RobotContainer, so this class is structured as such
// For more examples on robot container, view ButtonBindings.java
// This class will lack any additional classes that ButtonBindings had (not nece)

public class PressHoldButtons {
    /*
    We use the same variable names for press and hold buttons, those don't change
    You can use a button just as you would for a standard button binding command

        Example for formatting:
        controller.button().whileTrue(MechanismCommands.specificCommand(requirement1, requirement2))

        Example that was actually used in 2025:
        operatorController.x().whileTrue(EndEffectorCommands.changeSetpointCommand(endEffector, Constants.endEffectorConstants.Stowage));

    We wanted to move the end effector to its storage position, a defined constant -- we used these steps:

    We started by calling which controller we wanted to trigger the command (in this case, operator)
    Then we said the button to use (In this case, the X button)
    onTrue is most often used, schedules on initial button press -- this is what we used
    whileTrue can also be helpful and calls as long as the button is pressed.
    toggleOnTrue, the third option, will call, and then continue until the button is pressed a second time.
    Then we called the command itself, passing in the endEffector subsystem, and a constant number for the storage position
    */
}
