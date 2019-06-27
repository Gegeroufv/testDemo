package com.shibo.demo.testPojo;

import java.util.ArrayList;
import java.util.Map;

public class deLombok {
    /**
     * 构建者模式好处
     */
    private static class deBuilder{
        private String name;
        private Integer age;
        private Map<String,String> names;

        @java.beans.ConstructorProperties({"name", "age", "names"})
        deBuilder(String name, Integer age, Map<String, String> names) {
            this.name = name;
            this.age = age;
            this.names = names;
        }

        public static DeBuilderBuilder builder() {
            return new DeBuilderBuilder();
        }

        public static class DeBuilderBuilder {
            private String name;
            private Integer age;
            private ArrayList<String> names$key;
            private ArrayList<String> names$value;

            DeBuilderBuilder() {
            }

            public DeBuilderBuilder name(String name) {
                this.name = name;
                return this;
            }

            public DeBuilderBuilder age(Integer age) {
                this.age = age;
                return this;
            }

            public DeBuilderBuilder name(String nameKey, String nameValue) {
                if (this.names$key == null) {
                    this.names$key = new ArrayList<String>();
                    this.names$value = new ArrayList<String>();
                }
                this.names$key.add(nameKey);
                this.names$value.add(nameValue);
                return this;
            }

            public DeBuilderBuilder names(Map<? extends String, ? extends String> names) {
                if (this.names$key == null) {
                    this.names$key = new ArrayList<String>();
                    this.names$value = new ArrayList<String>();
                }
                for (final Map.Entry<? extends String, ? extends String> $lombokEntry : names.entrySet()) {
                    this.names$key.add($lombokEntry.getKey());
                    this.names$value.add($lombokEntry.getValue());
                }
                return this;
            }

            public DeBuilderBuilder clearNames() {
                if (this.names$key != null) {
                    this.names$key.clear();
                    this.names$value.clear();
                }

                return this;
            }

            public deBuilder build() {
                Map<String, String> names;
                switch (this.names$key == null ? 0 : this.names$key.size()) {
                    case 0:
                        names = java.util.Collections.emptyMap();
                        break;
                    case 1:
                        names = java.util.Collections.singletonMap(this.names$key.get(0), this.names$value.get(0));
                        break;
                    default:
                        names = new java.util.LinkedHashMap<String, String>(this.names$key.size() < 1073741824 ? 1 + this.names$key.size() + (this.names$key.size() - 3) / 3 : Integer.MAX_VALUE);
                        for (int $i = 0; $i < this.names$key.size(); $i++)
                            names.put(this.names$key.get($i), this.names$value.get($i));
                        names = java.util.Collections.unmodifiableMap(names);
                }

                return new deBuilder(name, age, names);
            }

            public String toString() {
                return "deLombok.deBuilder.DeBuilderBuilder(name=" + this.name + ", age=" + this.age + ", names$key=" + this.names$key + ", names$value=" + this.names$value + ")";
            }
        }
    }
}
