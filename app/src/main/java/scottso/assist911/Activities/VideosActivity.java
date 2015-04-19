package scottso.assist911.Activities;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import scottso.assist911.R;
import scottso.assist911.SimKidsActivity;
import scottso.assist911.SimKidsApplication;
import scottso.assist911.VideoItem;

public class VideosActivity extends SimKidsActivity //implements AdapterView.OnItemSelectedListener
{

    public static String VIDEO_NAME;

    public static Boolean EMERGENCY;
    public static Boolean FIRE = false;
    public static Boolean POLICE = false;
    public static Boolean AMBULANCE = false;

    private ListView videosList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);


        videosList = (ListView) findViewById(R.id.list_videos_modeling);
        videosList.setAdapter(new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public boolean isEnabled(int position) {
                return true;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return ((SimKidsApplication) getApplication()).getVideos().size();
            }

            @Override
            public VideoItem getItem(int position) {
                return ((SimKidsApplication) getApplication()).getVideos().get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;

                if (v == null) {

                    LayoutInflater vi;
                    vi = LayoutInflater.from(VideosActivity.this);
                    v = vi.inflate(R.layout.list_item_video, null);

                }

                VideoItem p = getItem(position);

                if (p != null) {

                    TextView tvVideoTitle = (TextView) v.findViewById(R.id.listrow_text_videolist);
                    tvVideoTitle.setText(p.title);
                }

                return v;

            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        });

        videosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VIDEO_NAME = ((SimKidsApplication) getApplication()).getVideos().get(position).videoName;
                goToVideoPlayer();
            }
        });
    }

    public void goToVideoPlayer() {
        Intent videoPlayer = new Intent(this, PlayVideoActivity.class);
        videoPlayer.putExtra("videoName",VIDEO_NAME);
        startActivity(videoPlayer);
        finish();
    }
}