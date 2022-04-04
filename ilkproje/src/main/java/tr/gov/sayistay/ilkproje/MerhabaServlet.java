package tr.gov.sayistay.ilkproje;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class MerhabaServlet {
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	// @ResponseBody
	public String deneme() {
		System.out.println("deneme cagirildi");
		return "Merhaba Dünya";
	}
}
