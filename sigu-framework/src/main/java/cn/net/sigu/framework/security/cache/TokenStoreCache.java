package cn.net.sigu.framework.security.cache;

import lombok.AllArgsConstructor;
import cn.net.sigu.framework.common.cache.RedisCache;
import cn.net.sigu.framework.common.cache.RedisKeys;
import cn.net.sigu.framework.security.user.UserDetail;
import org.springframework.stereotype.Component;

/**
 * 认证 Cache
 *
 * @author 阿沐 babamu@126.com
 */
@Component
@AllArgsConstructor
public class TokenStoreCache {
    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
