package CustomerFeed_MS.feedsCategory;

import Base.TestFlight;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static pojo.Constant.Constant.Get_FeedCategories;
import static utility.RestCalls.GET_200;

public class getFeedCategoryBySize extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Categories by pageSize")
    @Story("Ensure that the request is able to fetch feeds categories by Size")
    public void Get_FeedsCategory_BySize() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedCategories = "/feed-categories?size=500");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Feed categories retrieved"));
        response.then().assertThat().body("currentSize", is(24));
        response.then().assertThat().body("totalSize", is(24));

    }
}

