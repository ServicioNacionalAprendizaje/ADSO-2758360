<template>
  <CrudComponent ref="crudComponent" title="Servicios Cliente" :items="processedServiciosCliente"
    :current-item="currentItem" @save="saveServicioCliente" @delete="deleteServicioCliente" @edit="editServicioCliente">
    <template #form>
      <ion-item>
        <ion-label position="floating">Cantidad</ion-label>
        <ion-input v-model.number="currentItem.cantidad" type="number"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Total a Pagar</ion-label>
        <ion-input v-model.number="currentItem.totalPagar" type="number"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Cliente</ion-label>
        <ion-select v-model="currentItem.clienteId.id" interface="popover">
          <ion-select-option v-for="cliente in clientes" :key="cliente.id" :value="cliente.id">
            {{ cliente.nombre }}
          </ion-select-option>
        </ion-select>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Servicio</ion-label>
        <ion-select v-model="currentItem.servicioId.id" interface="popover">
          <ion-select-option v-for="servicio in servicios" :key="servicio.id" :value="servicio.id">
            {{ servicio.nombre }}
          </ion-select-option>
        </ion-select>
      </ion-item>
    </template>
  </CrudComponent>
</template>

<script>
import CrudComponent from '@/components/CrudComponent.vue';
import { getAllServiciosCliente, saveServicioCliente, updateServicioCliente, deleteServicioCliente, findServicioClienteById } from '@/services/servicio-cliente-service';
import { getAllClientes } from '@/services/cliente-service';
import { getAllServicios } from '@/services/servicio-service';

import {
  IonItem,
  IonLabel,
  IonInput,
  IonButton,
  IonSelect,
  IonSelectOption,
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
  name: 'ServicioClientePage',
  components: {
    CrudComponent,
    IonItem,
    IonLabel,
    IonInput,
    IonButton,
    IonSelect,
    IonSelectOption,
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
        cantidad: null,
        totalPagar: null,
        clienteId: { id: null },
        servicioId: { id: null }
      },
      serviciosCliente: [],
      clientes: [],
      servicios: [],
      processedServiciosCliente: [] // Lista procesada para mostrar en CrudComponent
    };
  },
  async mounted() {
    await this.loadServiciosCliente();
    await this.loadClientes();
    await this.loadServicios();
  },
  methods: {
    async loadServiciosCliente() {
      try {
        const serviciosClienteData = await getAllServiciosCliente();

        this.processedServiciosCliente = serviciosClienteData.map((item, index) => ({
          id: item.id,
          nombre: `Factura ${index + 1}`, 
          "Cliente": item.clienteId.nombre,
          Cantidad: item.cantidad,
          "Total a Pagar": item.totalPagar,
          "Precio Unitario": item.servicioId.precioUnitario,
          "Servicio": item.servicioId.nombre
        }));
      } catch (error) {
        console.error('Error al cargar servicios del cliente:', error);
        alert('Error al cargar la lista de servicios del cliente');
      }
    },
    async loadClientes() {
      try {
        this.clientes = await getAllClientes();
      } catch (error) {
        console.error('Error al cargar clientes:', error);
        alert('Error al cargar la lista de clientes');
      }
    },
    async loadServicios() {
      try {
        this.servicios = await getAllServicios();
      } catch (error) {
        console.error('Error al cargar servicios:', error);
        alert('Error al cargar la lista de servicios');
      }
    },
    async saveServicioCliente() {
      try {
        if (this.currentItem.id) {
          await updateServicioCliente(this.currentItem, this.currentItem.id);
        } else {
          await saveServicioCliente(this.currentItem);
        }
        await this.loadServiciosCliente();
        this.resetForm();
      } catch (error) {
        console.error('Error al guardar servicio del cliente:', error);
        alert('Error al guardar el servicio del cliente');
      }
    },
    async deleteServicioCliente(id) {
      try {
        await deleteServicioCliente(id);
        await this.loadServiciosCliente();
      } catch (error) {
        console.error('Error al eliminar servicio del cliente:', error);
        alert('Error al eliminar el servicio del cliente');
      }
    },
    async editServicioCliente(id) {
      try {
        console.log('ID del servicio-cliente a editar:', id);
        this.currentItem = await findServicioClienteById(id);
        console.log('Datos del servicio-cliente obtenido:', this.currentItem);
        this.$refs.crudComponent.openEditModal();
      } catch (error) {
        console.error(`Error al editar servicio-cliente ID ${id}:`, error);
        alert('Error al obtener los datos del servicio del cliente para edición');
      }
    },
    resetForm() {
      this.currentItem = { id: null, cantidad: null, totalPagar: null, clienteId: { id: null }, servicioId: { id: null } };
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