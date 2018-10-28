package xxx_pro_team_crazy_guys.routes;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xxx_pro_team_crazy_guys.routes.connectivity.Categories;
import xxx_pro_team_crazy_guys.routes.connectivity.CategoriesMock;
import xxx_pro_team_crazy_guys.routes.dto.Category;

public class ChoiceAvtivity extends AppCompatActivity {
    private final Categories categories = new CategoriesMock();

    OkHttpClient client = new OkHttpClient();

    private String res;
    TextView txtString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_avtivity);

        List<Category> categoriesList = categories.getCategories();
        String[] categArray = new String[categoriesList.size()];
        for (int i = 0; i < categArray.length; i++) {
            categArray[i] = categoriesList.get(i).getName();
        }
        //adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setAdapter(adapter);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner4.setAdapter(adapter);


        //categoriesList.size(); kolvo
//        for (Category cat: categoriesList) {
//            cat
//        }

    }

    public void onClickButton3(View view){
        GlobalVars.changePointsNumber(1);
        if (GlobalVars.pointsNumber==3){
            Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
            spinner2.setVisibility(View.VISIBLE);
        }
        if (GlobalVars.pointsNumber==4){
            Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
            spinner3.setVisibility(View.VISIBLE);
        }
        if (GlobalVars.pointsNumber==5){
            Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
            spinner4.setVisibility(View.VISIBLE);
        }
    }

    public void onClickButton4(View view){
//        Intent intent = new Intent(this, MapsActivity.class);
//        startActivity(intent);
        String start = "59.9678976,30.3218688";



        OkHttpHandler okHttpHandler= new OkHttpHandler(this);
        okHttpHandler.execute(GlobalVars.url+"check-connection");
    }

    public class OkHttpHandler extends AsyncTask<String, Integer, String> {

        OkHttpClient client = new OkHttpClient();
        ChoiceAvtivity choiceAvtivity;

        public OkHttpHandler(ChoiceAvtivity choiceAvtivity) {
            this.choiceAvtivity = choiceAvtivity;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //txtString.setText(s);
            //Intent intent = new Intent(choiceAvtivity, ChoiceAvtivity.class);
            //startActivity(intent);

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


}
