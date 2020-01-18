package org.gokareless.hakerrank.inter;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;

public class IceCreamParlorTest8 {
    
    @Test
    void testCalculate() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        int money = 4;
        IceCreamParlor8 ic = new IceCreamParlor8();
        assertThat(ic.calculateCosts(cost, money), contains(1, 4));
    }

    @Test
    void testCalculate_2() {
        int[] cost = new int[] {2, 2, 4, 3};
        int money = 4;
        IceCreamParlor8 ic = new IceCreamParlor8();
        assertThat(ic.calculateCosts(cost, money), contains(1, 2));
    }

    @Test
    void testCalculate_3() {
        int[] cost = new int[] {7, 2, 5, 4, 11};
        int money = 12;
        IceCreamParlor8 ic = new IceCreamParlor8();
        assertThat(ic.calculateCosts(cost, money), contains(1, 3));
    }

}