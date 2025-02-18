/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.data.pipeline.mysql.ingest.binlog;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BinlogPositionTest {
    
    @Test
    void assertCompareTo() {
        int position = 10;
        BinlogPosition binlogPosition = new BinlogPosition("mysql-bin.000002", position, 0L);
        assertThat(binlogPosition.compareTo(new BinlogPosition("mysql-bin.000002", position, 0L)), is(0));
        assertThat(binlogPosition.compareTo(new BinlogPosition("mysql-bin.000001", position, 0L)), is(1));
        assertThat(binlogPosition.compareTo(new BinlogPosition("mysql-bin.000003", position, 0L)), is(-1));
        String fileName = "mysql-bin.000001";
        binlogPosition = new BinlogPosition(fileName, 10, 0L);
        assertThat(binlogPosition.compareTo(new BinlogPosition(fileName, 10, 0L)), is(0));
        assertThat(binlogPosition.compareTo(new BinlogPosition(fileName, 9, 0L)), is(1));
        assertThat(binlogPosition.compareTo(new BinlogPosition(fileName, 11, 0L)), is(-1));
        assertThat(binlogPosition.compareTo(null), is(1));
    }
    
    @Test
    void assertToString() {
        assertThat(new BinlogPosition("mysql-bin.000001", 4, 0L).toString(), is("mysql-bin.000001#4"));
    }
}
