package frc.robot.limelight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.LimelightHelpers;

class Megatag2 extends SubsystemBase{

    Megatag2(){

    }
   

    public void updateVisionReading(){
        boolean doRejectUpdate = false;
        LimelightHelpers.SetIMUMode("limelight", 0);

        robotYaw.setDouble(swerveDrive.getYaw().getDegrees());
        LimelightHelpers.SetRobotOrientation("limelight", swerveDrive.getYaw().getDegrees(),0, 0, 0, 0, 0);
        LimelightHelpers.PoseEstimate mt2 = LimelightHelpers.getBotPoseEstimate_wpiBlue_MegaTag2("limelight");

        if(mt2 != null){
        // if our angular velocity is greater than 360 degrees per second, ignore vision updates
            if(Math.abs(swerveDrive.getGyro().getYawAngularVelocity().in(DegreesPerSecond)) > 360)
            {
                doRejectUpdate = true;
            }
            if(mt2.tagCount == 0 || mt2 == null)
            {
                doRejectUpdate = true;
            }
            if(!doRejectUpdate)
            {
                swerveDrive.setVisionMeasurementStdDevs(VecBuilder.fill(.7,.7,999999));
                swerveDrive.addVisionMeasurement(mt2.pose, mt2.timestampSeconds);
            }
        }
    }
}
