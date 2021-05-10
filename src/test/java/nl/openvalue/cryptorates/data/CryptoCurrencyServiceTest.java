package nl.openvalue.cryptorates.data;

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
        var crypto = new CryptoCurrency();
        crypto.name = "name";
        crypto.symbol = "symbol";
        crypto.slug= "slug";
        var cryptosToCreate = List.of(crypto);
        service.replaceAll(cryptosToCreate);
        var retrievedCryptos = service.findAll();
        assertThat(retrievedCryptos.size()).isOne();
        var retrievedCrypto = retrievedCryptos.get(0);
        assertThat(retrievedCrypto.name).isEqualTo("name");
        assertThat(retrievedCrypto.symbol).isEqualTo("symbol");
        assertThat(retrievedCrypto.slug).isEqualTo("slug");
    }


    @Test
    void updateFromCoinMarketCap() {
        service.replaceAll(Collections.<CryptoCurrency>emptyList());
        assertThat(service.findAll().size()).isZero();

        service.updateFromCoinMarketCap();

        assertThat(service.findAll().size()).isNotZero();
    }

}
