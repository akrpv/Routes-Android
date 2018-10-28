package xxx_pro_team_crazy_guys.routes;

import java.util.ArrayList;
import java.util.List;

import xxx_pro_team_crazy_guys.routes.dto.Place;

/**
 * Created by lexay on 27.10.2018.
 */

public class GlobalVars {
    public static String url = "http://192.168.137.1:8080/";
    public static int pointsNumber = 2;
    public static void changePointsNumber(int n){
        pointsNumber += n;
    }
    public static List<Place> places = new ArrayList<>();
    public static double startX = 59.9678976;
    public static double startY = 30.3218688;
}
