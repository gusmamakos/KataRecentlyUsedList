package com.mamakos;

import org.junit.Test;
import static org.junit.Assert.*;

public class RecentListTest {
    @Test
    public void defaultConstructorTest(){ // test basic add/get functionality works
        RecentList recentList = new RecentList();
        recentList.add("1");
        recentList.add("2");
        recentList.add("3");
        recentList.add("4");
        recentList.add("5");
        recentList.add("6");
        recentList.add("7");
        recentList.add("8");
        recentList.add("9");
        String[] actual = recentList.get();
        int expectedDefaultArraySize = 5;
        assertEquals(expectedDefaultArraySize,actual.length);
    }

    @Test
    public void addGetTest(){ // test basic add/get functionality works
        RecentList recentList = new RecentList(5);
        String expected = "abc";
        recentList.add(expected);
        String actual = recentList.get(0);
        assertEquals(expected,actual);
    }

    @Test
    public void addGetAllTest(){ // test basic add/get functionality works
        RecentList recentList = new RecentList(5);
        recentList.add("abc");
        recentList.add("def");
        String[] expected = {"def", "abc"};
        String[] actual = recentList.get();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getIndexTest(){ // test get by index
        RecentList recentList = new RecentList(5);
        recentList.add("a");
        recentList.add("b");
        recentList.add("c");
        assertEquals("c", recentList.get(0));
        assertEquals("b", recentList.get(1));
        assertEquals("a", recentList.get(2));
    }

    @Test
    public void duplicateEntryTest(){ // test re-adding string, should move to top
        RecentList recentList = new RecentList(5);
        recentList.add("a");
        recentList.add("b");
        recentList.add("c");
        recentList.add("a");
        assertEquals("a", recentList.get(0));
        assertEquals("c", recentList.get(1));
        assertEquals("b", recentList.get(2));
    }

    @Test
    public void insertOverflowHandlingTest(){
        RecentList recentList = new RecentList(5);
        recentList.add("1");
        recentList.add("2");
        recentList.add("3");
        recentList.add("4");
        recentList.add("5");
        recentList.add("6");
        String[] result = recentList.get();
        String[] expected = {"6","5","4","3","2"};
        assertArrayEquals(expected, result);
    }

}