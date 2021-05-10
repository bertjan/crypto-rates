package nl.openvalue.cryptorates;

import nl.openvalue.cryptorates.data.CryptoCurrency;
import nl.openvalue.cryptorates.data.CryptoCurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CryptoCurrencyController {

    private CryptoCurrencyService service;

    public CryptoCurrencyController(CryptoCurrencyService service) {
        this.service = service;
    }

    // TODO BJS: replace with OpenAPI spec
    @GetMapping("/")
    public ResponseEntity<String> apiRoot() {
        return ResponseEntity.ok().body("available API's: /{symbol} (return single), /all (returns all), /clear (clears database), /update (updates from CoinMarketCap)");
    }

    @GetMapping("/{symbol}")
    public CryptoCurrency getSingle(@PathVariable String symbol) {
        return service.findBySymbol(symbol);
    }

    @GetMapping("/all")
    public List<CryptoCurrency> getAll() {
        return service.findAll();
    }

    @GetMapping("/clear")
    public ResponseEntity<String> clear() {
        service.clear();
        return ResponseEntity.ok().body("database cleared");
    }

    @GetMapping("/update")
    public ResponseEntity update() {
        service.updateFromCoinMarketCap();
        return ResponseEntity.ok().body("updated currencies from CoinMarketCap");
    }

}
