package CustomerFeed_MS.enrollee;

import Base.TestFlight;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static pojo.Constant.Constant.Get_Enrollees;
import static utility.RestCalls.GET_200;

public class getEnrolleeByHMO_ID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Enrollees by HMOID")
    @Story("Ensure that the request is able to fetch Enrollee HMOID")
    public void Get_Enrollees_ByHMOID() throws InterruptedException, IOException {
        Response response = GET_200(Get_Enrollees = "/enrollees?query=AFG/10001/A");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));

    }
}
