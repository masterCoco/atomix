/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kuujo.copycat.io;

import net.kuujo.copycat.io.util.BloomFilter;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Bloom filter test.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
@Test
public class BloomFilterTest {

  /**
   * Tests adding an element to a bloom filter and then checking that the filter contains that element.
   */
  public void testAddContains() {
    BloomFilter<String> filter = new BloomFilter<>(.1, 100);
    filter.add("Hello world!");
    Assert.assertTrue(filter.contains("Hello world!"));
    Assert.assertFalse(filter.contains("Hello world again!"));
  }

}
