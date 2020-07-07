package com.example.stockclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

class WebClientStockClientIntegrationTest {

  private WebClient webClient = WebClient.builder().build();

  @Test
  void shouldRetrieveStockPricesFromService() {
    // given
    WebClientStockClient webClientStockClient = new WebClientStockClient(webClient);

    // when
    Flux<StockPrice> prices = webClientStockClient.pricesFor("SYMBOL");

    // then
    Assertions.assertNotNull(prices);
    Flux<StockPrice> fivePrices = prices.take(5);
    // NOTE: These tests fail (Retries exhausted) but the webClientStockClient
    //       seems to be successfully making requests to the API...Is it that
    //       block() never stops blocking?
    Assertions.assertEquals(5, fivePrices.count().block());
    //Assertions.assertEquals("SYMBOL", fivePrices.blockFirst());
  }
}