<template>
  <CrudComponent
    ref="crudComponent"
    title="Clientes"
    :items="processedClientes"
    :current-item="currentItem"
    @save="saveCliente"
    @delete="deleteCliente"
    @edit="editCliente"
  >
    <template #form>
      <ion-item>
        <ion-label position="floating">Documento</ion-label>
        <ion-input v-model="currentItem.documento"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Nombre</ion-label>
        <ion-input v-model="currentItem.nombre"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Correo</ion-label>
        <ion-input v-model="currentItem.correo"></ion-input>
      </ion-item>
    </template>
  </CrudComponent>
</template>

<script>
import CrudComponent from '@/components/CrudComponent.vue';
import { getAllClientes, saveCliente, updateCliente, deleteCliente, findClienteById } from '@/services/cliente-service';
import {
  IonItem,
  IonLabel,
  IonInput,
  IonButton,
  IonModal,
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonPage,
  IonCard,
  IonCardHeader,
  IonCardTitle,
  IonCardContent,
  IonIcon
} from '@ionic/vue';

export default {
  name: 'ClientePage',
  components: {
    CrudComponent,
    IonItem,
    IonLabel,
    IonInput,
    IonButton,
    IonModal,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonPage,
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardContent,
    IonIcon
  },
  data() {
    return {
      currentItem: {
        id: null,
        documento: '',
        nombre: '',
        correo: ''
      },
      clientes: [],
      processedClientes: []
    };
  },
  async mounted() {
    await this.loadClientes();
  },
  methods: {
    async loadClientes() {
      try {
        const clientesData = await getAllClientes();
        this.processedClientes = clientesData.map((item) => ({
          id: item.id,
          nombre: item.nombre,
          Documento: item.documento,          
          Correo: item.correo
        }));
      } catch (error) {
        console.error('Error al cargar clientes:', error);
        alert('Error al cargar la lista de clientes');
      }
    },
    async saveCliente() {
      try {
        if (this.currentItem.id) {
          await updateCliente(this.currentItem, this.currentItem.id);
        } else {
          await saveCliente(this.currentItem);
        }
        await this.loadClientes();
        this.resetForm();
      } catch (error) {
        console.error('Error al guardar cliente:', error);
        alert('Error al guardar el cliente');
      }
    },
    async deleteCliente(id) {
      try {
        await deleteCliente(id);
        await this.loadClientes();
      } catch (error) {
        console.error('Error al eliminar cliente:', error);
        alert('Error al eliminar el cliente');
      }
    },
    async editCliente(id) {
      try {
        console.log('ID del cliente a editar:', id);
        this.currentItem = await findClienteById(id);        
        this.$refs.crudComponent.openEditModal(); 
      } catch (error) {
        console.error(`Error al editar cliente ID ${id}:`, error);
        alert('Error al obtener los datos del cliente para edición');
      }
    },
    resetForm() {
      this.currentItem = { id: null, documento: '', nombre: '', correo: '' };
    }
  }
};
</script>

<style scoped>
.button-group {
  display: flex;
  justify-content: flex-end;
  gap: 6px;
  margin-top: 8px;
}

ion-item {
  --padding-start: 16px;
  --inner-padding-top: 0px; 
  --inner-padding-bottom: 0px;
}

ion-label {
  line-height: 0.2; 
}
</style>
