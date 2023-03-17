package CustomerFeed_MS.customerFeeds;

import Base.TestFlight;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static pojo.Constant.Constant.Get_AllCustomer_Feed;
import static utility.RestCalls.GET_200;
import static utility.RestCalls.GET_401;

public class getCustomerFeed extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Customer Feeds by FeedID")
    @Story("Ensure that the request is able to fetch Customer feed by ID")
    public void Get_CustomerFeed_ByID() throws InterruptedException, IOException {
        Response response = GET_200(Get_AllCustomer_Feed  = "/customer-feeds/2");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Customer feed retrived"));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Customer Feeds by FeedID")
    @Story("Ensure that the request is able to fetch Customer feed by ID")
    public void Get_CustomerFeed_InvalidBaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_AllCustomer_Feed = "/customer-feed");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("status", is(404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/customer-feed"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Customer Feeds by FeedID")
    @Story("Ensure that the request is able to fetch Customer feed by ID")
    public void Get_CustomerFeed_By_InvalidID() throws InterruptedException, IOException {
        Response response = GET_200(Get_AllCustomer_Feed = "/customer-feed/1111111111111111111");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().body("status", is(404));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Customer Feeds by FeedID")
    @Story("Ensure that the request is able to fetch Customer feed by ID")
    public void Get_CustomerFeed_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_AllCustomer_Feed = "/customer-feeds");
        response.prettyPeek().then().spec(responseSpec_403);
    }


}
