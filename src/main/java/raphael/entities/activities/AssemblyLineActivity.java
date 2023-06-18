package raphael.entities.activities;

import raphael.interfaces.ActivityListable;

import java.util.HashSet;
import java.util.UUID;

public class AssemblyLineActivity implements ActivityListable {
    private static HashSet<AssemblyLineActivity> activitiesAlreadyAssigned = new HashSet<AssemblyLineActivity>();
    public static final int ACTIVITY_MAINTENANCE_DURATION_IN_MINUTES = 5;
    String id;
    int durationInMinutes;
    String activityDescription;


    public AssemblyLineActivity(int durationInMinutes, String activityDescription){
        this.id = UUID.randomUUID().toString();
        this.durationInMinutes = durationInMinutes;
        this.activityDescription = activityDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public String getDescription() {
        return  this.activityDescription;
    }

    public boolean isThisActivityAlreadyAssigned(){
        return activitiesAlreadyAssigned.contains(this);
    }
    public void assignThisActivity(){
        activitiesAlreadyAssigned.add(this);
    }
}
