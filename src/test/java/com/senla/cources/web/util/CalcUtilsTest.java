package com.senla.cources.web.util;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(BlockJUnit4ClassRunner.class)
public class CalcUtilsTest {

    @Test
    public void given1And2WhenAddThen3(){
        Integer result = CalcUtils.add(1,2);
        assertEquals(result, Integer.valueOf(3));
    }

    @Test(expected = NullPointerException.class)
    public void alwaysNPE(){
        throw new NullPointerException();
    }

    @Test
    public void given1And2WhenAddThen3_Hamcrest(){
        Integer result = CalcUtils.add(1,2);

        assertThat(result, equalTo(Integer.valueOf(3)));

    }

    @Test
    public void givenList_whenCheck_thenNotEmpty() {
        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, is(not(empty())));
    }

    @Test
    public void givenList_whenCheck_thenPosotiveElements() {
        List<Integer> list = Arrays.asList(5, 2, 4);
        assertThat(list, everyItem(greaterThan(0)));
    }

    @Test
    public void givenMap_whenCheck_thenContains() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        assertThat(map, hasKey(1));
        assertThat(map, hasValue("a"));
        assertThat(map, hasEntry(3, "c"));
    }
//
//    @Test
//    public void givenBean_whenCheckProperty_thenHas() {
//        Animal animal = new Animal("gaf");
//        Dog dog = new Dog("gaf");
//        assertThat(animal, Matchers.<Animal> hasProperty("sound"));
//        assertThat(dog, Matchers.<Animal> hasProperty("sound"));
//    }

}
