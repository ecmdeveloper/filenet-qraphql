import Login from './components/Login.vue';
import Files from './components/Files.vue';

export const routes = [
  {path: '', component: Login },
  {path: '/files/:path', name: "Files", component: Files }
];
