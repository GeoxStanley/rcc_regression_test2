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
import static pojo.Constant.Constant.Get_FeedLabel;
import static utility.RestCalls.GET_200;

public class getFeedLabelBySize extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Label Page Size")
    @Story("Ensure that the request is able to fetch feeds label by size")
    public void Get_FeedsLabel_BySize() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedLabel = "/feed-labels?size=600");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));

    }
}
