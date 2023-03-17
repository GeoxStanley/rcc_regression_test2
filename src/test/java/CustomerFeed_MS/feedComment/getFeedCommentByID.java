package CustomerFeed_MS.feedComment;

import Base.TestFlight;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static pojo.Constant.Constant.Get_Enrollees;
import static pojo.Constant.Constant.Get_FeedComments;
import static utility.RestCalls.GET_200;

public class getFeedCommentByID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feed Comment by Customer FeedID")
    @Story("Ensure that the request is able to fetch feeds comment by customer Feed ID")
    public void Get_FeedComment_ByCustomerFeedID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedComments = "/feed-comments?customerFeedId=30");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Comments retrieved for customer feed id: 30"));
        response.then().assertThat().body("currentSize", is(1));
        response.then().assertThat().body("totalPages", is(1));
        response.then().assertThat().body("totalSize", is(1));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feed Comment by Customer FeedID")
    @Story("Ensure that the request is able to fetch feeds comment by customer Feed ID")
    public void Get_FeedComment_InValid_ByCustomerFeedID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedComments = "/feed-comments?customerFeedId=300000000");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("No feed comments found"));
        response.then().assertThat().body("currentSize", is(0));
        response.then().assertThat().body("totalPages", is(0));
        response.then().assertThat().body("totalSize", is(0));

    }

}
