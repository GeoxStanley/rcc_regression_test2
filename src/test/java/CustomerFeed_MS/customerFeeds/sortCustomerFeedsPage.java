package CustomerFeed_MS.customerFeeds;

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
import static utility.RestCalls.GET_200;

public class sortCustomerFeedsPage extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to sort Customer Feeds Page by FeedID")
    @Story("Ensure that the request is able to sort Customer feed page by ID")
    public void sort_CustomerFeedPage_ByID() throws InterruptedException, IOException {
        Response response = GET_200(Get_AllCustomer_Feed = "/customer-feeds?sort=id,desc&size=2");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Customer feeds retrieved"));
        response.then().assertThat().body("currentSize", is(2));

    }

}
