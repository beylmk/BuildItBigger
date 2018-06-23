package udacity.maddie.jokedisplayer;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends Activity {

    public static final String JOKE_ID = "joke";

    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if (getIntent().hasExtra(JOKE_ID)) {
            joke = getIntent().getStringExtra(JOKE_ID);
            TextView jokeTextView = findViewById(R.id.joke_text_view);
            jokeTextView.setText(joke);
        } else {
            Toast.makeText(this, Toast.LENGTH_LONG, R.string.trouble_getting_joke).show();
        }
    }
}
