package Base;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import static utility.RestCalls.*;
import static utility.Utility.fetchvalue;

public class TestFlight {
    public static ResponseSpecification responseSpec_200;
    public static ResponseSpecification responseSpec_201;
    public static ResponseSpecification responseSpec_400;
    public static ResponseSpecification responseSpec_401;
    public static ResponseSpecification responseSpec_404;
    public static ResponseSpecification responseSpec_409;
    public static ResponseSpecification responseSpec_403;
    public static ResponseSpecification responseSpec_500;

    @BeforeMethod(alwaysRun = true)
    protected void setUpConfiguration() {
        RestAssured.baseURI = fetchvalue("BaseURL_PR");

        responseSpec_200 = new ResponseSpecBuilder().
                expectStatusCode(RESPONSE_STATUS_CODE_200).
                expectContentType(ContentType.JSON).expectStatusLine(StatusLine_200)
                .expectResponseTime(lessThan(15L), TimeUnit.SECONDS).
                build();

        responseSpec_201 = new ResponseSpecBuilder().
                expectStatusCode(RESPONSE_STATUS_CODE_201).
                expectContentType(ContentType.JSON).expectStatusLine(StatusLine_201)
                .expectResponseTime(lessThan(15L), TimeUnit.SECONDS).
                build();

        responseSpec_400 = new ResponseSpecBuilder().
                expectStatusCode(RESPONSE_STATUS_CODE_400).
                expectContentType(ContentType.JSON).expectStatusLine(StatusLine_400)
                .expectResponseTime(lessThan(15L), TimeUnit.SECONDS).
                build();

        responseSpec_403 = new ResponseSpecBuilder().
                expectStatusCode(RESPONSE_STATUS_CODE_403).
                expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(15L), TimeUnit.SECONDS).
                build();

        responseSpec_404 = new ResponseSpecBuilder().
                expectStatusCode(RESPONSE_STATUS_CODE_404)
                .expectStatusLine(StatusLine_404)
                .expectResponseTime(lessThan(15L), TimeUnit.SECONDS).
                build();

        responseSpec_409 = new ResponseSpecBuilder().
                expectStatusCode(RESPONSE_STATUS_CODE_409).
                expectContentType(ContentType.JSON).expectStatusLine(StatusLine_409)
                .expectResponseTime(lessThan(15L), TimeUnit.SECONDS).
                build();

        responseSpec_401 = new ResponseSpecBuilder().
                expectStatusCode(401).
                build();

        responseSpec_500 = new ResponseSpecBuilder().
                expectStatusCode(RESPONSE_STATUS_CODE_500).
                expectContentType(ContentType.JSON).expectStatusLine(StatusLine_500)
                .expectResponseTime(lessThan(15L), TimeUnit.SECONDS).
                build();
    }

    @BeforeMethod(alwaysRun = true)
    protected void Waiter() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
    }

}
