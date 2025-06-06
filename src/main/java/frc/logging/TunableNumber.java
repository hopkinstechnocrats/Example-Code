package frc.logging;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;

import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

@SuppressWarnings("unused")
public class TunableNumber implements DoubleSupplier{

    private final String key;
    private double defaultValue;
    private final DoubleEntry entry;
    private Map<Integer, Double> lastHasChangedValues = new HashMap<>();

    public TunableNumber(String key, double defaultValue){
        this.key = key;
        this.entry = NetworkTableInstance.getDefault().getDoubleTopic(key).getEntry(0.0);
        initDefault(defaultValue);
    }

    public void initDefault(double defaultValue){
        this.defaultValue = defaultValue; 
        entry.set(entry.get(defaultValue));
    }

    public double get() {
        return entry.get(defaultValue);
    }
     
    public boolean hasChanged(int id) {
        double currentValue = get();
        Double lastValue = lastHasChangedValues.get(id);
        
        if (lastValue == null || currentValue != lastValue) {
            lastHasChangedValues.put(id, currentValue);
            return true;
        }

        return false;
    }
    
    @Override
    public double getAsDouble(){
        return get();
    }

}
