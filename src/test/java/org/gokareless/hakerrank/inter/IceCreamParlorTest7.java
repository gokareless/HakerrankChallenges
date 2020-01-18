package org.gokareless.hakerrank.inter;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;

public class IceCreamParlorTest7 {
    
    @Test
    void testCalculate() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        int money = 4;
        IceCreamParlor7 ic = new IceCreamParlor7();
        assertThat(ic.calculateCosts(cost, money), contains(1, 4));
    }

    @Test
    void testCalculate_2() {
        int[] cost = new int[] {2, 2, 4, 3};
        int money = 4;
        IceCreamParlor7 ic = new IceCreamParlor7();
        assertThat(ic.calculateCosts(cost, money), contains(1, 2));
    }

    @Test
    void testCalculate_3() {
        int[] cost = new int[] {7, 2, 5, 4, 11};
        int money = 12;
        IceCreamParlor7 ic = new IceCreamParlor7();
        assertThat(ic.calculateCosts(cost, money), contains(1, 3));
    }

}