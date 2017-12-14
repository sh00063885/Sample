package sample.masaibar.filtersample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAddFilter = (Button) findViewById(R.id.ButtonAddFilter);
        buttonAddFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilterService.class);
                startService(intent);
            }
        });

        Button buttonRemoveFilter = (Button) findViewById(R.id.ButtonRemoveFilter);
        buttonRemoveFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilterService.class);
                stopService(intent);
            }
        });
    }
}
