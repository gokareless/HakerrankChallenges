package org.gokareless.hakerrank.alg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StoneDivisionTest {

    @Test
    public void findFactor1() {
        List<Long> list = new ArrayList<>();
        list.addAll(Arrays.asList(2l, 3l, 4l));
        int index = list.size() - 1;
        long pile = 12;
        long root = (long) Math.sqrt(pile);
        assertEquals(4l, StoneDivision.findFactor(pile, list, index, root, pile / pile, list.get(index)));
        System.out.println(list.size());
    }

    @Test
    public void findFactor2() {
        List<Long> list = new ArrayList<>();
        list.addAll(Arrays.asList(2l, 3l, 4l, 6l));
        int index = list.size() - 1;
        long pile = 12;
        long root = (long) Math.sqrt(pile);
        long factor = StoneDivision.findFactor(pile, list, index, root, pile / pile, list.get(index));
        assertEquals(4l, factor);
        System.out.println(list.size());
    }

    @Test
    public void stoneDivision() {
        assertEquals(4, StoneDivision.stoneDivision(12l, new long[] {2l, 3l, 4l}));
        assertEquals(4, StoneDivision.stoneDivision(12l, new long[] {2l, 3l, 4l, 6l}));
        assertEquals(29, StoneDivision.stoneDivision(64l, new long[] {2l, 4l, 8l, 16l, 64l}));
        assertEquals(31, StoneDivision.stoneDivision(64l, new long[] {2l, 4l, 8l, 16l, 32l, 64l}));
    }

    @Test
    public void division() {
        System.out.println(StoneDivisionV2.findLastDivisibleIndex(12, new long[] {2l, 3l, 4l}, 2));
        System.out.println(StoneDivisionV2.findLastDivisibleIndex(4, new long[] {2l, 3l, 4l, 6l}, 2));
        System.out.println(StoneDivisionV2.findLastDivisibleIndex(2, new long[] {2l, 3l, 4l}, 0));
        System.out.println(StoneDivisionV2.findLastDivisibleIndex(12, new long[] {2l, 3l, 4l, 6l}, 2));
    }


    @Test
    public void stoneDivisionV2() {
        assertEquals(4, StoneDivisionV2.stoneDivision(12l, new long[] {2l, 3l, 4l}));
        assertEquals(4, StoneDivisionV2.stoneDivision(12l, new long[] {2l, 3l, 4l, 6l}));
        assertEquals(29, StoneDivisionV2.stoneDivision(64l, new long[] {2l, 4l, 8l, 16l, 64l}));
        assertEquals(31, StoneDivisionV2.stoneDivision(64l, new long[] {2l, 4l, 8l, 16l, 32l, 64l}));
    }

    @Test
    public void stoneDivisionV3() {
        assertEquals(4, StoneDivisionV3.stoneDivision(12l, new long[] {2l, 3l, 4l}));
        assertEquals(4, StoneDivisionV3.stoneDivision(12l, new long[] {2l, 3l, 4l, 6l}));
        assertEquals(29, StoneDivisionV3.stoneDivision(64l, new long[] {2l, 4l, 8l, 16l, 64l}));
        assertEquals(31, StoneDivisionV3.stoneDivision(64l, new long[] {2l, 4l, 8l, 16l, 32l, 64l}));
    }

    @Test
    public void stoneDivisionV4() {
        assertEquals(4, StoneDivisionV4.stoneDivision(12l, new long[] {2l, 3l, 4l}));
    }
}