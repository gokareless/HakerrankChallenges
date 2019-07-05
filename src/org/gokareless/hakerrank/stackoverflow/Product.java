package org.gokareless.hakerrank.stackoverflow;

import lombok.*;

@Data
@RequiredArgsConstructor(staticName = "of")
@ToString
public class Product {

    final String shopId;
    final String productReference;
}
