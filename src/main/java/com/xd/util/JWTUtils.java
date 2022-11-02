package com.xd.util;


//import com.example.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * jwt工具类
 * 注意：
 * 1.生成的token，是可以通过base64解密的
 * 2.base64解密后，修改再次进行编码，这解密失败
 * 3.无法作废已颁布的token，除非更改秘钥，token一般不会泄露，目前开发一般使用https接口传输，
 * 安全性高
 */
public class JWTUtils {
    //设置过期时间为7天
    private static final long EXPIRE= 1000*60*60*24*7;
    //private static final long EXPIRE= 17*1000;
    //设置秘钥
    private static final String SECRET="nannong";

    //设置token令牌前缀 （非必须，只是为了进一步加强破解难度）
    private static final String TOKEN_PREFIX="nongxiao";
    //设置颁布者
    private static final String SUBJECT="tengerhao";

    /**
     * 根据用户信息生成令牌 ,
     * @param user  将来 自己这个 该参数 替换为  真正项目 登录的 实体类！！！
     * @return

    public static String generatorToken( ){
        String token = Jwts.builder().setSubject(SUBJECT)  //设置颁布者
                //这里是设置 payload信息
                .claim("id",user.getId())
                .claim("name",user.getName())
                .claim("openid",user.getOpenId())
                .claim("username",user.getPassword())
                .setIssuedAt(new Date())    //设置开始时间和过期时间
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET)//设置签名
                .compact();//设置字符串紧凑
        token = TOKEN_PREFIX+token;//给token加入前缀
        return token;
    }
     */

    /**
     * 校验令牌 .判断 令牌是否  成功！！
     * @param token
     * @return
     */
    public static Claims checkJwt(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET)
                    //这里需要将 前缀替换为空串
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        } catch (Exception e) {
            return null;    //校验失败返回null，比如token过期
        }
    }
}
