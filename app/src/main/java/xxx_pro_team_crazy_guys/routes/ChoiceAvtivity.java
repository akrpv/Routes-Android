package xxx_pro_team_crazy_guys.routes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import xxx_pro_team_crazy_guys.routes.connectivity.Categories;
import xxx_pro_team_crazy_guys.routes.connectivity.CategoriesMock;
import xxx_pro_team_crazy_guys.routes.dto.Category;

public class ChoiceAvtivity extends AppCompatActivity {
    private final Categories categories = new CategoriesMock();

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
    public void onClickButton4(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void onClickButton3(View view){
        GlobalVars.changePointsNumber(1);
        if (GlobalVars.pointsNumber==3){
            Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
            spinner2.setVisibility();

        }
    }
}
