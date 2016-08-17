package ru.axelofan.excusegenerator.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.axelofan.excusegenerator.R;
import ru.axelofan.excusegenerator.utils.ExcuseGenerator;

public class GeneratorActivity extends AppCompatActivity {

    private TextView excuseText;
    private Button excuseButton,copyButton;
    private EditText nameText;
    private ExcuseGenerator generator = new ExcuseGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        excuseText = (TextView) findViewById(R.id.excuse_text);
        excuseButton = (Button) findViewById(R.id.excuse_button);
        copyButton = (Button) findViewById(R.id.copy_button);
        nameText = (EditText) findViewById(R.id.name_text);

        excuseButton.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        copyButton.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);

        excuseText.setText(generator.getExcuse(nameText.getText().toString()));
        excuseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excuseText.setText(generator.getExcuse(nameText.getText().toString()));
            }
        });
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("excuse",excuseText.getText().toString());
                clipboard.setPrimaryClip(clip);
            }
        });
    }
}
