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
import static pojo.Constant.Constant.Get_FeedItems;
import static utility.RestCalls.GET_200;

public class getFeedItemsBySize extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Items by Page Size")
    @Story("Ensure that the request is able to fetch feeds size")
    public void Get_FeedsItems() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedItems = "/feed-items?size=200");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("title", is("Lorem Ipsum"));

    }
}
