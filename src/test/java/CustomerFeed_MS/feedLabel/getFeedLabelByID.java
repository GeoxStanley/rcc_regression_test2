package CustomerFeed_MS.feedLabel;

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
import static pojo.Constant.Constant.Get_FeedLabel;
import static utility.RestCalls.GET_200;

public class getFeedLabelByID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feeds Label by ID")
    @Story("Ensure that the request is able to fetch feed label by ID")
    public void Get_FeedsLabel_ByID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedLabel = "/feed-labels/1");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("label", is("benefit_limit_update_error"));
        response.then().assertThat().body("canGenerateTicket", is(true));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feeds Label by ID")
    @Story("Ensure that the request is able to fetch feeds label by ID")
    public void Get_FeedsLabel_By_Invalid_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedLabel = "/feed-labels/1111");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-labels/1111"));
        response.then().assertThat().body("message", is("error.http.404"));
    }

}
