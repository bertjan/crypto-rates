package nl.openvalue.cryptorates.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class CryptoCurrencyRepositoryTest {

    @Autowired
    private CryptoCurrencyRepository repository;

    @Test
    void doTest() {
        var crypto = new CryptoCurrency();
        crypto.name = "crypto1-name";
        crypto.slug = "crypto1-slug";
        crypto.symbol ="crypto1-symbol";
        var savedCrypto = repository.save(crypto);

        assertThat(savedCrypto.id).isNotNull();
        assertThat(savedCrypto.name).isEqualTo(crypto.name);
        assertThat(savedCrypto.slug).isEqualTo(crypto.slug);
        assertThat(savedCrypto.symbol).isEqualTo(crypto.symbol);
    }

}
