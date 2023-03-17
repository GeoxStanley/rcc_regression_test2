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
import static utility.RestCalls.GET_401;

public class getAllFeedsComment extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds Comments")
    @Story("Ensure that the request is able to fetch all customer feeds comments")
    public void Get_AllFeeds_Comments() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedComments = "/feed-comments");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("All customer feeds retrieved"));
        response.then().assertThat().body("currentSize", is(9));
        response.then().assertThat().body("totalPages", is(1));
        response.then().assertThat().body("totalSize", is(9));

    }
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get all Feed Comment by Customer FeedID")
    @Story("An Endpoint to get all Feed Comment by Customer FeedID")
    public void Get_FeedComment_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedComments = "/feed-comment");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-comment"));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feed Comment by Customer FeedID")
    @Story("An Endpoint to get all Feed Comment by Customer FeedID")
    public void Get_FeedComment_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_FeedComments = "/feed-comment");
        response.prettyPeek().then().spec(responseSpec_403);
    }


}
