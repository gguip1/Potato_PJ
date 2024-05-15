package com.example.potato_pj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.potato_pj.API.API;
import com.example.potato_pj.API.APIController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView iv_image;

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

        iv_image = (ImageView) findViewById(R.id.imageView);

        Call<API[]> call = APIController.getTestCall("movie_test",4, 3);
        call.enqueue(new Callback<API[]>() {
            @Override
            public void onResponse(Call<API[]> call, Response<API[]> response) {
                API[] result = response.body();
//                for(int i = 0; i < result.length; i++){
//                    test.append(result[i].toString());
//                    Log.d("결과", "성공 : " + result[i].toString());
//                }
                Log.d("img_link", "img_link : " + result[1].getImg());
                test.append(result[1].getTitle());
                new DownloadFilesTask().execute(result[1].getImg());
            }

            @Override
            public void onFailure(Call<API[]> call, Throwable t) {
                Log.d("결과", "실패 : " + t.getMessage());
            }
        });
    }

    private class DownloadFilesTask extends AsyncTask<String,Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp = null;
            try {
                String img_url = strings[0]; //url of the image
                URL url = new URL(img_url);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Bitmap result) {
            // doInBackground 에서 받아온 total 값 사용 장소
            iv_image.setImageBitmap(result);
        }
    }
}