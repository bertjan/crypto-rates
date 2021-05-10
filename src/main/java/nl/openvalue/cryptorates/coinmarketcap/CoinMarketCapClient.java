package nl.openvalue.cryptorates.coinmarketcap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CoinMarketCapClient {

    private static final String HEADER_API_KEY = "X-CMC_PRO_API_KEY";

    @Value("${coinmarketcap.api.key}")
    private String apiKey;

    @Value("${coinmarketcap.api.url}")
    private String apiUrl;

    public CoinMarketCapResponse fetchData() {
        var parameters =
                Map.of("start", "1",
                        "limit", "5000",
                        "convert", "EUR");

        var headers = new HttpHeaders();
        headers.add(HEADER_API_KEY, apiKey);

        var response =
                new RestTemplate().exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(parameters, headers), CoinMarketCapResponse.class);

        return response.getBody();
    }
}
