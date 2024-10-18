package com.Sena.ShoppingCart.Entity.Security;

import com.Sena.ShoppingCart.Entity.ABaseEntity.ABaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole extends ABaseEntity {
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role roleId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
