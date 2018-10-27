package xxx_pro_team_crazy_guys.routes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xxx_pro_team_crazy_guys.routes.connectivity.Categories;
import xxx_pro_team_crazy_guys.routes.connectivity.CategoriesMock;

public class ChoiceAvtivity extends AppCompatActivity {
    private final Categories categories = new CategoriesMock();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_avtivity);
    }
}
