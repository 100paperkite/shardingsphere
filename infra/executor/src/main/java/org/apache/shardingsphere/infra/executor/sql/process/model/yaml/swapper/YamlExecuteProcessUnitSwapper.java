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

package org.apache.shardingsphere.infra.executor.sql.process.model.yaml.swapper;

import org.apache.shardingsphere.infra.executor.sql.process.model.ExecuteProcessUnit;
import org.apache.shardingsphere.infra.executor.sql.process.model.yaml.YamlExecuteProcessUnit;
import org.apache.shardingsphere.infra.util.yaml.swapper.YamlConfigurationSwapper;

/**
 * YAML execute process unit swapper.
 */
public final class YamlExecuteProcessUnitSwapper implements YamlConfigurationSwapper<YamlExecuteProcessUnit, ExecuteProcessUnit> {
    
    @Override
    public YamlExecuteProcessUnit swapToYamlConfiguration(final ExecuteProcessUnit data) {
        YamlExecuteProcessUnit result = new YamlExecuteProcessUnit();
        result.setUnitID(data.getUnitID());
        result.setProcessStatus(data.getStatus());
        return result;
    }
    
    @Override
    public ExecuteProcessUnit swapToObject(final YamlExecuteProcessUnit yamlConfig) {
        throw new UnsupportedOperationException("YamlExecuteProcessUnitSwapper.swapToObject");
    }
}
