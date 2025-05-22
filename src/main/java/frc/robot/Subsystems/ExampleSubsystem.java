//make sure to add this class to the filepath so other classes can find it
package frc.robot.Subsystems;

//importing other classes allows you to access their functions
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//we extend the subsystem base to create new subsystems that have the pre-existing capabilities of subsystems
class ExampleSubsystem extends SubsystemBase{
    //declare variables before using
    double exampleDouble;
    DigitalInput exampleDI;


    //initialize variables in the main function, this function should share a name with the class
    //this function will run once when you initialize the subsystem in other classes, usually RobotContainer
    public ExampleSubsystem(){
        //static values should be stored and called from the Constants class
        exampleDouble = 1.0;
        exampleDI = new DigitalInput(1);
    }


    //you can create new functions to do whatever you want in the class
    //functions you create can then be called in commands that will call those functions
    public void updateDouble(double value){
        exampleDouble = value;
    }

    //we need to override the function of the pre existing periodic function of subsystem base
    @Override
    //the periodic function is called once every scheduler loop
    public void periodic(){

    }
}
