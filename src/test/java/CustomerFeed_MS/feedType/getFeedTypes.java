package CustomerFeed_MS.feedType;

import Base.TestFlight;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static pojo.Constant.Constant.Get_FeedCategories;
import static pojo.Constant.Constant.Get_FeedType;
import static utility.RestCalls.GET_200;
import static utility.RestCalls.GET_401;

public class getFeedTypes extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Types")
    @Story("Ensure that the request is able to fetch feeds types")
    public void Get_FeedsTypes() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedType = "/feed-types");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Types")
    @Story("Ensure that the request is able to fetch feeds types")
    public void Get_FeedsTypes_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedType = "/feed-type");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("customerfeedservice/api/feed-type"));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Types")
    @Story("Ensure that the request is able to fetch feeds types")
    public void Get_FeedsTypes_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_FeedType = "/feed-types");
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
