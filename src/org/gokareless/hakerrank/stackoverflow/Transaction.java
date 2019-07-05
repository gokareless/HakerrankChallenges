package org.gokareless.hakerrank.stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "of")
public class Transaction {
    String transactionID;
    LocalDateTime transactionDate;
    String shopId;
    String productReference;
    int quantity;
    float price;
}
