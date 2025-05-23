package frc.robot.sensors;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//example subsystem
class PhotoSensor extends SubsystemBase{
    //photo sensors are plugged into the roborio as digital inputs
    DigitalInput photoSensor;

    public PhotoSensor(){
        //initialize the photo sensor along with everything else in the constructor
        photoSensor = new DigitalInput(Constants.SensorConstants.kPhotoSensorPort /*all constant values should be in constants file*/); 
    }

    //example on how to return the state as a boolean supplier. true = dark, false = light
    public BooleanSupplier getSensorSupplier(){
        return photoSensor::get;
    }

    //example on how to return the state as a boolean. true = dark, false = light
    public Boolean getSensor(){
        return photoSensor.get();
    }
}
