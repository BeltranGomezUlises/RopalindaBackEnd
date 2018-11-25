/*
 * Copyright (C) 2018 Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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

    private static final String PUBLIC_KEY = "k$5*t;ht^L$;h_g76k'H6;hLSas\"n`6;hxrE=)?)+g!;h6k'H~0;hr198(\"D^|Hl'~+6k'HSvuMm'P_([";

    /**
     * Generates a jwt for access a system
     *
     * @param userId id of the user requesting token
     * @return Access JWT as string
     */
    public static String token(String userId) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(userId);
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

    public static String getSubject(String token) throws AccessDeniedException {
        try {
            return Jwts.parser().setSigningKey(PUBLIC_KEY).parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException | MalformedJwtException
                | SignatureException | UnsupportedJwtException
                | IllegalArgumentException | NullPointerException e) {
            throw new AccessDeniedException();
        }
    }

    public static String tokenWithData(String data) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(data);
        builder.setIssuer("auth system");
        builder.setIssuedAt(new Date());
        Date expDate = new Date(System.currentTimeMillis() + (1000 * 60 * 60));
        builder.setExpiration(expDate);
        return builder.signWith(SignatureAlgorithm.HS512, PUBLIC_KEY).compact();
    }    

}
