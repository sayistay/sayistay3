package denemeler;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

public class Ornek1 {
	private static final String SECRET_KEY = "VHzUFUla+wctAJLae0CpqnyQdMjEKSoWrLDGKYuWdagNuvOIi1tt61dfw5tdVKWIbeJwi6wiBY88sqCjkSBv2Q==";

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 15);
		Date sonGecerlilikTarihi = cal.getTime();
		Key key = getKeyFromSecretKey();
		String jwt = Jwts.builder().setSubject("sayistay").setId("132")
				.setAudience("Levent GÜREN").setExpiration(sonGecerlilikTarihi)
				.signWith(key).compact();
		System.out.println(jwt);
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
