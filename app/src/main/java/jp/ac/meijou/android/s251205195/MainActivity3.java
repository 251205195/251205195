package jp.ac.meijou.android.s251205195;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s251205195.databinding.ActivityMain3Binding;


public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // intentを取得する
        Intent intent = getIntent();
        String sentText = intent.getStringExtra("editText");
        binding.textView.setText(sentText);

        // button_ok
        binding.buttonOk.setOnClickListener(view->{
            var ok_intent =new Intent();
            ok_intent.putExtra("ret","OK");
            setResult(RESULT_OK,ok_intent);
            finish();
        });

        // button_no
        binding.buttonNo.setOnClickListener(view->{
            setResult(RESULT_CANCELED);
            finish();
        });

        // 電卓の挙動
        binding.button0.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "0");
        });
        binding.button1.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "1");
        });
        binding.button2.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "2");
        });
        binding.button3.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "3");
        });
        binding.button4.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "4");
        });
        binding.button5.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "5");
        });
        binding.button6.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "6");
        });
        binding.button7.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "7");
        });
        binding.button8.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "8");
        });
        binding.button9.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "9");
        });
        binding.buttonAdd.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "+");
        });
        binding.buttonSub.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "-");
        });
        binding.buttonMul.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "×");
        });
        binding.buttonDiv.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "÷");
        });
        binding.buttonAc.setOnClickListener(view -> {
            binding.textView.setText("");
        });

        binding.buttonEqual.setOnClickListener(view -> {
            binding.textView.setText(binding.textView.getText() + "");
        });


    }
}