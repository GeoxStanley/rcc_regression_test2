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
import static pojo.Constant.Constant.Get_FeedType;
import static pojo.Constant.Constant.Get_SatisfactionSurvey;
import static utility.RestCalls.GET_200;
import static utility.RestCalls.GET_401;

public class getAllSatisfactionSurvey extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Satisfaction Survey")
    @Story("Ensure that the request is able to fetch all satisfaction survey")
    public void Get_AllSatisfaction_Survey() throws InterruptedException, IOException {
        Response response = GET_200(Get_SatisfactionSurvey = "/satisfaction-surveys");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Satisfaction surveys retrieved"));
        response.then().assertThat().body("currentSize", is(20));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Satisfaction Survey")
    @Story("Ensure that the request is able to fetch all satisfaction survey")
    public void Get_AllSatisfaction_Survey_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_SatisfactionSurvey = "/satisfaction-survey");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("customerfeedservice/api/satisfaction-survey"));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Satisfaction Survey")
    @Story("Ensure that the request is able to fetch all satisfaction survey")
    public void Get_AllSatisfaction_Survey_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_SatisfactionSurvey = "/satisfaction-surveys");
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
