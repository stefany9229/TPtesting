package RestAssured;
import static io.restassured.RestAssured.get;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Registertest {
    String URL = "https://parabank.parasoft.com/parabank/register.htm";
    Response response = get(URL);

    @Test
    public void Test01() {


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