package com.bbcmedia.stepDefinitions;

import com.bbcmedia.model.Media;
import com.bbcmedia.model.MediaClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class getMediaStepDefs {

    MediaClient mediaClient = new MediaClient();
    Media media;
    Response response;

    @Given("User get credentials")
    public void user_get_credentials() {
        System.out.println("User got credentials");
    }

    @When("I make a get request to Media endpoint")
    public void i_make_a_get_request_to_Media_endpoint() {
        response = mediaClient.getMediaResponse();
    }

    @Then("status code should be {int}")
    public void http_status_code_of_the_response_should_be(Integer int1) {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Then("response time should be less than {int} milliseconds")
    public void response_time_of_the_request_should_be_below_milliseconds(Integer responseTime) {
        Assert.assertTrue(response.getTime() < responseTime);

    }

    @Then("Id field should never be null or empty")
    public void id_field_should_never_be_null_or_empty() {
        Media media = response.body().as(Media.class);
        media.getData().forEach(data -> {
            Assert.assertNotNull(data.getId());
            Assert.assertNotEquals(data.getId(), "");
        });
    }

    @Then("Segment type field is always music")
    public void segment_type_field_is_always_music() {
        Media media = response.body().as(Media.class);
        media.getData().forEach(data -> {
                    Assert.assertEquals(data.getSegmentType(), "music");
                }
        );
    }

    @Then("primary field in title_list is never null or empty")
    public void primary_field_in_title_list_is_never_null_or_empty() {
        Media media = response.body().as(Media.class);
        media.getData().forEach(data -> {
            Assert.assertNotNull(data.getTitleList().getPrimary());
            Assert.assertNotEquals(data.getTitleList().getPrimary(), "");
        });
    }

    @Then("only one track in the list is playing")
    public void only_one_track_in_the_list_is_playing() {
        Media media = response.body().as(Media.class);
        long count = media.getData().stream().filter(data -> data.getOffset().getNowPlaying())
                .count();
        Assert.assertEquals(count, 1);
    }

    @Then("^header should contain date value as (.*)$")
    public void checkHeaderDate(String expectedDate) {
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));
        String actualDate = response.headers().getValue("Date");
        Assert.assertEquals(expectedDate, actualDate);
    }

}
