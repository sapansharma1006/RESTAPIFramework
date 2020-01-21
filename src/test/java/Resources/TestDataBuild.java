package Resources;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    AddPlace place = new AddPlace();
    public AddPlace addPlacePayload(){


        List<String> myList = new ArrayList<String>();
        Location l = new Location();

//        RestAssured.baseURI="https://rahulshettyacademy.com";

        myList.add("shoe park");
        myList.add("shop");
        l.setLat(-38.383494);
        l.setLng(33.427362);
        place.setAccuracy(50);
        place.setAddress("29, side layout, cohen 09");
        place.setLanguage("French-IN");
        place.setName("Frontline house");
        place.setPhone_number("(+91) 983 893 3937");
//        place.setAddress("29, side layout, cohen 09");
        place.setWebsite("https://www.rahulshettyacademy.com/");
        place.setTypes(myList);
        place.setLocation(l);
        return place;

    }

    public AddPlace addPlaceWithMultipleDataPayload(String name, String language, String address){


        List<String> myList = new ArrayList<String>();
        Location l = new Location();

//        RestAssured.baseURI="https://rahulshettyacademy.com";

        myList.add("shoe park");
        myList.add("shop");
        l.setLat(-38.383494);
        l.setLng(33.427362);
        place.setAccuracy(50);
        place.setAddress(address);
        place.setLanguage(language);
        place.setName(name);
        place.setPhone_number("(+91) 983 893 3937");
//        place.setAddress("29, side layout, cohen 09");
        place.setWebsite("https://www.rahulshettyacademy.com/");
        place.setTypes(myList);
        place.setLocation(l);
        return place;

    }
}
