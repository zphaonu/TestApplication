package com.zphaonu.zppalyer.model;

public class TestSingleton {

    static class TestSingletonIn {

        private static TestSingleton newInstace = new TestSingleton();

        private TestSingletonIn() {
        }

        public static TestSingleton getNewInstace() {
            return TestSingletonIn.newInstace;
        }
    }
}
