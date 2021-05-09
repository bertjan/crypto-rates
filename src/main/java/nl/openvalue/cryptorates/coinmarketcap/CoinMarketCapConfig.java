package nl.openvalue.cryptorates.coinmarketcap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CoinMarketCapConfig {

    @Value("${coinmarketcap.api.key}")
    private String API_KEY;
    private static final String API_URL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";

    public String getApiUrl() {
        return API_URL;
    }
    public String getApiKey() {
        return API_KEY;
    }

}
