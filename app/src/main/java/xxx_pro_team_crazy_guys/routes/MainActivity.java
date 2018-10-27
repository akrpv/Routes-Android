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


import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements OnTaskCompleted{
    CheckConnectionTask task;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView)findViewById(R.id.textView2);
        myTextView.setText("DAROW PACAN");

        TextView myTextView3 = (TextView)findViewById(R.id.textView3);
        myTextView.setText(GlobalVars.url);

    }

//    public void onClickButton(View view){
//        CheckConnectionTask checkTask = new CheckConnectionTask(this);
//        checkTask.execute("");
//        task = checkTask;
//    }
    public void onClickButton(View view){
         Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTaskCompleted() throws ExecutionException, InterruptedException {
        JSONObject result = task.get();
        TextView textView3;
        textView3 = (TextView) findViewById(R.id.textView3);
        try {
            res = result.getString("Status");
            textView3.setText(res);
        } catch (JSONException e) {
            e.printStackTrace();
        }

       // Intent intent = new Intent(this,ChoiceAvtivity.class);
        //startActivity(intent);
    }
}
