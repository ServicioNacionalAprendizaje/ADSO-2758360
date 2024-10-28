package com.Sena.ShoppingCart.Controller.SecurityController;

import com.Sena.ShoppingCart.Controller.ABaseController;
import com.Sena.ShoppingCart.Entity.Security.Person;
import com.Sena.ShoppingCart.IService.ISecurityService.IPersonService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/person")
public class PersonController extends ABaseController<Person, IPersonService> {
    public PersonController(IPersonService service) {
        super(service, "Person");
    }
}
