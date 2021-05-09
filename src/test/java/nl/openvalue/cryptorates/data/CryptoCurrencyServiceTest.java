package nl.openvalue.cryptorates.data;

import nl.openvalue.cryptorates.data.CryptoCurrency;
import nl.openvalue.cryptorates.data.CryptoCurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CryptoCurrencyServiceTest {

    @Autowired
    private CryptoCurrencyService service;

    @Test
    void updateWithEmptyList() {
        service.replaceAll(Collections.<CryptoCurrency>emptyList());
        assertThat(service.findAll().size()).isZero();
    }

    @Test
    void updateWithNonEmptyList() {
        var cryptosToCreate = List.of(new CryptoCurrency("name", "symbol", "slug"));
        service.replaceAll(cryptosToCreate);
        var retrievedCryptos = service.findAll();
        assertThat(retrievedCryptos.size()).isOne();
        var retrievedCrypto = retrievedCryptos.get(0);
        assertThat(retrievedCrypto.getName()).isEqualTo("name");
        assertThat(retrievedCrypto.getSymbol()).isEqualTo("symbol");
        assertThat(retrievedCrypto.getSlug()).isEqualTo("slug");
    }


    @Test
    void updateFromCoinMarketCap() {
        service.replaceAll(Collections.<CryptoCurrency>emptyList());
        assertThat(service.findAll().size()).isZero();

        service.updateFromCoinMarketCap();

        var cryptos = service.findAll();
        assertThat(service.findAll().size()).isNotZero();

        System.out.println("first result: " +cryptos.get(0));

    }


}
