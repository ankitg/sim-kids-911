package scottso.assist911.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import scottso.assist911.R;

public class ParentLoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);

        final Button createUserButton = (Button) findViewById(R.id.button_create_user_parent);
        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        final Button profileButton = (Button) findViewById(R.id.button_profile_parent);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProfile();
            }
        });

        final Button reportCardButton = (Button) findViewById(R.id.button_report_card_parent);
        reportCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showReportCard();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parent_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createUser() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void showProfile() {
        Intent settings = new Intent(this, ProfileActivity.class);
        startActivity(settings);
    }

    private void showReportCard() {
        Intent report = new Intent(this, ReportActivity.class);
        startActivity(report);
    }
}
