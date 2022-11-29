package ar.edu.unq.criptop2p.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.Collections;
import java.util.Date;

public class TokenUtils {
    private static final  String ACCES_TOKEN_SECRET = "192892197dfe1bbd54a3355c411eb47a688b567c7ef50b8f3a3c7b45297ece2c";
    private static final  Long ACCES_TOEKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String email){
        long expirationTime = ACCES_TOEKEN_VALIDITY_SECONDS + 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e){
            return null;
        }
    }
}
