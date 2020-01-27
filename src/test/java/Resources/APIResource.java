package Resources;

public enum  APIResource {

    AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/delete/");
    private String resource ;


    APIResource(String resource) {
        this.resource=resource;
    }

    public String getResource(){
        return resource;
    }
}
