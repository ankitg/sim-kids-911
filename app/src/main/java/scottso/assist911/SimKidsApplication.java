package scottso.assist911;

import android.app.Application;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SimKidsApplication extends Application{

    private static ArrayList<VideoItem> videosArray = new ArrayList<VideoItem>();

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault("fonts/Montserrat-Regular.ttf");
        populateVideosArray();
    }

    private void populateVideosArray() {
        videosArray.add(new VideoItem("Instructional Video", "instructional", false, VideoItem.emergencyType.NONE));
        videosArray.add(new VideoItem("Flames", "flame", true, VideoItem.emergencyType.FIRE));
        videosArray.add(new VideoItem("Smoke", "smoke", true, VideoItem.emergencyType.FIRE));
        videosArray.add(new VideoItem("Car Thief", "car", true, VideoItem.emergencyType.POLICE));
        videosArray.add(new VideoItem("Passing Out", "passed", true, VideoItem.emergencyType.AMBULANCE));
        videosArray.add(new VideoItem("Drowning", "drowning", true, VideoItem.emergencyType.AMBULANCE));
        videosArray.add(new VideoItem("Children Biking", "a", false, VideoItem.emergencyType.NONE));
        videosArray.add(new VideoItem("Family Playing Soccer", "b", false, VideoItem.emergencyType.NONE));
    }

    public static ArrayList<VideoItem> getVideos() {
        return videosArray;
    }
}
