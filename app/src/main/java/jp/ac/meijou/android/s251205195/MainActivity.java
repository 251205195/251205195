package jp.ac.meijou.android.s251205195;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;

import jp.ac.meijou.android.s251205195.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; //演習3
    private PrefDataStore prefDataStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);



        binding = ActivityMainBinding.inflate(getLayoutInflater()); //演習3
        setContentView(binding.getRoot()); //演習3
        prefDataStore = PrefDataStore.getInstance(this);

        prefDataStore.getString("name")
                .ifPresent(name -> {
                    if ("a".equals(name)) {
                        binding.day2.setText("成功");
                        binding.imageView.setImageResource(R.drawable.outline_boy_24);
                    } else {
                        binding.day2.setText(name);
                    }
                });

//デバッグ用コード
//        prefDataStore.getString("name")
//                .ifPresent(name -> {
//                    var modText = "(pref)" + name;
//                    Log.d("meijo",modText);
//                    binding.day2.setText(modText);
//                        });


        binding.buttonSave.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name", text);
        });

        binding.buttonSave.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name", text);
        });

//        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        TextView text = findViewById(R.id.day2);
//        text.setText(R.string.test2);

//        binding.day2.setText(R.string.test); //演習3


        binding.buttonChange.setOnClickListener(view -> {
            String text = binding.editTextText.getText().toString();
            binding.day2.setText(text);
        });


        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();
                binding.day2.setText(text);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }


}

