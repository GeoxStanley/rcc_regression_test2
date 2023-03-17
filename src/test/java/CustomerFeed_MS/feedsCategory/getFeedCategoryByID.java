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
import static pojo.Constant.Constant.Get_FeedItems;
import static utility.RestCalls.GET_200;

public class getFeedCategoryByID extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feeds Category by ID")
    @Story("Ensure that the request is able to fetch feed categories by ID")
    public void Get_FeedsCategory_Byid() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedCategories = "/feed-categories/1");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("canAddProvider", is(false));
        response.then().assertThat().body("divisionLeadEmail", is("ugochi@reliancefamilyclinics.com"));

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get Feeds Category by ID")
    @Story("Ensure that the request is able to fetch feed categories by ID")
    public void Get_FeedsCategory_Invalid_ID() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedCategories = "/feed-categories/11111");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("/customerfeedservice/api/feed-categories/11111"));
        response.then().assertThat().body("message", is("error.http.404"));

    }
}
