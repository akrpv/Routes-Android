package xxx_pro_team_crazy_guys.routes;

import android.os.AsyncTask;
import android.widget.EditText;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by lexay on 27.10.2018.
 */

class CheckConnectionTask extends AsyncTask<String, Void, JSONObject> {
    private OnTaskCompleted listener;
    //    private Exception exception;
    public CheckConnectionTask ( OnTaskCompleted listener){
        this.listener = listener;
    }

    protected JSONObject doInBackground(String... urls) {

        try {

            //String url = GlobalVars.url + "check-connection/";
            String url = "http://mail.ru";
            HttpRequestWithBody r = Unirest.post(url);
            HttpResponse<String> response = r
//                    .header()
//                    .body("Username=" + login.getText().toString() + "&Password=" + password.getText().toString())
                    .asString();
            String bodyString = response.getBody();
            JSONObject json = new JSONObject(bodyString);

            return json;
        }
        catch(Exception e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    protected void onPostExecute(JSONObject feed) {
        try {
            listener.onTaskCompleted();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}