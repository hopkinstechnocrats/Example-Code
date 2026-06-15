package frc.robot;

public final class Constants{

    //in this file, youll notice that all of the variable names start with a k
    //it specifies it as a constant value so other programmers can better understand what the constant is quicker
    public static final class SensorConstants{
        public static final int kPhotoSensorPort = 1; //should be set to the number of the DIO port the sensor is connected to
        public static final int kLimitSwitchPort = 1; //should be set to the analog input port on the roboRIO
    }

    public static final class SubsystemConstants{
        public static final int kOperatorControllerPort = 1;//the port in the driver station for the operator controller

        //the CAN IDs for various devices
        public static final int kKrakenExampleCANID = 10;
        public static final int kKrakenFollowerExampleCANID = 4;
        public static final int kCIMExampleCANID = 6;
        public static final int kCIMFollowerExampleCANID = 1;
        public static final int kExampleFollowerPort = 2;
        public static final int kExamplePort = 8;
        
        //speeds/positions for motors
        public static final double kExampleDouble = 1.0;
        public static final double kMotorSpeed = 0.1;
        public static final double kMotorVelocityRPS = 5;
        public static final double kMotorPosition = 1;
        public static final double kMotorPosition2 = 2;
        public static final double kMotorVelocityRPS2 = .05;// (5/100). here, the 5 is the goal rps. Kraken x60 motors have a max speed of 100 rps
        //we put the goal rps over the max to tell the motor a percent power to run! you also need to account for gear ratios if applicable

        //PID config values
        public static final double exampleP = .3;
        public static final double exampleI = 0.1;       
        public static final double exampleD = 0;
        public static final double exampleTolerence = 0.5;
    }


}
