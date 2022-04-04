package tr.gov.sayistay.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("Computer")
@Data
public class Bilgisayar {
	@Autowired
	private Disk disk;
}
