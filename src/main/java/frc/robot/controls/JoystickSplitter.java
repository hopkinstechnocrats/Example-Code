package frc.robot.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*  This class has example functions for returning a heading of a joystick that can then be 
    used to section off a joystick so that if the joystick is within a section it always
    returns the same value. This can be used to then essentially have your joystick act as multiple buttons,
    where you can filter out the specific joystick value you want and only do something when the joystick is at that value.
    You can also use this in a heading based control to only have as many possible robot angles as there are sections.
*/
class JoystickSplitter extends SubsystemBase{
    XboxController driverXbox;
    
    JoystickSplitter(int controllerPort){
        driverXbox = new XboxController(controllerPort);

    }

    //returns a value from -1 to 1 that will be the same for all values within a section.
    public double headingX(double deadband, double sections){
        final double rad_per_section = (2.0*Math.PI/sections);
        final double section =((((Math.atan2(-driverXbox.getRightY(), driverXbox.getRightX())))/rad_per_section)+0.5); // in from -2.5 to +3.5
        final int section_rounded = Math.round((float) section);
        final double angle = section_rounded * rad_per_section;
        if( Math.hypot(driverXbox.getRightX(),-driverXbox.getRightY()) <= deadband){
            return 0.0;
        } 
        else {
            return Math.cos(angle+ ((4*Math.PI)/3)) ; 
        }
    }

    //returns a value from -1 to 1 that will be the same for all values within a section.
    public double headingY(double deadband, double sections){
        final double rad_per_section = (2.0*Math.PI/sections);
        final double section =((((Math.atan2(-driverXbox.getRightY(), driverXbox.getRightX())))/rad_per_section)+0.5); // in from -2.5 to +3.5
        final int section_rounded = Math.round((float) section);
        final double angle = section_rounded * rad_per_section;
        if( Math.hypot(driverXbox.getRightX(),-driverXbox.getRightY()) <= deadband){
            return 0.0;
        } 
        else {
            return -Math.sin(angle+ ((4*Math.PI)/3));
        } 
    }
}
