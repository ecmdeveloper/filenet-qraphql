<template>
  <v-list-tile
    avatar
    @click=""
  >
    <v-list-tile-avatar>
      <v-icon class="blue white--text">image</v-icon>
    </v-list-tile-avatar>

    <v-list-tile-content>
      <v-list-tile-title>{{ document.Name }}</v-list-tile-title>
      <v-list-tile-sub-title>Created by: {{ document.Creator }} | Created on: {{ (new Date(document.DateCreated)).toLocaleDateString() }}</v-list-tile-sub-title>
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
    name: 'DocumentItem',
    props: ['document']
  }
</script>
