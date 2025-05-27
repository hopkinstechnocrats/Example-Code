package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

class PhoenixPID extends SubsystemBase{

    TalonFX exampleMotor;
    //the configuration for the motor can be created in the config class
    //there are 3 slots for configs, each with their own class
    //check the phoenix 6 docs for all that is contained in the configurator
    Slot0Configs slot0Configs;
    //phoenix 6 handles motor controls as requests, with multiple different types
    //position voltage is a class for using a PID to go to a position in rotations
    final PositionVoltage examplePositionRequest;
    //velocity voltage uses a PID to go to a velocity in rotations per second
    final VelocityVoltage exampleVelocityRequest;

    PhoenixPID(){
        //setting values for our slot 0 config
        slot0Configs = new Slot0Configs();
        slot0Configs.kP = Constants.SubsystemConstants.exampleP;
        slot0Configs.kI = Constants.SubsystemConstants.exampleI;
        slot0Configs.kD = Constants.SubsystemConstants.exampleD;

        //creating our requests that use slot 0
        examplePositionRequest = new PositionVoltage(0).withSlot(0);
        exampleVelocityRequest = new VelocityVoltage(0).withSlot(0);

        //creating our motor
        exampleMotor = new TalonFX(Constants.SubsystemConstants.kExamplePort);

        //applying our configs
        exampleMotor.getConfigurator().apply(slot0Configs);
    }

    //moves the motor to a position using a position in motor rotations 
    public void runPosition(double positionRotations){
        exampleMotor.setControl(examplePositionRequest.withPosition(positionRotations));
    }

    //gets the motor to spin to a speed in motor rotations per second
    public void runVelocity(double velocityRotationsPerSecond){
        exampleMotor.setControl(exampleVelocityRequest.withVelocity(velocityRotationsPerSecond));
    }
}  
