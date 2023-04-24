package es.ieslavereda.myapplicationpreference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(view -> showPreferences());

    }

    private void showPreferences() {

        textView.setText(
                "EditTextPreference: " + MyPreferenceManager.getInstance(getApplicationContext()).getEditText() + "\n" +
                "CheckBox: " + MyPreferenceManager.getInstance(getApplicationContext()).getCheckbox() + "\n" +
                "SwitchPreference: " + MyPreferenceManager.getInstance(getApplicationContext()).getSwitchPreference()
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.settings:
                Intent intent = new Intent(this, PreferenceActivity.class);
                startActivity(intent);
                return true;

            case R.id.exit: finish();


            default: return super.onOptionsItemSelected(item);
        }
    }
}