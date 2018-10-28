package xxx_pro_team_crazy_guys.routes;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xxx_pro_team_crazy_guys.routes.dto.Place;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private List<LatLng> places = new ArrayList<>();
    private GoogleMap mMap;
    private int width;

    private String mapsApiKey = "AIzaSyAuZwKDCKJivynUl8yh3zx1A_W0aT1pBOA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        for (Place place : GlobalVars.places){
            places.add(new LatLng(place.getX(),place.getY()));
        }

//        places.add(new LatLng(55.754724, 37.621380));
//        places.add(new LatLng(55.760133, 37.618697));
//        places.add(new LatLng(55.764753, 37.591313));
//        places.add(new LatLng(55.728466, 37.604155));

        //mapsApiKey = this.getResources().getString(R.string.google_maps_key);
        width = getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MarkerOptions[] markers = new MarkerOptions[places.size()];
        for (int i = 0; i < places.size(); i++) {
            markers[i] = new MarkerOptions()
                    .position(new com.google.android.gms.maps.model.LatLng(places.get(i).lat, places.get(i).lng));
            googleMap.addMarker(markers[i]);
        }


        GeoApiContext geoApiContext = new GeoApiContext.Builder()
                .apiKey(mapsApiKey)
                .build();
        DirectionsResult result = null;
        try {
            result = DirectionsApi.newRequest(geoApiContext)
                    .mode(TravelMode.WALKING)
                    .origin(places.get(0))
                    .destination(places.get(places.size() - 1))
                    .waypoints(places.get(1), places.get(2)).await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<com.google.maps.model.LatLng> path = result.routes[0].overviewPolyline.decodePath();
        PolylineOptions line = new PolylineOptions();

        LatLngBounds.Builder latLngBuilder = new LatLngBounds.Builder();

        for (int i = 0; i < path.size(); i++) {
            line.add(new com.google.android.gms.maps.model.LatLng(path.get(i).lat, path.get(i).lng));
            latLngBuilder.include(new com.google.android.gms.maps.model.LatLng(path.get(i).lat, path.get(i).lng));
        }

        line.width(16f).color(R.color.colorPrimary);

        googleMap.addPolyline(line);

        LatLngBounds latLngBounds = latLngBuilder.build();
        CameraUpdate track = CameraUpdateFactory.newLatLngBounds(latLngBounds, width, width, 25);
        googleMap.moveCamera(track);
    }






//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        places.add(new LatLng(55.754724, 37.621380));
//        places.add(new LatLng(55.760133, 37.618697));
//        places.add(new LatLng(55.764753, 37.591313));
//        places.add(new LatLng(55.728466, 37.604155));
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//
//
//        width = getResources().getDisplayMetrics().widthPixels;
//
//
//    }
//
//
//    @Override
//    public void onMapReady(GoogleMap googleMap)  {
//        mMap = googleMap;
//        MarkerOptions[] markers = new MarkerOptions[places.size()];
////        for (int i = 0; i < places.size(); i++) {
////            markers[i] = new MarkerOptions()
////                    .position(places.get(i));
////            googleMap.addMarker(markers[i]);
////        }
//
//        for (int i = 0; i < places.size(); i++) {
//            markers[i] = new MarkerOptions()
//                    .position(new com.google.android.gms.maps.model.LatLng(places.get(i).lat, places.get(i).lng));
//            googleMap.addMarker(markers[i]);
//        }
//
//        String mapsApiKey = "AIzaSyAuZwKDCKJivynUl8yh3zx1A_W0aT1pBOA";
//
//        //Получаем контекст для запросов, mapsApiKey хранит в себе String с ключом для карт
//        GeoApiContext geoApiContext = new GeoApiContext.Builder()
//                .apiKey(mapsApiKey)
//                .build();
//
////Здесь будет наш итоговый путь состоящий из набора точек
//        DirectionsResult result = null;
//        try {
//            result = DirectionsApi.newRequest(geoApiContext)
//                    .origin(places.get(0))//Место старта
//                    .destination(places.get(places.size() - 1))//Пункт назначения
//                    .waypoints(places.get(1), places.get(2)).await();//Промежуточные точки. Да, не очень красиво, можно через цикл, но зато наглядно
//        } catch (ApiException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////Преобразование итогового пути в набор точек
//        List<com.google.maps.model.LatLng> path = result.routes[0].overviewPolyline.decodePath();
//
////Линия которую будем рисовать
//        PolylineOptions line = new PolylineOptions();
//
//        LatLngBounds.Builder latLngBuilder = new LatLngBounds.Builder();
//
////Проходимся по всем точкам, добавляем их в Polyline и в LanLngBounds.Builder
//        for (int i = 0; i < path.size(); i++) {
//            line.add(new com.google.android.gms.maps.model.LatLng(path.get(i).lat, path.get(i).lng));
//            latLngBuilder.include(new com.google.android.gms.maps.model.LatLng(path.get(i).lat, path.get(i).lng));
//        }
//
////Делаем линию более менее симпатичное
//        line.width(16f).color(R.color.colorPrimary);
//
////Добавляем линию на карту
//        googleMap.addPolyline(line);
//
////Выставляем камеру на нужную нам позицию
//        LatLngBounds latLngBounds = latLngBuilder.build();
//        CameraUpdate track = CameraUpdateFactory.newLatLngBounds(latLngBounds, width, width, 25);//width это размер нашего экрана
//        googleMap.moveCamera(track);
//    }
}
