package com.example.sujay.myapplication;
import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.call.Call;
import com.plivo.helper.exception.PlivoException;


import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    private class CallAPI extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... param) {
            String ph = param[0];
            RestAPI restAPI = new RestAPI("MAMDJHZJGWZTKXMTQYOD", "ZDU1OWNkZDZkODYyYzdjOWNmNWJjYzRkYzYyMTVm", "v1");

            LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
            params.put("from", "918277531975");
            params.put("to", ph);
            params.put("answer_url", "http://abdd5e93.ngrok.io/direct-dial.xml");

            Call response;
            try {

                response = restAPI.makeCall(params);
                System.out.println(response.message);
            } catch (PlivoException e) {
                System.out.println(e.getMessage());
            }
            return "";

        }
    }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button callbutton = (Button) findViewById(R.id.button);
            callbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText number = (EditText) findViewById(R.id.editText);
                    String phonenumber = number.getText().toString();
                    new CallAPI().execute(phonenumber);



                }
            });

        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }

