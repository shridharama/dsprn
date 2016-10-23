package helpers;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by achint on 10/23/16.
 */

public class GetHelper extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params){
            //Your network connection code should be here .
            return getCall();

        }

        @Override
        protected void onPostExecute(String result) {
            //Print your response here .
            Log.d("Post Response",result);

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}

        public  String  getCall()
        {


            JSONObject data = new JSONObject();
            String time = Long.toString(System.currentTimeMillis());

            BufferedReader reader=null;

            // Send data
            try
            {

                // Defined URL  where to send data
                URL url = new URL("http://shylockservice.cfapps.io/api/v1.0/getLiveHeatMap");

                // Send POST data request

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestMethod("GET");

                //add request header
                conn.connect();
                int responseCode = conn.getResponseCode();
                StringBuffer response = new StringBuffer();
                if (responseCode == HttpURLConnection.HTTP_OK){
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    String inputLine;


                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();


                }
                return response.toString();
            }
            catch(Exception ex)
            {
                //return "exception "+ex.toString();
            }
            finally
            {
                try
                {

                    reader.close();
                }

                catch(Exception ex) {}
            }
            return "None";

        }

    }

