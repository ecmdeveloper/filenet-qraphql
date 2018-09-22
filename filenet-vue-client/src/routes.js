import Login from './components/Login.vue';
import FolderContent from './components/FolderContent.vue';

export const routes = [
  {path: '', component: Login },
  {path: '/files/:path', name: "FolderContent", component: FolderContent }
];
