package org.dxh.spring.website.service.redis;

import java.util.List;
import java.util.Map;

import org.dxh.spring.website.constants.RedisSourceType;

public interface RedisService {
	
	List<Map<Object,Object>> getList(RedisSourceType redisType);
	
}
