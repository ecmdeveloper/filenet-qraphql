<template>

<v-list-tile
  avatar
  @click=""
  >
  <v-list-tile-avatar>
    <v-icon class='grey lighten-1 white--text'>folder</v-icon>
  </v-list-tile-avatar>
  <v-list-tile-content>
    <router-link :to="{ name: 'FolderContent', params: {path: folder.PathName} }">
      <v-list-tile-title>{{ folder.Name }}</v-list-tile-title>
    </router-link>
    <v-list-tile-sub-title>Created by: {{ folder.Creator }} | Created on: {{ (new Date(folder.DateCreated)).toLocaleDateString() }}</v-list-tile-sub-title>
  </v-list-tile-content>
<!--
  <v-list-tile-action>
    <v-btn icon ripple>
      <v-icon color="grey lighten-1">info</v-icon>
    </v-btn>
  </v-list-tile-action>
-->
</v-list-tile>

</template>

<script>
  export default {
    name: 'folder-item',
    props: ['folder']
  }
</script>
