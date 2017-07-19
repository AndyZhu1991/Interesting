package andy.zhu.interesting.icare;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhujinchang on 2017/7/19.
 */
public class ICareTest {

    @Test
    public void testToString() {
        assertEquals(genTestObject().toString(), "name = abc, age = 123");
    }

    @Test
    public void testHashCode() {
        assertEquals(genTestObject().hashCode(), genTestObject().hashCode());
    }

    @Test
    public void testEquals() {
        assertEquals(genTestObject().hashCode(), genTestObject().hashCode());
    }

    private static TestClass genTestObject() {
        return new TestClass("abc", 123);
    }

    private static class TestClass {

        @ICare
        public String name;

        @ICare
        private int age;

        // Do not care
        private long birthNano;

        public TestClass(String name, int age) {
            this.name = name;
            this.age = age;
            birthNano = System.nanoTime();
        }

        @Override
        public String toString() {
            return Cares.toString(this);
        }

        @Override
        public boolean equals(Object obj) {
            return Cares.equals(this, obj);
        }

        @Override
        public int hashCode() {
            return Cares.hashCode(this);
        }
    }
}
