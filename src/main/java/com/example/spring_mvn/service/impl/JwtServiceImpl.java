package com.example.spring_mvn.service.impl;

import com.example.spring_mvn.dto.UserRoleModel;
import com.example.spring_mvn.entity.UserRole;
import com.example.spring_mvn.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    @Override
    public String generateToken(UserRoleModel userRoleModel) {
        return createToken(userRoleModel);
    }

    private String createToken(UserRoleModel userRoleModel) {

                 Map<String, Object> claims = new HashMap<>();
                 claims.put("username", userRoleModel.getUsername());
                 claims.put("user_id", userRoleModel.getId());
                 claims.put("role_name", userRoleModel.getRoleName());
                 claims.put("role_id",userRoleModel.getRoleId());

        return Jwts.builder().setSubject(userRoleModel.getUsername().intern())
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 25))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    //    private Claims extractAllClaims(String token) {
//        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token)
//                .getBody();
//    }


}