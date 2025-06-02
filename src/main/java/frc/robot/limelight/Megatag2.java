package frc.robot.limelight;

import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.LimelightHelpers;
import edu.wpi.first.math.VecBuilder;

class Megatag2 extends SubsystemBase{

    Megatag2(){

    }
   

    public void updateVisionReading(double yawDegrees, double yawAngularVelocityDegreesPerSecond, 
            SwerveDrivePoseEstimator poseEstimator){
        boolean doRejectUpdate = false;
        LimelightHelpers.SetIMUMode("limelight", 0);

        LimelightHelpers.SetRobotOrientation("limelight", yawDegrees,0, 0, 0, 0, 0);
        LimelightHelpers.PoseEstimate mt2 = LimelightHelpers.getBotPoseEstimate_wpiBlue_MegaTag2("limelight");

        if(mt2 != null){
        // if our angular velocity is greater than 360 degrees per second, ignore vision updates
            if(Math.abs(yawAngularVelocityDegreesPerSecond) > 360)
            {
                doRejectUpdate = true;
            }
            if(mt2.tagCount == 0 || mt2 == null)
            {
                doRejectUpdate = true;
            }
            if(!doRejectUpdate)
            {
                poseEstimator.setVisionMeasurementStdDevs(new Matrix<N3,N1>(VecBuilder.fill(.7,.7,999999)));
                poseEstimator.addVisionMeasurement(mt2.pose, mt2.timestampSeconds);
            }
        }
    }
}
