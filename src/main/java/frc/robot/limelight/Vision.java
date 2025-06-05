package frc.robot.limelight;

public class Vision {
/*
    At the very start of this file, there is a long string of variable definitions.
    Some of these change per year, so they will not be written here to avoid bad information.
    You can find what the values will be on the limelight docs - the main one being the yearly april tag layout.

    After that, the constructor does have valuable arguments that will be used later
    This is the constructor from 2025:

        public Vision(Supplier<Pose2d> currentPose, Field2d field) {
            this.currentPose = currentPose;
            this.field2d = field;

            if (Robot.isSimulation())
            {
            visionSim = new VisionSystemSim("Vision");
            visionSim.addAprilTags(fieldLayout);

            for (Cameras c : Cameras.values())
            {
                c.addToVisionSim(visionSim);
            }

            openSimCameraViews();
            }
        }

    All it basically does is add the necessary information you'll need for the rest of the file.
    It will give different information based on whether the robot is ran in simulation mode as well.
    While in 2025 we rarely used this feature, it still is helpful to have and mantain.

    There are two main functions that are most useful (and complicated) in this file for basic limelight actions:
    getAprilTagPose and getDistanceFromAprilTag
    
    The first one, getAprilTagPose, is fairly straightforward.
    This is an example of the function:

        public static Pose2d getAprilTagPose(int aprilTag, Transform2d robotOffset) {
            Optional<Pose3d> aprilTagPose3d = fieldLayout.getTagPose(aprilTag);
            if (aprilTagPose3d.isPresent()) {
                return aprilTagPose3d.get().toPose2d().transformBy(robotOffset);
            } else {
                throw new RuntimeException("Cannot get AprilTag " + aprilTag + " from field " + fieldLayout.toString());
            }

        }

    It seems rather complicated, but most of it is just basic calculations with a lot of words.
    it takes in the apriltag, and the offset of the robot in general comparison to that.
    With this, it can get where the april tag actually is and modify that based off of the previous robot offset.
    (And the else is just an error if it cannot retrieve whatever apriltag it has been given).

    This is an example of the second one (getDistanceFromAprilTag):

        public double getDistanceFromAprilTag(int id) {
            Optional<Pose3d> tag = fieldLayout.getTagPose(id);
            return tag.map(pose3d -> PhotonUtils.getDistanceToPose(currentPose.get(), pose3d.toPose2d())).orElse(-1.0);
        }

    This file is mostly helpful for actually driving to an apriltag.
    It takes in an int to find the april tag and finds out the difference between the robot's location and the apriltag.
        
 */
}
