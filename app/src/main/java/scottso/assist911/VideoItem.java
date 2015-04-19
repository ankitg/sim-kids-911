package scottso.assist911;

import java.io.Serializable;

/**
 * Created by ankitg on 2015-04-14.
 */
public class VideoItem  implements Serializable {
    public String title;
    public String videoName;
    public Boolean isEmergency;
    public emergencyType type;

    public VideoItem(String title, String videoName, Boolean isEmergency, emergencyType type) {
        this.title = title;
        this.videoName = videoName;
        this.isEmergency = isEmergency;
        this.type = type;
    }

    public enum emergencyType {
        FIRE,
        POLICE,
        AMBULANCE,
        NONE
    }
}
