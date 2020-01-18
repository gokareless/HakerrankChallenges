package org.gokareless.hakerrank.inter;

import static org.hamcrest.Matchers.*;
import java.util.Set;
import static org.hamcrest.MatcherAssert.*;
import org.gokareless.hakerrank.inter.IceCreamParlor3.Tuple;
import org.junit.jupiter.api.Test;

public class IceCreamParlorTest3 {
    
    @Test
    void testCalculate() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        int money = 4;
        IceCreamParlor3 ic = new IceCreamParlor3();
        assertThat(ic.calculateCosts(cost, money), contains(1, 4));
    }

    @Test
    void testCalculate_2() {
        int[] cost = new int[] {2, 2, 4, 3};
        int money = 4;
        IceCreamParlor3 ic = new IceCreamParlor3();
        assertThat(ic.calculateCosts(cost, money), contains(1, 2));
    }

    @Test
    void testCalculateSums() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        IceCreamParlor3 ic = new IceCreamParlor3();
        Set<Tuple> tuples = ic.calculateSums(cost, 4);
        assertThat(tuples, hasItem(Tuple.of(1, 4, 4)));
    }

}