package xxx_pro_team_crazy_guys.routes.connectivity;

import xxx_pro_team_crazy_guys.routes.dto.Place;
import java.util.List;

public interface Routes {

    List<Place> getPlaces(int x, int y, int time, int[] categoryIds);
}
