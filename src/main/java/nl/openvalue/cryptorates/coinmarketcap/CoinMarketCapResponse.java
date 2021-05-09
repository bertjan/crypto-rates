package nl.openvalue.cryptorates.coinmarketcap;

import nl.openvalue.cryptorates.data.CryptoCurrency;

import java.util.List;

public class CoinMarketCapResponse {

    private List<CryptoCurrency> data;
    public List<CryptoCurrency> getData() {
        return data;
    }
    public void setData(List<CryptoCurrency> data) {
        this.data = data;
    }

}
