package org.gokareless.stackoverflow;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                Transaction.of("trans1",
                        LocalDateTime.of(2019, 2, 2, 2, 0, 30),
                        "shop1",
                        "prod1",
                        7,
                        20.80f
                ),
                Transaction.of("trans2",
                        LocalDateTime.of(2019, 2, 2, 2, 1, 20),
                        "shop1",
                        "prod2",
                        100,
                        10.00f
                ),
                Transaction.of("trans3",
                        LocalDateTime.of(2019, 2, 2, 3, 17, 20),
                        "shop2",
                        "prod1",
                        1,
                        30.00f
                ),
                Transaction.of("trans4",
                        LocalDateTime.of(2019, 2, 2, 2, 0, 30),
                        "shop1",
                        "prod1",
                        1,
                        11.30f
                ));
        List<Product> products = transactions.stream()
                // grouping transactions by the same product
                .collect(Collectors.groupingBy(transaction -> Product.of(
                        transaction.getShopId(),
                        transaction.getProductReference())))
                .entrySet().stream()
                // summing all price * quantity occurrences to find top selling
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .mapToDouble(p -> p.getQuantity() * p.getPrice()).sum()))
                .entrySet().stream()
                // sorting by the most expensive ones at the top,
                // limiting to 10 and collecting to the list
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(products);

    }
}
