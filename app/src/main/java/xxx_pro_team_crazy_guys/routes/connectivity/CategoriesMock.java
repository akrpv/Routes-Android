package xxx_pro_team_crazy_guys.routes.connectivity;

import xxx_pro_team_crazy_guys.routes.dto.Category;
import java.util.Arrays;
import java.util.List;

public class CategoriesMock implements Categories {

    @Override
    public List<Category> getCategories() {
        return Arrays.asList(
                new Category(1, "Bar", 90),
                new Category(2, "Cinema", 90),
                new Category(3, "Museum", 120),
                new Category(4, "Theatre", 120),
                new Category(5, "Gallery", 90),
                new Category(6, "Cafe", 40)
        );
    }
}
