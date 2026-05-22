package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;// Allows us to run a Subsystem
import frc.robot.Constants;// Allows us to call constant values, numbers

import com.ctre.phoenix6.controls.Follower;// Allows us to use Leader Follower
import com.ctre.phoenix6.hardware.TalonFX;// Allows Krakens to exist in  code
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;// Allows CIMs to exist in Code
import com.ctre.phoenix6.signals.MotorAlignmentValue;// Allows Followers run opposite to the Leader
import com.ctre.phoenix6.signals.NeutralModeValue;// Allows us to have a default command running on a Kraken Motor
import com.ctre.phoenix.motorcontrol.NeutralMode;// Allows us to have a default command running on a CIM Motor


public class MotorExamples extends SubsystemBase {

    /*create your motor variables before using them.
    This example assumes you are using the TalonFX motor controller, mainly used for Kraken motors on our team.
    the TalonFX and TalonSRX motor controllers are a part of the Phoenix 6 library, and you can find documentation for them in the Phoenix 6 documentation */
    TalonFX krakenExampleMotor;
    TalonFX krakenExampleFollower;

    //This is an example with TalonSRX motor contollers, mainly used for CIM motors on our team
    //To use the TalonSRX motor controllers, you need to install the phoenix 5 vendor library
    WPI_TalonSRX CIMExampleMotor;
    WPI_TalonSRX CIMExampleFollower;

    /*this is the initializer, that gets called when we first create our instance of a class.
    here we will configure all our devices so that we can use them in other functions*/
    public MotorExamples() {

        //when creating a new motor you need to give the constructor the CANID number of the motor.
        //the CANID of a ctre motor can be set in PhoenixTunerX.
        krakenExampleMotor = new TalonFX(Constants.SubsystemConstants.kKrakenExampleCANID);
        krakenExampleFollower = new TalonFX(Constants.SubsystemConstants.kKrakenFollowerExampleCANID);

        CIMExampleMotor = new WPI_TalonSRX(Constants.SubsystemConstants.kCIMExampleCANID);
        CIMExampleFollower = new WPI_TalonSRX(Constants.SubsystemConstants.kCIMFollowerExampleCANID);

        /*phoenix 6 has many tools for modifying how a motor works, one of which is the follower mode.
        when setting follower mode, you need to give the id of another motor that you will follow, and whether to invert controls.
        in follower mode, the motor will always have the same output as the leader motor.
        if the MotorAlignmentValue is set to opposed, it will always do the exact opposite of the leader motor
        you would usually want to invert when the motors are facing in different directions*/
        krakenExampleFollower.setControl(new Follower(krakenExampleMotor.getDeviceID(), MotorAlignmentValue.Opposed));
        //we are using getDeviceID so that it still works even if we change the ID

        //this is how we set a CIM motor as a follower
        CIMExampleFollower.follow(CIMExampleMotor);

        //we also need to invert the Follower CIM if it is facing opposite to the leader.
        //This needs to be done seperatly because CIMs run off of Poenix 5, and dont have as many tools available to them.
        CIMExampleFollower.setInverted(true);

        /*//this is the neutral mode, It makes the motor stop whenever it doesnt have a command
        krakenExampleMotor.setNeutralMode(NeutralModeValue.Brake);
        krakenExampleFollower.setNeutralMode(NeutralModeValue.Brake);
        CIMExampleMotor.setNeutralMode(NeutralMode.Brake);
        CIMExampleFollower.setNeutralMode(NeutralMode.Brake);*/
        //test these neutral modes, not sure if theyre necesarry
    }

    /*This is a Method! it's what sets how we spin the motor
    This method spins the motor with a percent speed using motorName.set, 1 being full power, and -1 being full power reverse, so .5 would be half power, or 50% 
    The name of the method doesn't matter as long as it's informative to what it does, and method names should be Capatilized*/
    public void SpinMotorPercentSpeed (double speed){
        krakenExampleMotor.set(speed);
        //there the variable "speed" is used as a parameter for the method so that we can run multiple values in commands with the same method
    }

    public void SpinCIM (){
        CIMExampleMotor.set(Constants.SubsystemConstants.kMotorSpeed);
    }

    public void Brake (){
        krakenExampleMotor.set(0);
        CIMExampleMotor.set(0);
        //we set these motor's speeds to 0 to brake them
    }


}
