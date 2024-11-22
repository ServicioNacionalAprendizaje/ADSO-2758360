import { createRouter, createWebHistory } from '@ionic/vue-router';
import type { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import ClientePage from '../views/ClientePage.vue';
import ServicioPage from '../views/ServicioPage.vue';
import ServicioClientePage from '../views/ServicioClientePage.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/clientes',
    name: 'Clientes',
    component: ClientePage
  },
  {
    path: '/servicios',
    name: 'Servicios',
    component: ServicioPage
  },
  {
    path: '/servicios-clientes',
    name: 'ServicioCliente',
    component: ServicioClientePage
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router;
