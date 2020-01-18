package org.gokareless.hakerrank.inter;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.Test;

public class IceCreamParlorTest5 {
    
    @Test
    void testCalculate() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        int money = 4;
        IceCreamParlor5 ic = new IceCreamParlor5();
        assertThat(ic.calculateCosts(cost, money), contains(1, 4));
    }

    @Test
    void testCalculate_2() {
        int[] cost = new int[] {2, 2, 4, 3};
        int money = 4;
        IceCreamParlor5 ic = new IceCreamParlor5();
        assertThat(ic.calculateCosts(cost, money), contains(1, 2));
    }

}