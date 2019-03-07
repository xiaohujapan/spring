package org.dxh.spring.website.service.redis.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dxh.spring.website.constants.RedisSourceType;
import org.dxh.spring.website.service.redis.RedisService;
import org.dxh.spring.website.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceIml  implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;
	
	public List<Map<Object,Object>> getList(RedisSourceType redisType){
		List<Map<Object,Object>> mapList = new ArrayList<Map<Object,Object>>();
		
		redisTemplate = CommonUtil.resetNewRedisTemplate(redisTemplate, redisType);
		
		
		Set<String> keys = redisTemplate.keys("*");
		for(String key:keys) {
			Map<Object,Object>  userMap = redisTemplate.opsForHash().entries(key);
			mapList.add(userMap);
		}
		return mapList;
	}

}
