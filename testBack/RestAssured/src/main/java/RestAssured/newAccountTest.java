package RestAssured;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class newAccountTest {
    String URL = "https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=27197&newAccountType=1&fromAccountId=40428";
    Response response =
            given().auth()
            .basic("username_7", "123")
            .when()
            .post(URL);

    @Test
    public void test01() {

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
    }

    @Test
    public void test02() {

                given().auth()
                .basic("username_7", "123")
                .when()
                .post("https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12878&newAccountType=1&fromAccountId=14010")
                .then()
                .assertThat()
                .statusCode(200);
    }
}