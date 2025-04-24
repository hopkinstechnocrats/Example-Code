package frc.logging;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//this is an example subsystem used to store the network tables code
public class NetworkTables extends SubsystemBase{
    
    //declare vatiables 
    NetworkTableInstance inst;
    NetworkTable table;
    NetworkTableEntry nt_exampleValue;

    public NetworkTables(){
        //initialize variables inside subsytem cunstructor
        //the instance gives access to the whole "files system" of the robot network tables
        inst = NetworkTableInstance.getDefault();
        //the table uses the instance to create a new "folder" inside the "file system"
        //you can have multiple tables inside of one class, though we typically won't do that
        //you can also navigate down multiple tables like filepaths in a file system
        table = inst.getTable("Example");
        //any value we want to use needs to create an entry in the table
        nt_exampleValue = table.getEntry("Example Entry");
    }

    public void exampleFunction(){
        //you can update values when using them
        //TODO make sure to set the value to a variable you're using
        //you can also set all your values in one update function that gets called in the periodic
        nt_exampleValue.setDouble(3);
    }
}
