package com.Sena.ShoppingCart.Controller.SecurityController;

import com.Sena.ShoppingCart.Controller.ABaseController;
import com.Sena.ShoppingCart.Entity.Security.User;
import com.Sena.ShoppingCart.IService.ISecurityService.IUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/user")
public class UserController extends ABaseController<User, IUserService> {
    public UserController(IUserService service) {
        super(service, "User");
    }
}
