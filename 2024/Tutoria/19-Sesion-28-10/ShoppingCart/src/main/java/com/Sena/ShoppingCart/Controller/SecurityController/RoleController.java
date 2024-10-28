package com.Sena.ShoppingCart.Controller.SecurityController;

import com.Sena.ShoppingCart.Controller.ABaseController;
import com.Sena.ShoppingCart.Entity.Security.Role;
import com.Sena.ShoppingCart.IService.ISecurityService.IRoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/role")
public class RoleController extends ABaseController<Role, IRoleService> {
    public RoleController(IRoleService service) {
        super(service, "Role");
    }
}
