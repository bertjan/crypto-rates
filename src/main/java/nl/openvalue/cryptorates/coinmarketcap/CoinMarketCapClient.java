package nl.openvalue.cryptorates.coinmarketcap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CoinMarketCapClient {

    private static final String HEADER_API_KEY = "X-CMC_PRO_API_KEY";
    private CoinMarketCapConfig config;

    public CoinMarketCapClient(CoinMarketCapConfig config) {
        this.config = config;
    }

    public CoinMarketCapResponse fetchData() {
        var parameters =
                Map.of("start", "1",
                        "limit", "5000",
                        "convert", "EUR");
        var headers = new HttpHeaders();
        headers.add(HEADER_API_KEY, config.getApiKey());
        var request = new HttpEntity<>(parameters, headers);

        var response =
                new RestTemplate().exchange(config.getApiUrl(), HttpMethod.GET, request, CoinMarketCapResponse.class);
        return response.getBody();
    }
}
