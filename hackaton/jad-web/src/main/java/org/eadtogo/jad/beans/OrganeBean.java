package org.eadtogo.jad.beans;

import com.ngs.core.service.GenericServiceRemote;
import com.ngs.core.utils.LocationParam;
import com.ngs.core.web.beans.GenericBean;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.eadtogo.jad.entities.CategorieOrgane;
import org.eadtogo.jad.entities.Organe;
import org.eadtogo.jad.services.CategorieOrganeServiceRemote;
import org.eadtogo.jad.services.OrganeServiceRemote;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.json.JSONObject;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class OrganeBean extends GenericBean<Organe, Integer> {

    @EJB
    private OrganeServiceRemote organeService;
    @EJB
    private CategorieOrganeServiceRemote categorieOrganeServiceRemote;

    private Organe organe = new Organe();

    private MapModel geoModel;

    private String centerGeoMap = "41.850033, -87.6500523";

    private String latitude;

    private String longitude;

    private double lat;

    private double lng;

    private String title;

    private String recherche;

    private int filtreCategorie;

    private int filtreEtat;

    private int zoom = 7;

    private boolean jecherche = false;

    @PostConstruct
    @Override
    public void init() {
        this.entite = new Organe();
        this.organe = new Organe();

//        //Shared coordinates
//        LatLng coord1 = new LatLng(36.879466, 30.667648);
//        LatLng coord2 = new LatLng(36.883707, 30.689216);
//        LatLng coord3 = new LatLng(36.879703, 30.706707);
//        LatLng coord4 = new LatLng(36.885233, 30.702323);
//        
//
//        //Basic marker
//        geoModel.addOverlay(new Marker(coord1, "Konyaalti"));
//        geoModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
//        geoModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
//        geoModel.addOverlay(new Marker(coord4, "Kaleici"));
//        try {
//            this.latitude = this.userService.getUserLocationInfo(this.getClientIP(), LocationParam.latitude);
//            this.longitude = this.userService.getUserLocationInfo(this.getClientIP(), LocationParam.longitude);
//            LatLng coord1 = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
//            geoModel.addOverlay(new Marker(coord1, this.getAdress(latitude, longitude)));
//            centerGeoMap = this.latitude + "," + this.longitude;
//        } catch (NumberFormatException e) {
//        }
//
        System.out.println("centerGeoMap: " + centerGeoMap);
        this.listOrgane(false);
    }

    public void listOrgane(boolean filter) {
//        this.latitude = "6.205586";
//        this.longitude = "1.182387";
        this.latitude = "8.966317407128434";
        this.longitude = "1.1756769513600602";
        LatLng coord1 = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
        geoModel = new DefaultMapModel();
//        geoModel.addOverlay(new Marker(coord1, "", null,
//                "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        centerGeoMap = this.latitude + "," + this.longitude;
        List<Organe> list = this.organeService.getAll();
        System.out.println("listOrgane : " + list.size());

        if (filtreCategorie == 0 && filtreEtat == 0) {
            filter = false;
        }
        this.zoom = 7;

//        geoModel = new DefaultMapModel();
        for (Organe org : list) {

            LatLng coord = new LatLng(org.getLat(), org.getLng());
            Marker marker = new Marker(coord, this.organe.getNom(), org);
//            if (org.getEtat() == Organe.ETAT_VALIDE) {

            System.out.println("listOrgane  Marker data: " + (Organe) marker.getData());

            if (org.getEtat() == Organe.ETAT_EN_ATTENTE) {
                marker.setIcon("http://maps.google.com/mapfiles/ms/micons/yellow-dot.png");
            } else if (org.getEtat() == Organe.ETAT_VALIDE) {
                marker.setIcon("http://maps.google.com/mapfiles/ms/micons/green-dot.png");
            }

            if (filter) {
                if (filtreCategorie > 0 && filtreEtat > 0) {
                    if (org.getCategorieOrgane() == filtreCategorie && org.getEtat() == filtreEtat) {
                        geoModel.addOverlay(marker);
                    }
                }
            } else {
                geoModel.addOverlay(marker);
            }

        }

    }

    public void onGeocode(GeocodeEvent event) {
        List<GeocodeResult> results = event.getResults();
        System.out.println("onGeocode results : " + results.size());

        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
            this.zoom = 10;

            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress(),
                        null,
                        "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"
                ));

            }
        }
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        Marker marker = (Marker) event.getOverlay();
        try {
            this.entite = (Organe) marker.getData();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void organeBean(OverlaySelectEvent event) {
        Marker marker = (Marker) event.getOverlay();
        System.out.println("event.getComponent().getId(): " + event.getComponent().getId());
//        System.out.println("event.getComponent().getSource(): "+ (Marker) event.getSource());
        this.entite = (Organe) marker.getData();

    }

    public void addMarker() {
        System.out.println("addMarker: " + this.organe);
        Marker marker = new Marker(new LatLng(lat, lng), this.organe.getNom(), this.organe);
        if (this.organe.getCategorieOrgane() == Organe.CAT_EGLISE) {
            marker.setIcon("http://maps.google.com/mapfiles/ms/micons/green-dot.png");
        }
        if (this.organe.getCategorieOrgane() == Organe.CAT_ONG) {
            marker.setIcon("http://maps.google.com/mapfiles/ms/micons/blue-dot.png");
        }
        if (this.organe.getCategorieOrgane() == Organe.CAT_AUTRE) {
            marker.setIcon("http://maps.google.com/mapfiles/ms/micons/pink-dot.png");
        }

        this.organe.setConfession("");
        this.organe.setDoctrine("");
        this.organe = this.organeService.addOneImmediate(organe);

        geoModel.addOverlay(marker);

//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
//                this.organe.getNom(), "Position :" + this.organe.getLat() + ", " + this.organe.getLng()));
        this.init();
    }

    public String getClientIP() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        System.out.println("ipAddress:" + ipAddress);
        return ipAddress;
    }

    public void newOrgane() {
//        this.organe = this.entite;
    }

    public String obtainCategorie(Organe organe) {
        if (organe.getCategorieOrgane() == Organe.CAT_EGLISE) {
            return "Eglise: ";
        }
        if (organe.getCategorieOrgane() == Organe.CAT_ONG) {
            return "Mission: ";
        }
        return null;
    }

    public void activerOrgane(Organe organe) {
        organe = this.organeService.getOne(organe.getId());
        organe.setEtat(Organe.ETAT_VALIDE);
        this.organeService.updateOne(organe);
        this.listOrgane(false);
    }

    public void mettreEnAttente(Organe organe) {
        organe = this.organeService.getOne(organe.getId());
        organe.setEtat(Organe.ETAT_EN_ATTENTE);
        this.organeService.updateOne(organe);
        this.listOrgane(false);
    }

    public String getAdress(String lat, String lng) {
        try {

            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lng + "&sensor=true"
                    + "&key=AIzaSyD1ob9qjTRfRHHnslVJBjfaCcc8aJMxzFQ");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Accept-Charset", "UTF-8");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));

            String output;
            String jsonString = "";
            //System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                jsonString += output;
//                System.out.println(output);
            }
            JSONObject json = new JSONObject(jsonString);
            try {
                String adress = json.getJSONArray("results").getJSONObject(0).getString("formatted_address");
                //System.out.println(" adress: " + adress);
                return adress;
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public boolean isJecherche() {
        return jecherche;
    }

    public void setJecherche(boolean jecherche) {
        this.jecherche = jecherche;
    }

    public MapModel getGeoModel() {
        return geoModel;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRecherche() {
        return recherche;
    }

    public void setRecherche(String recherche) {
        this.recherche = recherche;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Organe getOrgane() {
        return organe;
    }

    public void setOrgane(Organe organe) {
        this.organe = organe;
    }

    @Override
    public GenericServiceRemote<Organe, Integer> getService() {
        return this.organeService;
    }

    public void initData() {

    }

    @Override
    public void add() {
        System.out.println("organe ");

    }

    @Override
    public void update() {

    }

    public void delete() {
        try {
            System.out.println("- adding : " + this.entite);
            this.getService().deleteOne(this.entite);
            this.init();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<CategorieOrgane> getCategorieOrganes() {
        return this.categorieOrganeServiceRemote.getAll();
    }

    public OrganeServiceRemote getOrganeService() {
        return organeService;
    }

    public void setOrganeService(OrganeServiceRemote organeService) {
        this.organeService = organeService;
    }

    public CategorieOrganeServiceRemote getCategorieOrganeServiceRemote() {
        return categorieOrganeServiceRemote;
    }

    public void setCategorieOrganeServiceRemote(CategorieOrganeServiceRemote categorieOrganeServiceRemote) {
        this.categorieOrganeServiceRemote = categorieOrganeServiceRemote;
    }

    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    public void setCenterGeoMap(String centerGeoMap) {
        this.centerGeoMap = centerGeoMap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean canAdd() {
        return true;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canList() {
        return true;
    }

    @Override
    public boolean canView() {
        return true;
    }

    public int getFiltreCategorie() {
        return filtreCategorie;
    }

    public void setFiltreCategorie(int filtreCategorie) {
        this.filtreCategorie = filtreCategorie;
    }

    public int getFiltreEtat() {
        return filtreEtat;
    }

    public void setFiltreEtat(int filtreEtat) {
        this.filtreEtat = filtreEtat;
    }

}
