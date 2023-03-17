package CustomerFeed_MS.enrollee;

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
import static pojo.Constant.Constant.Get_FeedActivity_Logs;
import static utility.RestCalls.GET_200;
import static utility.RestCalls.GET_401;

public class getEnrollees extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Enrollees")
    @Story("Ensure that the request is able to fetch All Enrollees")
    public void Get_Enrollees() throws InterruptedException, IOException {
        Response response = GET_200(Get_Enrollees = "/enrollees");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Enrollees")
    @Story("An Endpoint to get All Enrollees")
    public void Get_Enrollees_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_Enrollees = "/enrollee");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/enrollee"));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Enrollees")
    @Story("An Endpoint to get All Enrollees")
    public void Get_Enrollees_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_Enrollees = "/enrollees");
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
