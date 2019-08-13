package com.example.pushnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pushnotification.Model.UserResponse;
import com.example.pushnotification.Repository.ApiInterface;
import com.example.pushnotification.Repository.ClientApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    String token = null;
    ApiInterface apiInterface;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        button = findViewById(R.id.send_btn);
        getToken();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editName.getText().toString();
                apiInterface = ClientApi.getInstance().create(ApiInterface.class);
                Call<UserResponse> responseCall = apiInterface.getCall(name, token);
                responseCall.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        Toast.makeText(MainActivity.this, response.body().getResult(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Log.e("failure", t.getMessage());
                    }
                });

            }


        });
    }

    // get token  . . . . ;
    private void getToken() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.i("exception token", task.getException().getMessage());
                            token = null;
                        } else {
                            // Log.i("he",task.getResult().gettoken());
                            token = task.getResult().getToken();

                        }

                    }
                });

    }

    // for send name button  . . . . ;
}
