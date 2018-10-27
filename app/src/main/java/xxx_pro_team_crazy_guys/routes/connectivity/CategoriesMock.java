package xxx_pro_team_crazy_guys.routes.connectivity;

import xxx_pro_team_crazy_guys.routes.dto.Category;
import java.util.Arrays;
import java.util.List;

public class CategoriesMock implements Categories {

    @Override
    public List<Category> getCategories() {
        Category category1 = new Category(1, "1", 1);
        Category category2 = new Category(2, "2", 2);
        return Arrays.asList(category1, category2);
    }
}
