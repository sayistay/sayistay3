package tr.gov.sayistay.controller;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sayistay.util.TokenUtil;

@RestController
public class LoginController {
	@Inject
	private TokenUtil tokenUtil;

	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<String> login(String username, String password) {
		if (new StringBuilder(username).reverse().toString().equals(password)) {
			// şifre, username'in tersten yazılmışı ise
			// login'e izin ver
			JSONObject json = new JSONObject();
			json.put("token", tokenUtil.getToken(username));
			return ResponseEntity.ok(json.toString());
		} else {
			// izin verme
			JSONObject json = new JSONObject();
			json.put("hata", "Giriş Başarısız");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(json.toString());
		}
	}
}
