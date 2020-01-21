package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utilities {

    public static RequestSpecification req;
    public RequestSpecification requestSpecification() throws IOException {
      if(req==null) {
          PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
          req = new RequestSpecBuilder().setBaseUri(getConfigProperty("baseURI")).
                  addQueryParam("key", "qaclick123").
                  addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).
                  setContentType(ContentType.JSON).
                  build();
          return req;
      }
      return req;

    }

    public static String getConfigProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/home/sapansharma//Downloads/APIFramework/src/test/java/Resources/config.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);

    }

}
