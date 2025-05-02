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
    private boolean hasDefault = false;
    private double defaultValue;
    private final DoubleEntry entry;
    private Map<Integer, Double> lastHasChangedValues = new HashMap<>();
    private double value;

    

    public TunableNumber(String key, double defaultValue){
        this.key = key;
        this.entry = NetworkTableInstance.getDefault().getDoubleTopic(key).getEntry(0.0);
        initDefault(defaultValue);
        this.value = defaultValue;
    }

    public void initDefault(double defaultValue){
        if (!hasDefault) {
            
            hasDefault = true;
            this.defaultValue = defaultValue; 
        }
    }

    public double get() {
        if (!hasDefault) {
            return 0.0;
        } else {
            return value;
        }
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
    
      /**
   * Runs action if any of the tunableNumbers have changed
   *
   * @param id Unique identifier for the caller to avoid conflicts when shared between multiple *
   *     objects. Recommended approach is to pass the result of "hashCode()"
   * @param action Callback to run when any of the tunable numbers have changed. Access tunable
   *     numbers in order inputted in method
   * @param tunableNumbers All tunable numbers to check
   */
    public static void ifChanged(
        int id, Consumer<double[]> action, TunableNumber... tunableNumbers) {
        if (Arrays.stream(tunableNumbers).anyMatch(tunableNumber -> tunableNumber.hasChanged(id))) {
            action.accept(Arrays.stream(tunableNumbers).mapToDouble(TunableNumber::get).toArray());
        }
    }

    /** Runs action if any of the tunableNumbers have changed */
    public static void ifChanged(int id, Runnable action, TunableNumber... tunableNumbers) {
        ifChanged(id, values -> action.run(), tunableNumbers);
    }

    public double getAsDouble(){
        return get();
    }

}
