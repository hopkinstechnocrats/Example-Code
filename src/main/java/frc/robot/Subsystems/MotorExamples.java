package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;// Allows us to run a Subsystem
import frc.robot.Constants;// Allows us to call constant values, numbers

import com.ctre.phoenix6.controls.Follower;// Allows us to use Leader Follower
import com.ctre.phoenix6.hardware.TalonFX;// Allows Krakens to exist in  code
import com.ctre.phoenix6.hardware.TalonFXS;// Allows CIMs to exist in Code
import com.ctre.phoenix6.signals.MotorAlignmentValue;// Allows Followers run opposite to the Leader
import com.ctre.phoenix6.signals.NeutralModeValue;// Allows us to have a default command running on a motor

public class MotorExamples extends SubsystemBase {
    /*create your motor variables before using them
    This example assume you are using the TalonFX motor controller, mainly used for Kraken motors on our team
    the TalonFX and TalonFXS controllers are a part of the Phoenix 6 library, and you can find documentation for them in the Phoenix 6 documentation */
    TalonFX krakenExampleMotor;
    TalonFX krakenExampleFollower;
    //This is an example with TalonFXS motor Contollers, mainly used for CIM motors on our team
    TalonFXS CIMExampleMotor;
    TalonFXS CIMExampleFollower;

    /*this is the initializer, that gets called when we first create our instance of a class
    here we will configure all our devices so that we can use them in other functions*/
    public MotorExamples() {
        //when creating a new motor you need to give the constructor the CANID number of the motor
        //the CANID of a ctre motor can be set in PhoenixTunerX
        krakenExampleMotor = new TalonFX(Constants.SubsystemConstants.kKrakenExampleCANID);
        krakenExampleFollower = new TalonFX(Constants.SubsystemConstants.kKrakenFollowerExampleCANID);

        CIMExampleMotor = new TalonFXS(Constants.SubsystemConstants.kCIMExampleCANID);
        CIMExampleFollower = new TalonFXS(Constants.SubsystemConstants.kCIMFollowerExampleCANID);

        /*phoenix 6 has many tools for modifying how a motor works, one of which is the follower mode
        when setting follower mode, you need to give the id of another motor that you will follow, and whether to invert controls
        in follower mode, the motor will always have the same output as the leader motor
        if inverted is set to true, it will always do the exact opposite of the leader motor
        you would usually want to invert when the motors are facing in different directions*/
        krakenExampleFollower.setControl(new Follower(krakenExampleMotor.getDeviceID(), MotorAlignmentValue.Opposed));
        CIMExampleFollower.setControl(new Follower(CIMExampleMotor.getDeviceID(), MotorAlignmentValue.Opposed));
        //we are using getDeviceID so that it still works even if we change the ID
        //this is the default command. It makes the motor stop whenever it doesnt have a command
        krakenExampleMotor.setNeutralMode(NeutralModeValue.Brake);
    }

    /*This is a Method! it's what sets how we spin the motor
    This method spins the motor with a percent speed, 1 being full power, and -1 being full power reverse, so .5 would be half power, or 50%*/
    public void SpinMotorPercentSpeed (double speed){
        krakenExampleMotor.set(speed); 
        //we set the motor to the variable "speed", which is whatever value we assing to it in the command!
    }


}
