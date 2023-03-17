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
import static pojo.Constant.Constant.Get_SatisfactionSurvey;
import static utility.RestCalls.GET_200;

public class sortSatisfactionSurveyByID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Satisfaction Survey")
    @Story("Ensure that the request is able to filter satisfaction survey by ID")
    public void Sort_SatisfactionSurvey_ByID() throws InterruptedException, IOException {
        Response response = GET_200(Get_SatisfactionSurvey = "/satisfaction-surveys?sort=id,desc&size=400");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Satisfaction surveys retrieved"));
        response.then().assertThat().body("currentSize", is(200));
        response.then().assertThat().body("totalPages", is(1));
        response.then().assertThat().body("totalSize", is(200));

    }
}
