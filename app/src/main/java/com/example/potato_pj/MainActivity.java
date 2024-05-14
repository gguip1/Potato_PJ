package com.example.potato_pj;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.potato_pj.API.API;
import com.example.potato_pj.API.APIController;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView test = (TextView) findViewById(R.id.test);

        Call<API[]> call = APIController.getTestCall("kpnovel",3, 8);
        call.enqueue(new Callback<API[]>() {
            @Override
            public void onResponse(Call<API[]> call, Response<API[]> response) {
                API[] result = response.body();
                for(int i = 0; i < result.length; i++){
                    test.append(result[i].toString());
                    Log.d("결과", "성공 : " + result[i].toString());
                }
            }

            @Override
            public void onFailure(Call<API[]> call, Throwable t) {
                Log.d("결과", "실패 : " + t.getMessage());
            }
        });
    }
}