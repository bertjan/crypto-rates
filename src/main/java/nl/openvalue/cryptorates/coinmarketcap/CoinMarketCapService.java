package nl.openvalue.cryptorates.coinmarketcap;

import nl.openvalue.cryptorates.data.CryptoCurrency;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinMarketCapService {

    private CoinMarketCapClient restClient;

    public CoinMarketCapService(CoinMarketCapClient client) {
        this.restClient = client;
    }

    public List<CryptoCurrency> fetchAll() {
        return restClient.fetchData().getData();
    }

}
