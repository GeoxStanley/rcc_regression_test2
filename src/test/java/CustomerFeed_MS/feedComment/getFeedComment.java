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

public class getFeedComment extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Customer Feed Comment by ID")
    @Story("Ensure that the request is able to fetch customer feeds comment by ID")
    public void Get_FeedComment_ByID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedComments = "/feed-comments/1");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("comment", is("Testing comments"));
        response.then().assertThat().body("customerFeedId", is(347));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Customer Feed Comment by ID")
    @Story("An Endpoint to get Customer Feed Comment by ID")
    public void Get_FeedComment_Invalid_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedComments = "/feed-comments/111111111111");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-comments/111111111111"));
        response.then().assertThat().body("message", is("error.http.404"));
    }


}
