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
import static utility.RestCalls.GET_401;

public class getFeedCategory extends TestFlight {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Category")
    @Story("Ensure that the request is able to fetch feeds categories")
    public void Get_FeedsCategory() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedCategories = "/feed-categories");
        response.prettyPeek().then().spec(responseSpec_200);

        response.then().assertThat().statusCode((200));
        response.then().assertThat().body("status", is("Success"));
        response.then().assertThat().body("message", is("Feed categories retrieved"));
        response.then().assertThat().body("currentSize", is(20));
        response.then().assertThat().body("totalSize", is(24));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Category")
    @Story("Ensure that the request is able to fetch feeds categories")
    public void Get_FeedsCategory_Invalid_BaseURL() throws InterruptedException, IOException {
        Response response = GET_200(Get_FeedCategories = "/feed-categorie");
        response.prettyPeek().then().spec(responseSpec_404);

        response.then().assertThat().statusCode((404));
        response.then().assertThat().body("path", is("customerfeedservice/api/feed-categorie"));
        response.then().assertThat().body("message", is("Not Found"));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to get All Feeds Category")
    @Story("Ensure that the request is able to fetch feeds categories")
    public void Get_FeedsCategory_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_FeedCategories = "/feed-categories");
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
