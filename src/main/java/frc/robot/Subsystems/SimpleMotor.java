package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

class SimpleMotor extends SubsystemBase{

    //create your motor variables before using them
    //these examples assume you are using the TalonFX motor controller. Other motors will have slightly different but similar setup
    //the TalonFX controllers are a part of the Phoenix 6 library, and you can find documentation for them in the Phoenix 6 documentation
    TalonFX simpleMotor;
    TalonFX simpleFollower;

    //this is the initializer that gets called when we first create our instance of a class
    //here we will configure all our devices so that we can use them in other functions
    SimpleMotor(){
        //when creating a new motor you need to give the constructor the CANID number of the motor
        //the CANID of a ctre motor can be set in PhoenixTunerX
        simpleMotor = new TalonFX(Constants.SubsystemConstants.kExamplePort);
        simpleFollower = new TalonFX(Constants.SubsystemConstants.kExampleFollowerPort);

        //phoenix 6 has many tools for modifying how a motor works, one of which is the follower mode
        //when setting follower mode, you need to give the id of another motor that you will follow, and whether to invert controls
        //in follower mode, the motor will always have the same output as the leader motor
        //if inverted is set to true, it will always do the exact opposite of the leader motor
        //you would usually want to invert when the motors are facing in different directions
        simpleFollower.setControl(new Follower(simpleMotor.getDeviceID()/*we are using getDeviceID so that it still works even if we change the ID*/, true));

        //this makes it so that our motor will brake whenever it doesn't have a command
        simpleMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    //this function will spin the motor at a set speed
    //it will also cause our follower to mirror our leaders movements
    public void spinMotor(){
        //motor speed is set as a percent amperage from -1 to 1, where 1 is 100% power forwards and -1 is 100% power backwards
        //we are using a constant here because we want the motor to always go the same speed. You can also create a function that takes in speed as a variable
        //if you want to see a more advanced speed control, see the PID example
        simpleMotor.set(Constants.SubsystemConstants.kMotorSpeed);
    }

    //this function does the same as our previous except the opposite value
    public void spinMotorBackwards(){
        simpleMotor.set(-Constants.SubsystemConstants.kMotorSpeed);
    }
}
