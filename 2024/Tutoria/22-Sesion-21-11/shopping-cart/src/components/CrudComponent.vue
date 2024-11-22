<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Gestión de {{ title }}</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <div class="button-group">
        <ion-button @click="goBack">Regresar</ion-button>
        <ion-button @click="openNewModal">Nuevo</ion-button>
      </div>
      <ion-list>
        <ion-card v-for="item in items" :key="item.id">
          <ion-card-header>
            <!-- Muestra el título usando itemTitle -->
            <ion-card-title>{{ itemTitle(item) }}</ion-card-title>
          </ion-card-header>
          <ion-card-content>
            <!-- Excluye 'nombre' del contenido de itemDetails -->
            <p v-for="(value, key) in itemDetails(item)" :key="key">{{ key }}: {{ value }}</p>
            <div class="button-group">
              <ion-button color="primary" size="small" @click="handleEdit(item.id)">
                <ion-icon slot="start" name="create-outline"></ion-icon>
                Editar
              </ion-button>
              <ion-button color="danger" size="small" @click.stop="deleteItem(item.id)">
                <ion-icon slot="start" name="trash-outline"></ion-icon>
                Eliminar
              </ion-button>
            </div>
          </ion-card-content>
        </ion-card>
      </ion-list>

      <!-- Modal -->
      <ion-modal :is-open="isModalOpen" @didDismiss="closeModal">
        <ion-header>
          <ion-toolbar>
            <ion-title>{{ modalTitle }}</ion-title>
            <ion-buttons slot="end">
              <ion-button @click="closeModal">Cerrar</ion-button>
            </ion-buttons>
          </ion-toolbar>
        </ion-header>
        <ion-content>
          <form @submit.prevent="save">
            <slot name="form"></slot>
            <div class="modal-actions">
              <ion-button type="submit" expand="block">Confirmar Cambios</ion-button>
            </div>
          </form>
        </ion-content>
      </ion-modal>
    </ion-content>
  </ion-page>
</template>

<script>
import router from '@/router';

export default {
  name: 'CrudComponent',
  props: {
    title: {
      type: String,
      required: true
    },
    items: {
      type: Array,
      default: () => []
    },
    currentItem: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      isModalOpen: false,
      modalTitle: ''
    };
  },
  methods: {
    goBack() {
      window.location.href = '/home';
    },
    openNewModal() {
      this.modalTitle = 'Nuevo Registro';
      this.$emit('update:currentItem', {}); 
      this.isModalOpen = true;
    },
    openEditModal() {
      this.modalTitle = 'Editar Registro';
      this.isModalOpen = true;
    },
    closeModal() {
      this.isModalOpen = false;
    },
    save() {
      this.$emit('save');
      this.closeModal();
    },
    deleteItem(id) {
      this.$emit('delete', id);
    },
    handleEdit(id) {
      this.$emit('edit', id);
    },
    itemTitle(item) {
      return item.nombre || 'Sin Título';
    },
    itemDetails(item) {
      const { id, nombre, ...details } = item;
      return details;
    }
  }
};
</script>

<style scoped>
.button-group {
  display: flex;
  justify-content: flex-end;
  gap: 8px;
  margin-top: 8px;
}

.modal-actions {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-top: 16px;
}
</style>