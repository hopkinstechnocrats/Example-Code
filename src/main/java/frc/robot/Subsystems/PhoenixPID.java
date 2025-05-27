package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

class PhoenixPID extends SubsystemBase{

    TalonFX exampleMotor;
    Slot0Configs slot0Configs;
    final PositionVoltage exampleRequest;

    PhoenixPID(){
        slot0Configs = new Slot0Configs();
        slot0Configs.kP = Constants.SubsystemConstants.exampleP;
        slot0Configs.kI = Constants.SubsystemConstants.exampleI;
        slot0Configs.kD = Constants.SubsystemConstants.exampleD;

        exampleRequest = new PositionVoltage(0).withSlot(0);

        exampleMotor = new TalonFX(Constants.SubsystemConstants.kExamplePort);

        exampleMotor.getConfigurator().apply(slot0Configs);
    }

    public void run(double positionRotations){
        exampleMotor.setControl(exampleRequest.withPosition(positionRotations));
    }
}  
