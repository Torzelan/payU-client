package pl.kn.payuclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import pl.kn.payuclient.model.AuthorizationResponse;
import pl.kn.payuclient.model.OrderRequest;
import pl.kn.payuclient.model.OrderResponse;

import java.util.Objects;

public class PayUClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private String location;
    private String bearer;

    public PayUClient(String location) {
        this.location = location;
    }

    public void authorize(String clientId, String clientSecret) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        var map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "client_credentials");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);

        var entity = new HttpEntity<>(map, headers);
        var response = restTemplate.exchange(location + "pl/standard/user/oauth/authorize", HttpMethod.POST, entity, AuthorizationResponse.class);
        bearer = Objects.requireNonNull(response.getBody()).getAccess_token();
    }

    public OrderResponse order(OrderRequest orderRequest) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearer);
        var entity = new HttpEntity<>(orderRequest, headers);
        return restTemplate.exchange(location + "api/v2_1/orders", HttpMethod.POST, entity, OrderResponse.class).getBody();
    }
}
