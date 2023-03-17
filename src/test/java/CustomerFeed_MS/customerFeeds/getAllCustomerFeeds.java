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

public class getAllCustomerFeeds extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds")
    @Story("Ensure that the request is able to fetch all customer feeds")
    public void Get_AllCustomer_Feeds() throws InterruptedException, IOException {
        Response response = GET_200(Get_AllCustomer_Feed = "/customer-feeds");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Customer feeds retrieved"));
        response.then().assertThat().body("currentSize", is(20));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds")
    @Story("Ensure that the request is able to fetch all customer feeds")
    public void Get_AllCustomer_Feeds_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_AllCustomer_Feed = "/customer-feed");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/customer-feed"));
        response.then().assertThat().body("message", is("Not Found"));
    }


}
