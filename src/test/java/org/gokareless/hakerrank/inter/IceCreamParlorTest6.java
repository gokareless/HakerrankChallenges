package org.gokareless.hakerrank.inter;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;

public class IceCreamParlorTest6 {
    
    @Test
    void testCalculate() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        int money = 4;
        IceCreamParlor6 ic = new IceCreamParlor6();
        assertThat(ic.calculateCosts(cost, money), contains(1, 4));
    }

    @Test
    void testCalculate_2() {
        int[] cost = new int[] {2, 2, 4, 3};
        int money = 4;
        IceCreamParlor6 ic = new IceCreamParlor6();
        assertThat(ic.calculateCosts(cost, money), contains(1, 2));
    }

    @Test
    void testCalculate_3() {
        int[] cost = new int[] {7, 2, 5, 4, 11};
        int money = 12;
        IceCreamParlor6 ic = new IceCreamParlor6();
        assertThat(ic.calculateCosts(cost, money), contains(1, 3));
    }

}