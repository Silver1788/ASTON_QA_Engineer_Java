import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;
import org.json.JSONObject;

public class APITestPostman {

    @DisplayName("GET Request")
    @Test
    public void testGetRequest() {
        // Отправка GET-запроса
        Response response = RestAssured.given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get?foo1=bar1&foo2=bar2");

        // Проверка кода ответа
        assertEquals(200, response.getStatusCode(), "Expected status code 200");

        // Проверка тела ответа (сравниваем все поля)
        String responseBody = response.getBody().asString();

        // Проверка, что ответ содержит параметры foo1 и foo2 с их значениями
        assertTrue(responseBody.contains("\"foo1\": \"bar1\""), "foo1 is missing or incorrect");
        assertTrue(responseBody.contains("\"foo2\": \"bar2\""), "foo2 is missing or incorrect");

        // Проверка других частей ответа (например, url)
        assertTrue(responseBody.contains("\"url\": \"https://postman-echo.com/get?foo1=bar1&foo2=bar2\""), "URL mismatch");

        // Дополнительные проверки заголовков
        assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"), "Content-Type mismatch");
    }

    @DisplayName("POST Raw Text")
    @Test
    public void testPostRawText() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // Создание JSON тела запроса
        JSONObject requestBody = new JSONObject();
        requestBody.put("test", "value");

        // Отправка POST-запроса
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Проверка кода ответа
        assertEquals(200, response.statusCode(), "Expected status code 200");

        // Проверка тела ответа (сравниваем все поля)
        String responseBody = response.body();

        // Проверка, что ответ содержит ожидаемые данные
        assertTrue(responseBody.contains("\"test\": \"value\""), "Response body does not contain expected test data");

        // Проверка, что в ответе есть URL (подтверждает, что сервер правильно обработал запрос)
        assertTrue(responseBody.contains("\"url\": \"https://postman-echo.com/post\""), "URL mismatch in response");

        // Проверка заголовка Content-Type
        assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/json"), "Content-Type mismatch");
    }


    @DisplayName("POST Form Data")
    @Test
    public void testPostFormData() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = "foo1=bar1&foo2=bar2";

        // Создание POST-запроса с application/x-www-form-urlencoded
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Отправка запроса и получение ответа
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Проверка кода ответа
        assertEquals(200, response.statusCode(), "Expected status code 200");

        // Парсим JSON-ответ
        JSONObject jsonResponse = new JSONObject(response.body());

        // Проверяем, что в ответе есть объект "form"
        assertTrue(jsonResponse.has("form"), "Response does not contain 'form' field");

        // Проверяем, что поля foo1 и foo2 содержат ожидаемые данные
        JSONObject form = jsonResponse.getJSONObject("form");
        assertEquals("bar1", form.getString("foo1"), "foo1 value mismatch");
        assertEquals("bar2", form.getString("foo2"), "foo2 value mismatch");
    }

    @DisplayName("PUT Request")
    @Test
    public void testPutRequest() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = "This is expected to be sent back as part of response body.";

        // Создание PUT-запроса
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/put"))
                .header("Content-Type", "text/plain")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Отправка запроса и получение ответа
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Проверка кода ответа
        assertEquals(200, response.statusCode(), "Expected status code 200");

        // Парсим JSON-ответ
        JSONObject jsonResponse = new JSONObject(response.body());

        // Проверяем, что в ответе есть поле "data"
        assertTrue(jsonResponse.has("data"), "Response does not contain 'data' field");

        // Проверяем, что тело ответа содержит ожидаемые данные
        assertEquals(requestBody, jsonResponse.getString("data"), "Unexpected response body data");
    }

    @DisplayName("PATCH Request")
    @Test
    public void testPatchRequest() throws Exception  {
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = "This is expected to be sent back as part of response body.";

        // Создание PATCH-запроса
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/patch"))
                .header("Content-Type", "text/plain")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Отправка запроса и получение ответа
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Проверка кода ответа
        assertEquals(200, response.statusCode(), "Expected status code 200");

        // Парсим JSON-ответ
        JSONObject jsonResponse = new JSONObject(response.body());

        // Проверяем, что в ответе есть поле "data"
        assertTrue(jsonResponse.has("data"), "Response does not contain 'data' field");

        // Проверяем, что тело ответа содержит ожидаемые данные
        assertEquals(requestBody, jsonResponse.getString("data"), "Unexpected response body data");
    }

    @DisplayName("DELETE Request")
    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = RestAssured.given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JSONObject jsonResponse = new JSONObject(response.getBody().asString());

        assertTrue(jsonResponse.has("data"), "Response does not contain 'data' field");
        assertEquals(requestBody, jsonResponse.getString("data"), "Unexpected response body data");
    }
}
