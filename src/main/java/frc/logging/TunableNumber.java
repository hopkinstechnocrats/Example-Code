package frc.logging;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleSupplier;

import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class TunableNumber implements DoubleSupplier{

    private final String key;
    private boolean hasDefault = false;
    private double defaultValue;
    private final DoubleEntry entry;
    private Map<Integer, Double> lastHasChangedValues = new HashMap<>();

    

    public TunableNumber(String key, double defaultValue){
        this.key = key;
        this.entry = NetworkTableInstance.getDefault().getDoubleTopic(key).getEntry(0.0);
        initDefault(defaultValue);
    }

    public void initDefault(double defaultValue){
        if (!hasDefault) {
            
            hasDefault = true;
            this.defaultValue = defaultValue; 
        }
    }
}
