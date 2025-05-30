package frc.robot.controls;

// This class explains how to bind joysticks
// These are often put in RobotContainer, so this class is structured as such
// For more examples on robot container, view ButtonBindings.java
// This class will lack any additional classes that ButtonBindings had

public class JoystickBindings {
    /*
    We use the same variable names for joysticks, those don't change
    Joysticks are not typically used like the other buttons but rather as arguments passed in other functions
    Example of function:

        SwerveInputStream driveDirectAngleKeyboard = driveAngularVelocityKeyboard.copy()
                        .withControllerHeadingAxis(() ->Math.sin(
                            driverXbox.getRawAxis(2) * Math.PI) *
                            (Math.PI * 2),
                        () -> Math.cos(
                            driverXbox.getRawAxis(2) * Math.PI) *
                            (Math.PI * 2)).headingWhile(true);

    Most of this function is math functions, but the 'driverXbox.getRawAxis(2)' is the main interesting part.
    All this does is take the raw axis values, which will be between -1 and 1, the joytick is putting out (on the second axis).
    In this case, it would get the value of the left-Y axis that the controller is sending.

    This function is then taking these values to be able to calculate where/how to drive.
    This will be listed elsewhere as how this works is not joystick-specific.

    To set a controller, you can do the following:

        XboxController exampleXbox = new XboxController(0);

    where 0 is the USB Port to be used - it will be shown on driver Station.

    */
}
