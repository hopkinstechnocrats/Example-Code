package frc.robot.sensors;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//example subsystem that uses an analog limit switch as a digital true/false input
//you can see the photo sensor file to learn how to utilize a digital input limit switch
class LimitSwitch extends SubsystemBase{
    //sensor will be plugged in as an analog input
    AnalogTrigger limitSwitch;

    public LimitSwitch(){
        //initialize the limit switch  along with everything else in the constructor
        limitSwitch = new AnalogTrigger(Constants.SensorConstants.kLimitSwitchPort);
        //set the trigger to enable at 4 volts and disable at 3
        //value of analog input goes from 0-5 volts
        limitSwitch.setLimitsVoltage(3, 4);
    }

    //example on how to return the state as a boolean supplier
    public BooleanSupplier getSensorSupplier(){
        return limitSwitch::getTriggerState;
    }

    //example on how to return the state as a boolean
    public Boolean getSensor(){
        return limitSwitch.getTriggerState();
    }
}
