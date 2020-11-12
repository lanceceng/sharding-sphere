package com.example.shardingSphere.config;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 分片键值管理器
 * 自定义hint,然后绑定主表与子表
 */
public class HintSharding implements HintShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Long> hintShardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : availableTargetNames) {
            for (Long value : hintShardingValue.getValues()) {
                if (each.endsWith(String.valueOf(value % 2))) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
