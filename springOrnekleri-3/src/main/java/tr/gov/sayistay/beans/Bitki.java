package tr.gov.sayistay.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
// @Primary // aynı tipteki sınıfların hangisinin kullanılacağını belirler.
@Order(45)
public class Bitki extends Canli {

}
