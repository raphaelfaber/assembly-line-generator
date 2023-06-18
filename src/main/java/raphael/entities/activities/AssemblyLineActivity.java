package raphael.entities.activities;

import java.util.UUID;

public class AssemblyLineActivity implements ActivityDurationCalculable{
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
}
