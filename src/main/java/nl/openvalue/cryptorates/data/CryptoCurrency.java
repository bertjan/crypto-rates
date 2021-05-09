package nl.openvalue.cryptorates.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Objects;

@Entity
public class CryptoCurrency {

    @Id
    private long id;
    private String name;
    private String symbol;
    private String slug;
    private Instant date_added;
    private Instant last_updated;
    private String cmc_rank;

    public CryptoCurrency() {
    }

    public CryptoCurrency(String name, String symbol, String slug) {
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Instant getDate_added() {
        return date_added;
    }

    public void setDate_added(Instant date_added) {
        this.date_added = date_added;
    }

    public Instant getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Instant last_updated) {
        this.last_updated = last_updated;
    }

    public String getCmc_rank() {
        return cmc_rank;
    }

    public void setCmc_rank(String cmc_rank) {
        this.cmc_rank = cmc_rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoCurrency that = (CryptoCurrency) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(symbol, that.symbol) && Objects.equals(slug, that.slug) && Objects.equals(date_added, that.date_added) && Objects.equals(last_updated, that.last_updated) && Objects.equals(cmc_rank, that.cmc_rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, symbol, slug, date_added, last_updated, cmc_rank);
    }

    @Override
    public String toString() {
        return "CryptoCurrency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", slug='" + slug + '\'' +
                ", date_added=" + date_added +
                ", last_updated=" + last_updated +
                ", cmc_rank='" + cmc_rank + '\'' +
                '}';
    }
}


