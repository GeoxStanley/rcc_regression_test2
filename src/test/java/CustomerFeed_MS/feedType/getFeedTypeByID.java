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
import static pojo.Constant.Constant.Get_FeedItems;
import static pojo.Constant.Constant.Get_FeedType;
import static utility.RestCalls.GET_200;

public class getFeedTypeByID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feeds Type by ID")
    @Story("Ensure that the request is able to fetch feeds type by ID")
    public void Get_FeedsTypes_ByID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedType = "/feed-types/1");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("name", is("Complaint"));
        response.then().assertThat().body("status", is("ACTIVE"));
        response.then().assertThat().body("canAddProvider", is(true));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feeds Type by ID")
    @Story("Ensure that the request is able to fetch feeds type by ID")
    public void Get_FeedsTypes_Invalid_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedType = "/feed-types/11111");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-types/11111"));
        response.then().assertThat().body("message", is("error.http.404"));
    }
}
