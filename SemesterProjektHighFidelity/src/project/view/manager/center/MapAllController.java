package project.view.manager.center;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;
import project.MainManager;
import project.view.AnimationHelper;
import project.view.manager.HouseOverviewLeftMenuController;
import project.view.manager.OpenCloseAnimated;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public class MapAllController implements OpenCloseAnimated, MapComponentInitializedListener {

    GoogleMapView mapView;
    GoogleMap map;

    MainManager root;
    @FXML
    Node node;

    public static LatLong getLatLongPositions(String address) throws Exception // From https://stackoverflow.com/questions/18455394/java-function-that-accepts-address-and-returns-longitude-and-latitude-coordinate
    {
        int responseCode = 0;
        String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
        System.out.println("URL : " + api);
        URL url = new URL(api);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();
        responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(httpConnection.getInputStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/GeocodeResponse/status");
            String status = (String) expr.evaluate(document, XPathConstants.STRING);
            if (status.equals("OK")) {
                expr = xpath.compile("//geometry/location/lat");
                String latitude = (String) expr.evaluate(document, XPathConstants.STRING);
                expr = xpath.compile("//geometry/location/lng");
                String longitude = (String) expr.evaluate(document, XPathConstants.STRING);
                return new LatLong(Double.parseDouble(latitude), Double.parseDouble(longitude));
            } else {
                throw new Exception("Error from the API - response status: " + status);
            }
        }
        return null;
    }

    public void setRoot(MainManager root) {
        this.root = root;
    }

    @Override
    public void mapInitialized() {
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(56.1351841, 8.1906375)).zoom(4).overviewMapControl(false).panControl(false).rotateControl(false).scaleControl(false).streetViewControl(false).zoomControl(false).mapType(MapTypeIdEnum.ROADMAP);


        map = mapView.createMap(mapOptions);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("House 1");
        Marker testMarker = new Marker(markerOptions);
        try {
            testMarker.setPosition(getLatLongPositions("Nr. Lyndelsevej 2, Odense"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.addMarker(testMarker);
        map.addUIEventHandler(testMarker, UIEventType.click, new UIEventHandler() {
            @Override
            public void handle(JSObject jsObject) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HouseOverview.fxml"));
                try {
                    Node node = loader.load();
                    HouseOverviewController controller = loader.getController();

                    controller.setRoot(root);
                    controller.setHouse(root.getHouses().get(0));

                    root.setContent(controller, node);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                loader = new FXMLLoader(getClass().getResource("/project/view/manager/HouseOverviewLeftMenu.fxml"));
                try {
                    Node node = loader.load();
                    ((HouseOverviewLeftMenuController) loader.getController()).root = root;
                    ((HouseOverviewLeftMenuController) loader.getController()).selectButton(((HouseOverviewLeftMenuController) loader.getController()).buttons.get(0));
                    ((HouseOverviewLeftMenuController) loader.getController()).setHouse(root.getHouses().get(0));
                    root.setLeftMenu(loader.getController(), node);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                root.getUpperMenu().textClicked(null);
            }
        });
    }

    @FXML
    private void initialize() {
        AnimationHelper.initializeSlideFadeFromRight(node);
        mapView = new GoogleMapView();
        mapView.addMapInializedListener(this);
        ((BorderPane) node).setCenter(mapView);
    }

    @Override
    public void openNode() {
        AnimationHelper.slideFadeInFromRight(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideFadeOutToRight(node);
    }
}


