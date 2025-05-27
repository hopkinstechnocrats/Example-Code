package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

class WpiPid extends SubsystemBase{

    //declare motor and pid variables
    TalonFX exampleMotor;
    PIDController examplePID;

    //initialize our variables and configure
    WpiPid(){
        //more details on the motors can be found in the simple motor example 
        exampleMotor = new TalonFX(Constants.SubsystemConstants.kExamplePort);
        //the PID class has many variations, here I am showing a simple one
        //the PID class requires manual tuning through trial and error
        //a PID is used to smoothly get to a setpoint, whether that be a position setpoint or a velocity setpoint
        //when tuning, start with your P value and raise it to a value where it becomes unstable and starts oscillating
        //once you find the point where it begins oscillating, set P to half of that value
        //if further tuning is required, you can begin tuning an I or D value depending on the situation, usually I
        //once properly tuned, you can give a setpoint and the PID function will return a value that wwill smoothly get you to that position
        examplePID = new PIDController(Constants.SubsystemConstants.exampleP,
                Constants.SubsystemConstants.exampleI, Constants.SubsystemConstants.exampleD);
        //setting a tolerence allows the PID to confirm that it's in a position once it is within a certain range from the target value
        examplePID.setTolerance(Constants.SubsystemConstants.exampleTolerence);
    }

    //this function can be called in a command to run the motor to a given setpoint
    //you should have a default command always running when there isn't a command, and then you can run other commands as needed
    //another way to do this is having constant setpoints, and then having a switch-case for each setpoint
    public void run(double setpoint){
        //the setpoint is set at the start of the function, and this function should be called in a loop so that it is always updated
        examplePID.setSetpoint(setpoint);
        //sets the output of the example motor to the calculted value of the pid
        //current position is retrieved from the onboard encoder of the talonfx
        //you can also use the clamp() function to set a minimum and maximum value
        exampleMotor.set(examplePID.calculate(exampleMotor.getPosition().getValueAsDouble()));
    }

    //this function can be called to see if the motor has reached its desired setpoint
    public boolean atSetpoint(){
        return examplePID.atSetpoint();
    }
}
