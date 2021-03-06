package scottso.assist911.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import scottso.assist911.R;
import scottso.assist911.SimKidsActivity;
import scottso.assist911.SimKidsApplication;
import scottso.assist911.VideoItem;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainMenuActivity extends SimKidsActivity implements View.OnClickListener{

    private Button mPractiseButton;
    private Button mVideosButton;

    public static int NUM_TRIES = 0;
    public static int TIMES_COMPLETED;
    public static int CURRENT_TRY_SCORE;
    public static boolean IS_REMOVE_TEXT_PROMPT = false;
    public static boolean IS_REMOVE_AUDIO_PROMPT = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainmenu);

        mPractiseButton = (Button) this.findViewById(R.id.practice_button);
        mPractiseButton.setOnClickListener(this);

        mVideosButton = (Button) this.findViewById(R.id.videos_button);
        mVideosButton.setOnClickListener(this);

        TIMES_COMPLETED = LoginActivity.PREF.getInt(LoginActivity.TIMES_COMPLETED, 0);
        IS_REMOVE_TEXT_PROMPT = LoginActivity.PREF.getBoolean(LoginActivity.REMOVE_TEXT_PROMPT, false);
        IS_REMOVE_AUDIO_PROMPT = LoginActivity.PREF.getBoolean(LoginActivity.REMOVE_AUDIO_PROMPT, false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.practice_button:
                CURRENT_TRY_SCORE = 0;
                LoginActivity.EDITOR.putInt(LoginActivity.CURRENT_TRY_SCORE, CURRENT_TRY_SCORE);
                LoginActivity.EDITOR.commit();

                int index = new Random().nextInt(((SimKidsApplication) getApplication()).getVideos().size());
                VideoItem selectedItem = ((SimKidsApplication) getApplication()).getVideos().get(index);
                goToVideoPlayer(selectedItem);
                break;

            case R.id.videos_button:
                goToVideos();
                System.out.println(LoginActivity.PREF.getInt(LoginActivity.TIMES_COMPLETED, 0));
                break;
        }
    }

    public void goToVideos() {
        Intent video = new Intent(this, VideosActivity.class);
        startActivity(video);
    }

    public void goToVideoPlayer(VideoItem video) {
        Intent videoPlayer = new Intent(this, PracticePlayVideoActivity.class);
        videoPlayer.putExtra("selectedVideo", (java.io.Serializable) video);
        startActivity(videoPlayer);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new CalligraphyContextWrapper(newBase));
    }

    @Override public void onBackPressed(){ moveTaskToBack(true); }
}