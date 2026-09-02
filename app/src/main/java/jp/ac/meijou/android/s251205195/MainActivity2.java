package jp.ac.meijou.android.s251205195;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Optional;

import jp.ac.meijou.android.s251205195.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s251205195.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 明示的インデントが押された時
        binding.buttonA.setOnClickListener(view->{
            var intent = new Intent(this,MainActivity3.class);
            startActivity(intent);
        });

        // 暗黙的インデントが押された時
        binding.buttonB.setOnClickListener(view->{
            var intent = new Intent();
            intent.setAction(intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.yahoo.co.jp"));
            startActivity(intent);
        });

        // Intent_buttonが押された時
        binding.intentButton.setOnClickListener(view->{
            String sentText = binding.intentEditText.getText().toString();

            var intent = new Intent(this, MainActivity3.class);
            intent.putExtra("editText",sentText);
            startActivity(intent);

        });

        // Action Buttonが押された時
        binding.actionButton.setOnClickListener(view ->{
            var intent = new Intent(this, MainActivity3.class);
            getActivityResult.launch(intent);
        });
    }


    //ActivityResultLauntcherはonCreateの外に置く
    private final ActivityResultLauncher<Intent> getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()) {
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result : " + text)
                                .ifPresent(text -> binding.intentTextView.setText(text));
                        break;
                    case RESULT_CANCELED:
                        binding.intentTextView.setText("Result : Canceled");
                        break;
                    default:
                        binding.intentTextView.setText("Result : unknown(" + result.getResultCode() + ")");
                        break;

                }
            }
    );
}