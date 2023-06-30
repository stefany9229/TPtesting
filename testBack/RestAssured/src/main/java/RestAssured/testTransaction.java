package RestAssured;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class testTransaction {
    String URL = "https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/17784/transactions/month/All/type/All";
            Response response =         given().auth()
            .basic("username_7", "123")
            .when()
            .get(URL);

    @Test
    public void test01() {

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
    }

    @Test
    public void test02() {

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}