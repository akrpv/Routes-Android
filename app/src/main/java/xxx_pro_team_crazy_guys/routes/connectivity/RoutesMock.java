package xxx_pro_team_crazy_guys.routes.connectivity;

import xxx_pro_team_crazy_guys.routes.dto.Place;
import java.util.Arrays;
import java.util.List;

public class RoutesMock implements Routes {
    @Override
    public List<Place> getPlaces(int x, int y, int time, int[] categoryIds) {
        return Arrays.asList(
                new Place(1, 1, 1, "1", 1),
                new Place(2, 2, 2, "2", 2)
        );
    }
}
