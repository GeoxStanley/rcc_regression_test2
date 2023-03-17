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
import static pojo.Constant.Constant.Get_FeedActivity_Logs;
import static utility.RestCalls.GET_200;
import static utility.RestCalls.GET_401;

public class getFeedsActivitylogs extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds Activities Logs")
    @Story("Ensure that the request is able to fetch feeds activity logs")
    public void Get_FeedsActivitiesLogs() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedActivity_Logs = "/feed-activity-logs");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Customer feed activity retrieved"));
        response.then().assertThat().body("currentSize", is(20));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds Activities Logs")
    @Story("Ensure that the request is able to fetch feeds activity logs")
    public void Get_FeedsActivitiesLogs_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedActivity_Logs = "/feed-activity-log");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-activity-log"));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Customer Feeds Activities Logs")
    @Story("Ensure that the request is able to fetch feeds activity logs")
    public void Get_FeedsActivitiesLogs_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_FeedActivity_Logs = "/feed-activity-logs");
        response.prettyPeek().then().spec(responseSpec_403);
    }

}
