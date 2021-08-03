 package com.example.retrofitand3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitand3.data.model.ActivityesModel;
import com.example.retrofitand3.data.model.FilmApi;
import com.example.retrofitand3.data.model.remote.RetrofitBuilder;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {
   List<Float>list = new ArrayList<>();
    Slider slider ;
    TextView textPrice ;
    TextView textFree ;
    TextView category ;
    TextView textshow ;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        initView();

//        RetrofitBuilder.getInstance().getActivityes().enqueue(new Callback<List<ActivityesModel>>() {
//            @Override
//            public void onResponse(Call<List<ActivityesModel>> call, Response<List<ActivityesModel>> response) {
//                if (response.isSuccessful()&& response.body() !=null){
//                    Log.d("tag",response.body().toString());
//                    for (ActivityesModel activityesModel: response.body()){
//                        Log.d("tag",activityesModel.toString()+"\n");
//                    }
//                }else {
//                    Log.d("tag","Error:"+response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ActivityesModel>> call, Throwable t) {
//           Log.d("tag",t.getLocalizedMessage());
//            }
//        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitBuilder.getInstance().getPrice(0.5).enqueue(new Callback<ActivityesModel>() {
                    @Override
                    public void onResponse(Call<ActivityesModel> call, Response<ActivityesModel> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("tag", "success: " + response.body().getActivityes());

                            // Log.d("tag", "success: " + response.body().getActivities());
                            category.setText(response.body().getActivityes());
                            textPrice.setText(String.valueOf(response.body().getPrice()) + " $");

                        } else {
                            Log.d("tag", "erorr: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<ActivityesModel> call, Throwable t) {
                        Log.d("tag","fail"+ t.getLocalizedMessage());
                    }
                });
            }
        });
    }


    private void initView() {
        textFree =  findViewById(R.id.text_free);
        slider =  findViewById(R.id.slider);
        slider = findViewById(R.id.slider2);
        textPrice =  findViewById(R.id.text_price);
        category =  findViewById(R.id.text_cafegory);
        textshow =  findViewById(R.id.text_show);
        next = findViewById(R.id.button_next);

    }
}
