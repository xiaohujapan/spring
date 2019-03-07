package org.dxh.spring.website.utils;

import org.dxh.spring.website.constants.RedisSourceType;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

public class CommonUtil {
	
	
	public static StringRedisTemplate resetNewRedisTemplate(StringRedisTemplate redisTemplate,RedisSourceType redisType) {
		LettuceConnectionFactory lettueConnectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
		redisTemplate.getConnectionFactory();
		lettueConnectionFactory.setDatabase(redisType.getValue());
		redisTemplate.setConnectionFactory(lettueConnectionFactory);
		lettueConnectionFactory.resetConnection();
		return redisTemplate;
	}
	
	
}
