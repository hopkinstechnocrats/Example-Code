package frc.robot.sensors;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

class PhotoSensor extends SubsystemBase{
    DigitalInput photoSensor;

    public PhotoSensor(){
        photoSensor = new DigitalInput(Constants.SensorConstants.kPhotoSensorPort); 
    }

    public BooleanSupplier getSensorSupplier(){
        return photoSensor::get;
    }

    public Boolean getSensor(){
        return photoSensor.get();
    }
}
