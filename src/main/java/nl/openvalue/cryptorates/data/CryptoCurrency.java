package nl.openvalue.cryptorates.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Objects;

@Entity
public class CryptoCurrency {

    @Id
    public long id;
    public String name;
    public String symbol;
    public String slug;
    public Instant date_added;
    public Instant last_updated;
    public String cmc_rank;

}


