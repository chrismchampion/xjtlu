package cn.edu.xjtlu.l15_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button searchBtn = findViewById(R.id.searchOracleBtn);
        final EditText searchStringField = findViewById(R.id.searchStringField);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String httpURL = "https://docs.oracle.com/apps/search/search.jsp?q="
                        + searchStringField.getText();
                TextView httpContent = findViewById(R.id.httpContent);
                httpContent.setText("Searching...");
                try {
                    URL url = new URL(httpURL);
                    QueryTask task = new QueryTask();
                    task.execute(url);
                } catch (MalformedURLException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    class QueryTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            if (urls.length == 0) { return null; }

            try {
                HttpURLConnection urlConn = (HttpURLConnection) urls[0].openConnection();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(urlConn.getInputStream()));
                String res = "", line = null;
                while ((line =  reader.readLine()) != null) {
                    res += line + '\n';
                }
                reader.close();
                urlConn.disconnect();
                return res;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            TextView httpContent = findViewById(R.id.httpContent);
            if (result != null) {
                httpContent.setText(result);
            } else {
                httpContent.setText("Failed to fetch search result");
            }
        }
    }
}


