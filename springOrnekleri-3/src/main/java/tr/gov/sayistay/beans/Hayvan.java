package tr.gov.sayistay.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
@Order(-23)
public class Hayvan extends Canli {

}
