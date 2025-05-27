package frc.robot;

public final class Constants{

    public static final class SensorConstants{
        public static final int kPhotoSensorPort = 1; //should be set to the number of the DIO port the sensor is connected to
        public static final int kLimitSwitchPort = 1; //should be set to the analog input port on the roboRIO
    }

    public static final class SubsystemConstants{
        public static final double kExampleDouble = 1.0;
        public static final int kExamplePort = 1;
        public static final double kMotorSpeed = 0.1;
        public static final int kExampleFollowerPort = 2;

        public static final double exampleP = 0.1;
        public static final double exampleI = 0.01;       
        public static final double exampleD = 0.1;
        public static final double exampleTolerence = 0.5;
    }

}
