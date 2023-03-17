package CustomerFeed_MS.customerFeeds;

import Base.TestFlight;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static pojo.Constant.Constant.Get_AllCustomer_Feed;
import static utility.RestCalls.POST_201;
import static utility.Utility.generateStringFromResource;

public class createPatientFeeds extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Patient Feeds")
    @Story("Ability for the endpoint to create patient feeds")
    public void createPatient_Feed_201() throws InterruptedException, IOException {
        Response response = POST_201(Get_AllCustomer_Feed, generateStringFromResource("./src/main/java/Payload/Create_Patient_Feed.json"));

        response.prettyPeek().then().spec(responseSpec_201);

        assertThat(response.path("status").toString(),equalTo ("Success"));
        assertThat(response.path("message").toString(),equalTo ("Customer feed created"));

    }

}
