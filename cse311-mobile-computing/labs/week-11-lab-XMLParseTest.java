package cn.edu.xjtlu.l15_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class XMLParseTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlparse_test);
        new XMLQueryTask().execute();
    }

    class XMLQueryTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            System.out.println("do");
            try {
                URL url = new URL("http://api.geonames.org/earthquakes?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo");
                if (url != null) {
                    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document doc = dBuilder.parse(urlConn.getInputStream());
                    String str = "root node name is " + doc.getDocumentElement().getNodeName();
                    urlConn.disconnect();
                    return str;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = findViewById(R.id.XMLDisplay);
            textView.setText(result);
        }
    }
}
