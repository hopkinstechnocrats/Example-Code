package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;// Allows us to run a Subsystem
import frc.robot.Constants;// Allows us to call constant values, numbers

import com.ctre.phoenix6.controls.Follower;// Allows us to use Leader Follower
import com.ctre.phoenix6.hardware.TalonFX;// Allows Krakens to exist in  code
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;// Allows SRX motor controllers to exist in Code
import com.ctre.phoenix6.signals.MotorAlignmentValue;// Allows Followers run opposite to the Leader
import com.ctre.phoenix6.configs.Slot0Configs;//Allows us to access and apply the slot 0 of configs
import com.ctre.phoenix6.controls.PositionVoltage;//Allows us to give a position with a PID loop
import com.ctre.phoenix6.controls.VelocityVoltage;//Allows us to give a velocity with a PID loop


public class MotorExamplesSubsystem extends SubsystemBase {

    /*create your motor variables before using them.
    This example assumes you are using the TalonFX motor controller, these are built into Kraken motors.
    the TalonFX motor controller is a part of the Phoenix 6 library, and you can find documentation for them in the Phoenix 6 documentation */
    TalonFX krakenExampleMotor;
    TalonFX krakenExampleFollower;

    //This is an example with TalonSRX motor contollers, mainly used for CIM motors on our team
    //To use the TalonSRX motor controllers, you need to install the phoenix 5 vendor library
    WPI_TalonSRX CIMExampleMotor;
    WPI_TalonSRX CIMExampleFollower;

    /*the configuration for the motor can be created in the config class that we imported.
    there are 3 slots for configs, 0 1 and 2, each with their own class.
    check the phoenix 6 docs for all that is contained in the configurator*/
    Slot0Configs slot0Configs;

    double positionSpinValue;
    double positionSpinSpeed;

    //Phoenix 6 handles motor controls as requests, with multiple different types, the main ones being velocity and position
    //Position voltage is a class for using a PID loop to go to a position in rotations
    final PositionVoltage PositionRequest;
    //velocity voltage uses a PID loop to go to a velocity in rotations per second
    final VelocityVoltage VelocityRequest;

    /*all this PID stuff sounds cool, but what actually does it do, and when should we use it?
    a PID loop is a control loop that is used to let a motor stay at a constant velocity, or go to an exact position, this constant is called a setpoint!
    to use them, you need to create your request, your configs, and then apply values to the different parts of the configs.
    The main configs that we use are the P, I, and D values, although there are more, like G, sometimes called feedforward, sometimes called gravity compensation.
    The P value is what ramps up the motor super quickly to the setpoint we want the motor to be running, but it overshoots, then oscillates.
    The I value helps to regulate the oscillation, making the output more consistent around the setpoint.
    The D value limits the overshoot from the P value.
    All of these together make a PID control loop, allowing us to have consistent motor outputs that regulate themselves around the setpoint.
    To find all these values you need to manually set and tune them.

    when tuning, start with your P value and raise it to a value where it becomes unstable and starts oscillating.
    once you find the point where it begins oscillating, set P to half of that value.
    if further tuning is required, you can begin tuning an I or D value depending on the situation, usually I.
    D isn't used as often, and when it is, the value is quite small.
    You can look at your power being sent to a motor by using Advantage Scope*/


    /*this is the initializer, that gets called when we first create our instance of a class.
    here we will configure all our devices so that we can use them in other functions*/
    public MotorExamplesSubsystem() {

        //when creating a new motor you need to specify the CANID number of the motor.
        //the CANID of a ctre motor can be set in PhoenixTunerX.
        krakenExampleMotor = new TalonFX(Constants.SubsystemConstants.kKrakenExampleCANID);
        krakenExampleFollower = new TalonFX(Constants.SubsystemConstants.kKrakenFollowerExampleCANID);

        CIMExampleMotor = new WPI_TalonSRX(Constants.SubsystemConstants.kCIMExampleCANID);
        CIMExampleFollower = new WPI_TalonSRX(Constants.SubsystemConstants.kCIMFollowerExampleCANID);

        //Now, we actually create the requests, specifying to pull configs from our slot0Configs.
        //We also set the default setpoint here, but that value should be 0, because it's assinged a value later.
        PositionRequest = new PositionVoltage(0).withSlot(0);
        VelocityRequest = new VelocityVoltage(0).withSlot(0);

        //We need to create the configs at slot 0.
        slot0Configs = new Slot0Configs();

        //Now, we set all of our config values!
        slot0Configs.kP = Constants.SubsystemConstants.exampleP;
        slot0Configs.kI = Constants.SubsystemConstants.exampleI;
        slot0Configs.kD = Constants.SubsystemConstants.exampleD;

        //Now that we've created our configs, and assinged them values, we have to apply the configs to the motor that will be recieveing from the PID loop.
        krakenExampleMotor.getConfigurator().apply(slot0Configs);

        /*phoenix 6 has many tools for modifying how a motor works, one of which is the follower mode.
        when setting follower mode, you need to give the id of another motor that you will follow, and whether to invert controls.
        in follower mode, the motor will always have the same output as the leader motor.
        if the MotorAlignmentValue is set to opposed, it will always do the exact opposite of the leader motor
        you would usually want to invert when the motors are facing in different directions*/
        //we are using getDeviceID so that it still works even if we change the ID
        krakenExampleFollower.setControl(new Follower(krakenExampleMotor.getDeviceID(), MotorAlignmentValue.Opposed));
        
        //this is how we set a CIM motor as a follower
        CIMExampleFollower.follow(CIMExampleMotor);

        //we also need to invert the Follower CIM if it is facing opposite to the leader.
        //This needs to be done seperatly because CIMs run off of Poenix 5, and dont have as many tools available to them.
        CIMExampleFollower.setInverted(true);

        
    }

    /*This is a periodic function! it needs to be run in a class that extends subsystem base.
    This function runs whatever is inside of it every computer tick, so it's used for updating values.
    Here, it's being used to update the value to spin the position function without a PID*/
    @Override
        public void periodic(){
            positionSpinValue = (Constants.SubsystemConstants.kMotorPosition2 - krakenExampleMotor.getPosition().getValueAsDouble())*.01;

            if(positionSpinValue < .005){
                positionSpinSpeed = .005;
            }else if(positionSpinValue > .1){
                positionSpinSpeed = .1;
            }else{
                positionSpinSpeed = positionSpinValue;
            }
        }

    /*This is a Method! it's what sets how we spin the motor
    This method spins the motor with a percent speed using motorName.set, 1 being full power, and -1 being full power reverse, so .5 would be half power, or 50% 
    The name of the method doesn't matter as long as it's informative to what it does, and method names should be capitalized.
    The method format is the same between different types of motor controller.
    here the variable "speed" is used as a parameter for the method so that we can run multiple values in commands with the same method*/
    public void SpinMotorPercentSpeed (double speed){
        krakenExampleMotor.set(speed);
    }

    /*a method using a PID loop is formatted slightly differently.
    Instead of using .set to set a constant speed, we use .setControl to run the PID loop.
    Then, we say which request we're pulling from, and set the setpoint.
    We make the setpoint a variable so we're able to use the same method for multiple setpoints by setting the value in the command
    The unit for the Velocity PID is rotations per second*/
    public void SpinVelocityPID (double setpointInRPS){
        krakenExampleMotor.setControl(VelocityRequest.withVelocity(setpointInRPS));
    }

    //The only difference with the position method is that the unit is in Number of Rotations.
    //So if you wanted the motor to spin a quarter of the way, or 90 degrees, you'd input .25.
    public void SpinPositionPID (double setpointInRotations){
        krakenExampleMotor.setControl(PositionRequest.withPosition(setpointInRotations));
    }

    /*Here we are setting the position without utilizing the PID loop.
    To do this, we are telling the motor to spin at a variable speed.
    This speed is updated in the periodic above!
    This value is the difference between the goal position, and the actual position
    So the closer it is to the position, the slower it will move, and the further away, the faster it will move*/
    public void SpinPosition (){
        krakenExampleMotor.set(positionSpinSpeed);
    }

    /*this is a method to set the velocity in RPS without a PID loop.
    .set is still used, but the variable we call in should have a unit conversion conversion done to convert %power to RPS.
    This unit conversion will depend on the max speed of the motor.
    This can also be acheived by calling a different constant through the normal percent power method in the commands file
    but for the sake of the example, it's seperate*/
    public void SpinVelocity (double speedInRPS){
        krakenExampleMotor.set(speedInRPS);
    }

    //this method is run as the default when nothing else is running, so the motors stop when the button input is stopped
    public void Brake (){
        krakenExampleMotor.set(0);
        //we set these motor's speeds to 0 to brake them
    }
}
