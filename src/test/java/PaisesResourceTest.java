import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.seidelsoft.model.pais.Pais;
import org.seidelsoft.model.pais.PaisDTO;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@TestHTTPEndpoint(PaisesResourceTest.class)
public class PaisesResourceTest {

//    @Test
//    public void getAll() {
//        given().when().get().then().statusCode(200);
//    }
//
//    @Test
//    public void getById(){
//        PaisDTO pais = createPaisDTO();
//
//        Pais saved = given().contentType(ContentType.JSON)
//                .body(pais)
//                .post()
//                .then()
//                .statusCode(201)
//                .extract().as(Pais.class);
//
//        Pais got = given()
//                .when()
//                .get("/{id}", saved.getId())
//                .then()
//                .statusCode(200)
//                .extract().as(Pais.class);
//
//        assertThat(saved).isEqualTo(got);
//    }
//
//    @Test
//    public void getByIdNotFound() {
//        given()
//                .when()
//                .get("/{id}", 987654321)
//                .then()
//                .statusCode(404);
//    }
//
//    @Test
//    public void post() {
//        PaisDTO customer = createPaisDTO();
//        Pais saved = given()
//                .contentType(ContentType.JSON)
//                .body(customer)
//                .post()
//                .then()
//                .statusCode(201)
//                .extract().as(Pais.class);
//
//        assertThat(saved.getId()).isNotNull();
//    }
//
//    @Test
//    public void postFailNoName() {
//        PaisDTO customer = createPaisDTO();
//        customer.setNome(null);
//        given()
//                .contentType(ContentType.JSON)
//                .body(customer)
//                .post()
//                .then()
//                .statusCode(400);
//    }
//
//    @Test
//    public void put() {
//        PaisDTO customer = createPaisDTO();
//        Pais saved = given()
//                .contentType(ContentType.JSON)
//                .body(customer)
//                .post()
//                .then()
//                .statusCode(201)
//                .extract().as(Pais.class);
//
//        saved.setNome("Updated");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(saved)
//                .put("/{id}", saved.getId())
//                .then()
//                .statusCode(204);
//    }
//
//    @Test
//    public void putFailNoName() {
//        PaisDTO customer = createPaisDTO();
//        Pais saved = given()
//                .contentType(ContentType.JSON)
//                .body(customer)
//                .post()
//                .then()
//                .statusCode(201)
//                .extract().as(Pais.class);
//
//        saved.setNome(null);
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(saved)
//                .put("/{id}", saved.getId())
//                .then()
//                .statusCode(400);
//    }
//
//    private PaisDTO createPaisDTO() {
//        PaisDTO dto = new PaisDTO();
//        dto.setNome(RandomStringUtils.randomAlphabetic(10));
//        dto.setCodigoArea(RandomStringUtils.randomNumeric(2));
//
//        return dto;
//    }

}
