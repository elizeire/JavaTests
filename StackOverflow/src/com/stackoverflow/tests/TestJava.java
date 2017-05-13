package com.stackoverflow.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class TestJava {

    public static void main(String[] args) {
        List<TestObj> result = new ArrayList<>();

        List<TestObj> tempList = new ArrayList<>();
        List<TestObj> tempList2 = new ArrayList<>();
        List<TestObj> tempResult = new ArrayList<>();

        int size = 3;

        for (int i = 0; i < size; i++) {
            TestObj testObj = new TestObj();
            testObj.setField1("555");
            testObj.setField2("" + i);
            tempList.add(testObj);

            TestObj testObj2 = new TestObj();
            testObj2.setField1("555");
            testObj2.setField2("" + i);
            tempList2.add(testObj2);

            // tempResult.add(testObj); // <-- if use this, then no concurrency issue
            // tempResult.add(testObj2);
        }

			
        tempResult.addAll(tempList);
        tempResult.addAll(tempList2);

        System.out.println("expecting 6, actual = " + tempResult.size());
 
        FilterComparator comp = new FilterComparator();

        result = tempResult.stream() //
                .filter(new ConcurrentSkipListSet<>(comp)::add)//
                .collect(Collectors.toList());
        System.out.println("expecting 3, actual = " + result.size()); // <-- Here, looks like there is a concurrency issue! 
    }

    public static class TestObj {
        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

    }

    public static class FilterComparator implements Comparator<TestObj> {
    	
        public  int compare(TestObj o1, TestObj o2) {
            if (compareIfSameString(o1.getField1(), o2.getField1()) //
                    && compareIfSameString(o1.getField2(), o2.getField2()) //
            ) {
                return 1;
            }

            return 0;
        }
    }

    public static boolean compareIfSameString(String oldValue, String newValue) {
        if (isReallyEmptyOrNull(oldValue) && isReallyEmptyOrNull(newValue)) {
            return true;
        }

        return  Objects.equals(oldValue, newValue);
    }

    public static boolean isReallyEmptyOrNull(String value) {
        return value == null || "".equals(value.trim());
    }

}