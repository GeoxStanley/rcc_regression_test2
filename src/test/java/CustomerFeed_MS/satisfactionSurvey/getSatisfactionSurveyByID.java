package CustomerFeed_MS.satisfactionSurvey;

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
import static pojo.Constant.Constant.Get_SatisfactionSurvey;
import static utility.RestCalls.GET_200;

public class getSatisfactionSurveyByID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Satisfaction Survey by ID")
    @Story("Ensure that the request is able to fetch satisfaction survey by ID")
    public void Get_AllSatisfaction_Survey() throws InterruptedException, IOException {
        Response response = GET_200(Get_SatisfactionSurvey = "/satisfaction-surveys/1");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Satisfaction survey retrieved"));

    }
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Satisfaction Survey by ID")
    @Story("Ensure that the request is able to fetch satisfaction survey by ID")
    public void Get_AllSatisfaction_Survey_Invalid_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_SatisfactionSurvey = "/satisfaction-surveys/123456789");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("status", is("Error"));
        response.then().assertThat().body("message", is("Survey not found"));
    }
}
