package denemeler;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

public class Ornek1 {
	private static String SECRET_KEY = "VHzUFUla+wctAJLae0CpqnyQdMjEKSoWrLDGKYuWdagNuvOIi1tt61dfw5tdVKWIbeJwi6wiBY88sqCjkSBv2Q==";

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 15);
		Date sonGecerlilikTarihi = cal.getTime();
		Key key = getKeyFromSecretKey();
		String jwt = Jwts.builder().setSubject("sayistay").setId("132")
				.setAudience("Levent GÜREN").setExpiration(sonGecerlilikTarihi)
				.signWith(key).compact();
		// System.out.println(jwt);
//		jwt = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYXlpc3RheSIsImp0aSI6IjEzMiIsImF1ZCI6IkxldmVudCBHw5xSRU4iLCJleHAiOjE2NDk0MDEyNTF9.mAl8hBuJiz0O5Em2WsUrO-XjLvTyjmCjceZTwkdn3ZZBrdEbWrlvQh5VfkND-0sJGSfmUNVnjDRJshwRNyng_g";
//		SECRET_KEY = "Vj6v2KqUyVx50agqaWsUcjMrqSmJ064MspfTJvzI7uzYa5EC8Nz6PPgJ21erFrEDplZt7o4e6Haxq0Zhn8TRqw==";
		jwt = "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxMzIiLCJhdWQiOiJMZXZlbnQgR8OcUkVOIiwiZXhwIjoxNjQ5NDAxMjUxfQ.mAl8hBuJiz0O5Em2WsUrO-XjLvTyjmCjceZTwkdn3ZZBrdEbWrlvQh5VfkND-0sJGSfmUNVnjDRJshwRNyng_g";
		jwtKontrol(jwt);

	}

	private static void jwtKontrol(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(getKeyFromSecretKey()).build()
				.parseClaimsJws(token).getBody();
		System.out.println("id: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Audience: " + claims.getAudience());

	}

	@SuppressWarnings("unused")
	private static Key getSecretKey() {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		String secretString = Encoders.BASE64.encode(key.getEncoded());
		System.out.println(secretString);
		return key;
	}

	private static Key getKeyFromSecretKey() {
		byte[] k = Decoders.BASE64.decode(SECRET_KEY);
		Key key = Keys.hmacShaKeyFor(k);
		return key;
	}

}
