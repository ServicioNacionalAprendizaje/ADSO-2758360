package com.Sena.ShoppingCart.Controller.SecurityController;

import com.Sena.ShoppingCart.Controller.ABaseController;
import com.Sena.ShoppingCart.Entity.Security.Module;
import com.Sena.ShoppingCart.IService.ISecurityService.IModuleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/module")
public class ModuleController extends ABaseController<Module, IModuleService> {
    public ModuleController(IModuleService service) {
        super(service, "Module");
    }
}
