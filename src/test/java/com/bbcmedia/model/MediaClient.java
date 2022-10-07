package com.bbcmedia.model;

import com.bbcmedia.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MediaClient {
    public static String BASE_URL = ConfigurationReader.get("apiUrl");

    public Response getMediaResponse() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(BASE_URL);
        return response;
    }


    public Media getMedia() {
        Media media = RestAssured.given().accept(ContentType.JSON)
                .when().get(BASE_URL).body().as(Media.class);
        return media;
    }

}



