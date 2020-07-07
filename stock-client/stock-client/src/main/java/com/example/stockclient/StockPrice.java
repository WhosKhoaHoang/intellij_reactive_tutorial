package com.example.stockclient;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// . This @Data annotation allows us to create a
//   data class similar to what can be done in Kolin.
//   By annotating this class with @Data, we only need
//   to define the properties of this class using fields.
//   Other important methods (like getters and setters)
//   are all provided by lombok
// . The *ArgsConstructor annotations are needed for serialization
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockPrice {
  private String symbol;
  private Double price;
  private LocalDateTime time;
}
