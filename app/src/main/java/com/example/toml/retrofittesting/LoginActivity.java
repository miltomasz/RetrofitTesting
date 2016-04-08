package com.example.toml.retrofittesting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.toml.retrofittesting.client.LoginService;
import com.example.toml.retrofittesting.service.ServiceGenerator;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by toml on 08.04.16.
 */
public class LoginActivity extends Activity {

    // you should either define client id and secret as constants or in string resources
    private final String clientId = "your-client-id";
    private final String clientSecret = "your-client-secret";
    private final String redirectUri = "your://redirecturi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        ServiceGenerator.API_BASE_URL + "/login" + "?client_id=" + clientId + "&redirect_uri=" + redirectUri));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // the intent filter defined in AndroidManifest will handle the return from ACTION_VIEW intent
        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(redirectUri)) {
            // use the parameter your API exposes for the code (mostly it's "code")
            String code = uri.getQueryParameter("code");
            if (code != null) {
                // get access token
                LoginService loginService = ServiceGenerator.createService(LoginService.class, clientId, clientSecret);
                Call<AccessToken> call = loginService.getAccessToken(code, "authorization_code");
                try {
                    AccessToken accessToken = call.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (uri.getQueryParameter("error") != null) {
                // show an error message here
            }
        }
    }
}