import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnGet = findViewById(R.id.button_get);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "on click", Toast.LENGTH_SHORT).show();
                Log.i("TAG", "on clicked");

                EditText editTextInput = findViewById(R.id.edit_input);
                String value = editTextInput.getText().toString();

                TextView tvResult = findViewById(R.id.text_result);
                tvResult.setText(value);
            }
        });
    }
}