package com.tharsis.person.auth;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.tharsis.person.domain.Person;
import com.tharsis.util.UtilEncrypt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 *
 * @author christian
 */
public class Token {

    private static final Key KEY = new SecretKeySpec(
            DatatypeConverter.parseBase64Binary("com.tharsis.person.auth.security"),
            SignatureAlgorithm.HS512.getJcaName()
    );

    public static String createToken(Person person, String uriInfo) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, KEY)
                .setIssuer(uriInfo)
                .setSubject(UtilEncrypt.encryptToSha1(person.getDni()))
                .setId(UtilEncrypt.encryptToMd5(person.getIdperson().toString()))
                .setIssuedAt(new Date())
                .claim("role", person.getRole().toString())
                .setExpiration(toDate(LocalDateTime.now().plusHours(1L)))
                .compact();
    }

    public static boolean tokenIsValid(String token) {
        try {
            Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static String validateToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody();
        String role = claims.get("role")
                .toString();
        Jwts.parser()
                .requireSubject(claims.getSubject())
                .setSigningKey(KEY)
                .parseClaimsJws(token);

        return role;
    }

    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}
