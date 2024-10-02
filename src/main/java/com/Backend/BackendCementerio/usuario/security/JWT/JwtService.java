package com.Backend.BackendCementerio.usuario.security.JWT;

import javax.crypto.SecretKey;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Service
public class JwtService {

    private static final String SECRET_KEY = "FmBwC9k7xn803ocyDsxDuxJJCIxbc6MwJlKsl89";

    public String getToken(UserDetails usuario) {
        return getToken(new HashMap<>(), usuario);
    }

    public String getToken(Map<String,Object> extraClaim, UserDetails usuario){
        return Jwts
            .builder()
            .setClaims(extraClaim)
            .setSubject(usuario.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }
    private SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
