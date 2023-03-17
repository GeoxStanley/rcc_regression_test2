package CustomerFeed_MS.customerFeedsActivity;

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
import static pojo.Constant.Constant.Get_FeedActivity_Logs;
import static utility.RestCalls.GET_200;

public class getFeedsActivityLogsByID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds Activities Log by ID")
    @Story("Ensure that the request is able to fetch feeds activity log By ID")
    public void Get_FeedsActivitiesLogs_ByID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedActivity_Logs = "/feed-activity-logs/33");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Customer feed activity retrieved"));
        response.then().assertThat().body("currentSize", is(20));
        response.then().assertThat().body("totalSize", is(25));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds Activities Log By ID")
    @Story("Ensure that the request is able to fetch feeds activity log by ID")
    public void Get_FeedsActivitiesLogs_Invalid_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_AllCustomer_Feed = "/feed-activity-log/333333333333");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-activity-log/333333333333"));
        response.then().assertThat().body("message", is("Not Found"));
    }
}
