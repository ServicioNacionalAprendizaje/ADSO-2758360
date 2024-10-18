package com.Sena.ShoppingCart.Entity.Security;

import com.Sena.ShoppingCart.Entity.ABaseEntity.ABaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "module_view")
public class ModuleView extends ABaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "module_id", nullable = false)
    private Module moduleId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "view_id", nullable = false)
    private View viewId;

    public Module getModuleId() {
        return moduleId;
    }

    public void setModuleId(Module moduleId) {
        this.moduleId = moduleId;
    }

    public View getViewId() {
        return viewId;
    }

    public void setViewId(View viewId) {
        this.viewId = viewId;
    }
}
