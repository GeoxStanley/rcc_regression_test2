package CustomerFeed_MS.feedItems;

import Base.TestFlight;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static pojo.Constant.Constant.*;
import static utility.RestCalls.GET_200;
import static utility.RestCalls.GET_401;

public class getAllFeedItems extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Items")
    @Story("Ensure that the request is able to fetch feeds items")
    public void Get_FeedsItems() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedItems = "/feed-items");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Items")
    @Story("An Endpoint to get All Feeds Items")
    public void Get_FeedsItems_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedItems = "/feed-item");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-item"));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Items")
    @Story("An Endpoint to get All Feeds Items")
    public void Get_FeedsItems_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_FeedItems = "/feed-items");
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
