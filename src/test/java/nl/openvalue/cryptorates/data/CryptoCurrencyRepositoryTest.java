package nl.openvalue.cryptorates.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CryptoCurrencyRepositoryTest {

    Logger logger = LoggerFactory.getLogger(CryptoCurrencyRepositoryTest.class);

    @Autowired
    private CryptoCurrencyRepository repository;

    @BeforeEach
    void cleanUp() {
        repository.deleteAllInBatch();
    }

    @Test
    void doTest() {
        var crypto = new CryptoCurrency();
        crypto.setName("crypto1-name");
        crypto.setSlug("crypto1-slug");
        crypto.setSymbol("crypto1-symbol");
        var savedCrypto = repository.save(crypto);

        assertThat(savedCrypto.getId()).isNotNull();
        assertThat(savedCrypto.getName()).isEqualTo(crypto.getName());
        assertThat(savedCrypto.getSlug()).isEqualTo(crypto.getSlug());
        assertThat(savedCrypto.getSymbol()).isEqualTo(crypto.getSymbol());

        assertThat(savedCrypto).isEqualTo(repository.findById(savedCrypto.getId()).get());


    }

}
