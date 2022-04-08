package tr.gov.sayistay.util;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.springframework.util.Assert;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Named
public class TokenUtil {
	private static final String SECRET_KEY = "VHzUFUla+wctAJLae0CpqnyQdMjEKSoWrLDGKYuWdagNuvOIi1tt61dfw5tdVKWIbeJwi6wiBY88sqCjkSBv2Q==";

	public String getToken(String username) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 15);
		Date sonGecerlilikTarihi = cal.getTime();
		Map<String, Object> claims = new HashMap<>();
		claims.put("roller", username.equals("levent") ? "admin" : "user");

		String jwt = Jwts.builder().setSubject("hastaneLogin").setId(username)
				.setExpiration(sonGecerlilikTarihi).signWith(getKeyFromSecretKey())
				.addClaims(claims).compact();
		return jwt;
	}

	public Claims tokenKontrol(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getKeyFromSecretKey()).build()
				.parseClaimsJws(token).getBody();
		Assert.isTrue("hastaneLogin".equals(claims.getSubject()), "token hatası");
		return claims;
	}

	private static Key getKeyFromSecretKey() {
		byte[] k = Decoders.BASE64.decode(SECRET_KEY);
		Key key = Keys.hmacShaKeyFor(k);
		return key;
	}

	public static void main(String[] args) {
		TokenUtil util = new TokenUtil();
		String token = util.getToken("mahmut");
		System.out.println(util.tokenKontrol(token));

	}
}
