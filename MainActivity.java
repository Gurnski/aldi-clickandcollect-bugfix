import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button inputButton;
    private Handler handler;
    private String scannedData;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        inputButton = findViewById(R.id.input_button);
        handler = new Handler();

        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processInput();
            }
        });

        // Simulate receiving scanned data
        scannedData = "SampleBarcodeData123"; // Replace this with data from the actual barcode scanner
        inputScannedData();
    }

    private void inputScannedData() {
        inputButton.setEnabled(false);
        currentIndex = 0;
        handler.postDelayed(inputRunnable, 50);
    }

    private final Runnable inputRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentIndex < scannedData.length()) {
                editText.append(String.valueOf(scannedData.charAt(currentIndex)));
                currentIndex++;
                handler.postDelayed(this, 50);
            } else {
                inputButton.setEnabled(true);
                // Simulate the button click after input completion
                inputButton.performClick();
            }
        }
    };

    private void processInput() {
        // Add your input processing logic here
        // e.g. store the data, perform a search, etc.
    }
}
