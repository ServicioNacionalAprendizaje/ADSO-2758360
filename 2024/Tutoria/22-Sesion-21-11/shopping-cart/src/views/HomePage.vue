<template>
  <ion-page>
    <ion-header>
      <ion-toolbar>
        <ion-title>Gestión de ventas</ion-title>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <ion-grid>
        <ion-row>
          <CardComponent
            title="Clientes"
            description="Administrar clientes registrados en el sistema."
            buttonText="Gestionar Clientes"
            pageLink="/clientes"
          />
          <CardComponent
            title="Servicios"
            description="Administrar servicios disponibles en el sistema."
            buttonText="Gestionar Servicios"
            pageLink="/servicios"
          />
          <CardComponent
            title="Servicios por Cliente"
            description="Administrar los servicios contratados por los clientes."
            buttonText="Gestionar Servicio Cliente"
            pageLink="/servicios-clientes"
          />
        </ion-row>
      </ion-grid>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonRow } from '@ionic/vue';
import CardComponent from '@/components/CardComponent.vue';

export default {
  name: 'HomePage',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonGrid,
    IonRow,
    CardComponent
  }
};
</script>
