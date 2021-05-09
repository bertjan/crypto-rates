package nl.openvalue.cryptorates.data;

import nl.openvalue.cryptorates.coinmarketcap.CoinMarketCapService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoCurrencyService {

    private CryptoCurrencyRepository repository;
    private CoinMarketCapService service;

    public CryptoCurrencyService(CryptoCurrencyRepository repository, CoinMarketCapService service) {
        this.repository = repository;
        this.service = service;
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
        replaceAll(service.fetchAll());
    }

    public CryptoCurrency findBySymbol(String symbol) {
        return repository.findBySymbol(symbol.toUpperCase());
    }

}
