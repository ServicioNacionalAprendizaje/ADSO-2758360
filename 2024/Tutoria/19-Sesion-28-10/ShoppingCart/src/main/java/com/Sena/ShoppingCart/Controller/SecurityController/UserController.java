package com.Sena.ShoppingCart.Controller.SecurityController;

import com.Sena.ShoppingCart.Controller.ABaseController;
import com.Sena.ShoppingCart.Dto.ApiResponseDto;
import com.Sena.ShoppingCart.Entity.Security.User;
import com.Sena.ShoppingCart.IService.ISecurityService.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/user")
public class UserController extends ABaseController<User, IUserService> {
    public UserController(IUserService service) {
        super(service, "User");
    }

    /*@PostMapping("/login")
    public Optional<User> Login(@RequestParam String username, @RequestParam String password) {
        return service.Login("admin", "string");
    }*/

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<ApiResponseDto<Optional<User>>> Loigin(@PathVariable String username, @PathVariable String password) {
        try {
            return ResponseEntity.ok(new ApiResponseDto<Optional<User>>("Datos obtenidos", service.Login(username,password), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Optional<User>>(e.getMessage(), null, false));
        }
    }
}
