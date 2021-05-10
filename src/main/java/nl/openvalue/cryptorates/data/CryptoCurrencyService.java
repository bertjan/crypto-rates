package nl.openvalue.cryptorates.data;

import nl.openvalue.cryptorates.coinmarketcap.CoinMarketCapClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoCurrencyService {

    private CryptoCurrencyRepository repository;
    private CoinMarketCapClient restClient;

    public CryptoCurrencyService(CryptoCurrencyRepository repository, CoinMarketCapClient restClient) {
        this.repository = repository;
        this.restClient = restClient;
    }

    public List<CryptoCurrency> findAll() {
        return repository.findAll();
    }

    public void clear() {
        repository.deleteAllInBatch();
    }

    public void replaceAll(List<CryptoCurrency> newCryptoCurrencies) {
        repository.deleteAllInBatch();
        repository.saveAll(newCryptoCurrencies);
    }

    public void updateFromCoinMarketCap() {
        replaceAll(restClient.fetchData().data);
    }

    public CryptoCurrency findBySymbol(String symbol) {
        return repository.findBySymbol(symbol.toUpperCase());
    }

}
