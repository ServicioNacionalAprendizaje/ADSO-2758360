<template>
  <CrudComponent
    ref="crudComponent"
    title="Servicios"
    :items="processedServicios"
    :current-item="currentItem"
    @save="saveServicio"
    @delete="deleteServicio"
    @edit="editServicio"
  >
    <template #form>
      <ion-item>
        <ion-label position="floating">Código</ion-label>
        <ion-input v-model="currentItem.codigo"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Nombre</ion-label>
        <ion-input v-model="currentItem.nombre"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label position="floating">Precio Unitario</ion-label>
        <ion-input v-model.number="currentItem.precioUnitario" type="number"></ion-input>
      </ion-item>
    </template>
  </CrudComponent>
</template>

<script>
import CrudComponent from '@/components/CrudComponent.vue';
import { getAllServicios, saveServicio, updateServicio, deleteServicio, findServicioById } from '@/services/servicio-service';
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
  name: 'ServicioPage',
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
        codigo: '',
        nombre: '',
        precioUnitario: null
      },
      servicios: [],
      processedServicios: []
    };
  },
  async mounted() {
    await this.loadServicios();
  },
  methods: {
    async loadServicios() {
      try {
        const serviciosData = await getAllServicios();
        this.processedServicios = serviciosData.map((item) => ({
          id: item.id,
          nombre: item.nombre,
          Código: item.codigo,          
          "Precio Unitario": item.precioUnitario
        }));
      } catch (error) {
        console.error('Error al cargar servicios:', error);
        alert('Error al cargar la lista de servicios');
      }
    },
    async saveServicio() {
      try {
        if (this.currentItem.id) {
          await updateServicio(this.currentItem, this.currentItem.id);
        } else {
          await saveServicio(this.currentItem);
        }
        await this.loadServicios();
        this.resetForm();
      } catch (error) {
        console.error('Error al guardar servicio:', error);
        alert('Error al guardar el servicio');
      }
    },
    async deleteServicio(id) {
      try {
        await deleteServicio(id);
        await this.loadServicios();
      } catch (error) {
        console.error('Error al eliminar servicio:', error);
        alert('Error al eliminar el servicio');
      }
    },
    async editServicio(id) {
      try {
        console.log('ID del servicio a editar:', id);
        this.currentItem = await findServicioById(id);
        console.log('Datos del servicio obtenido:', this.currentItem);
        this.$refs.crudComponent.openEditModal();
      } catch (error) {
        console.error(`Error al editar servicio ID ${id}:`, error);
        alert('Error al obtener los datos del servicio para edición');
      }
    },
    resetForm() {
      this.currentItem = { id: null, codigo: '', nombre: '', precioUnitario: null };
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