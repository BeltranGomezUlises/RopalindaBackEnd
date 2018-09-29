/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils;

import com.ub.ropalinda.utils.commons.reponses.AccessDeniedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class UtilsJWT {

    private static final String PUBLIC_KEY = "k$5*t;ht^L$;h_g76k'H6;hLSas\"n`6"
            + ";hxrE=)?)+g!;h6k'H~0;hr198(\"D^|Hl'~+6k'HSvuMm'P_([";

    /**
     * Generates a jwt for access a system
     *
     * @param userId id of the user requesting token
     * @return Access JWT as string
     */
    public static String token(final int userId) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(String.valueOf(userId));
        builder.setIssuer("auth system");
        builder.setIssuedAt(new Date());
        Date expDate = new Date(System.currentTimeMillis() + (1000 * 60 * 60));
        builder.setExpiration(expDate);
        return builder.signWith(SignatureAlgorithm.HS512, PUBLIC_KEY)
                .compact();
    }

    /**
     * Checks if the accesoToken is valid
     *
     * @param accessToken string token to validate
     * @throws com.ub.ropalinda.utils.commons.reponses.AccessDeniedException if
     * the token is invalid
     */
    public static void validate(String accessToken) throws AccessDeniedException {
        try {
            Jwts.parser().setSigningKey(PUBLIC_KEY).parseClaimsJws(accessToken);
        } catch (ExpiredJwtException | MalformedJwtException
                | SignatureException | UnsupportedJwtException
                | IllegalArgumentException | NullPointerException e) {
            throw new AccessDeniedException();
        }
    }

    public static void main(String[] args) {
        System.out.println(token(1));
    }
    
}
