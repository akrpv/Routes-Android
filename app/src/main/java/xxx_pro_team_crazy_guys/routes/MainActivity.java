package xxx_pro_team_crazy_guys.routes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mashape.unirest.http.*;
import org.json.*;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static xxx_pro_team_crazy_guys.routes.GlobalVars.url;

public class MainActivity extends AppCompatActivity //implements OnTaskCompleted
{
    OkHttpClient client = new OkHttpClient();//+
    CheckConnectionTask task;
    private String res;
    TextView txtString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView)findViewById(R.id.textView2);
        myTextView.setText("DAROW PACAN");

        TextView myTextView3 = (TextView)findViewById(R.id.textView3);
        myTextView.setText(url);

    }

//    public void onClickButton(View view){
//        CheckConnectionTask checkTask = new CheckConnectionTask(this);
//        checkTask.execute("");
//        task = checkTask;
//    }
    public void onClickButton(View view) throws IOException {
        //TextView textView3;
        txtString = (TextView) findViewById(R.id.textView3);

        OkHttpHandler okHttpHandler= new OkHttpHandler(this);//+
        okHttpHandler.execute(url+"check-connection");//+

//        if (txtString.getText().toString().equals("200")){
//            Intent intent = new Intent(this,ChoiceAvtivity.class);
//            startActivity(intent);
//        }

//         Intent intent = new Intent(this,MapsActivity.class);
//        startActivity(intent);

    }
    public void onClickButton2(View view){
        Intent intent = new Intent(this,ChoiceAvtivity.class);
          startActivity(intent);
    }

    public class OkHttpHandler extends AsyncTask<String, Integer, String> {

        OkHttpClient client = new OkHttpClient();
        MainActivity mainActivity;

        public OkHttpHandler(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtString.setText(s);
            Intent intent = new Intent(mainActivity, ChoiceAvtivity.class);
            startActivity(intent);

        }

        //возварщает response
        @Override
        protected String doInBackground(String... params) {

            Request.Builder builder = new Request.Builder();
            builder.url(params[0]);
            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();

                return String.valueOf(response.networkResponse().code());
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }

//    @Override
//    public void onTaskCompleted() throws ExecutionException, InterruptedException {
//        JSONObject result = task.get();
//        TextView textView3;
//        textView3 = (TextView) findViewById(R.id.textView3);
//        try {
//            res = result.getString("Status");
//            textView3.setText(res);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//       // Intent intent = new Intent(this,ChoiceAvtivity.class);
//        //startActivity(intent);
//    }
}
