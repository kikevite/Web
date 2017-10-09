package edu.upc.eseiaat.pma.web;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {
    private EditText editTextURL;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextURL = (EditText) findViewById(R.id.editText);
        textViewResult = (TextView) findViewById(R.id.textView);
    }

    public void connect(View view) {
        String url = editTextURL.getText().toString();
        WebReaderTask wrTask = new WebReaderTask();
        wrTask.execute(url);
    }

    private class WebReaderTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... url) {
            return WebReader.getURL(url[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            textViewResult.setText(s);
        }

    }
}
