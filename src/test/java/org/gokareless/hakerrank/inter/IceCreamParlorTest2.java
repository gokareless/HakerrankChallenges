package org.gokareless.hakerrank.inter;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import org.gokareless.hakerrank.inter.IceCreamParlor2.Tuple;
import org.junit.jupiter.api.Test;

public class IceCreamParlorTest2 {
    
    @Test
    void testCalculate() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        int money = 4;
        assertThat(IceCreamParlor2.calculateCosts(cost, money), contains(1, 4));
    }

    @Test
    void testCalculate_2() {
        int[] cost = new int[] {2, 2, 4, 3};
        int money = 4;
        assertThat(IceCreamParlor2.calculateCosts(cost, money), contains(1, 2));
    }

    @Test
    void testCalculateSums() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        List<Tuple> tuples = IceCreamParlor2.calculateSums(cost, 4);
        assertThat(tuples, hasItem(Tuple.of(1, 5, 3)));
        assertThat(tuples, hasItem(Tuple.of(1, 4, 4)));
    }

}