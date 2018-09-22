<template>
  <v-layout row>
    <v-flex xs12 sm10 offset-sm1>
       <v-card>

        <v-list two-line subheader>

          <v-breadcrumbs>
            <v-breadcrumbs-item
              v-for="item in breadcrumbPath"
              :key="item.path"
              :to="{ name: 'Files', params: {path: item.path} }"
            >
              {{ item.name }}
            </v-breadcrumbs-item>
          </v-breadcrumbs>

          <v-subheader inset v-if="folder.subFolders.length !== 0">Folders</v-subheader>

          <v-list-tile
            v-for="item in folder.subFolders"
            :key="item.Name"
            avatar
            @click=""
          >
            <v-list-tile-avatar>
              <v-icon class='grey lighten-1 white--text'>folder</v-icon>
            </v-list-tile-avatar>
            <v-list-tile-content>
              <router-link :to="{ name: 'Files', params: {path: item.PathName} }">
                <v-list-tile-title>{{ item.Name }}</v-list-tile-title>
              </router-link>
              <v-list-tile-sub-title>Created by: {{ item.Creator }} | Created on: {{ (new Date(item.DateCreated)).toLocaleDateString() }}</v-list-tile-sub-title>
            </v-list-tile-content>

            <v-list-tile-action>
              <v-btn icon ripple>
                <v-icon color="grey lighten-1">info</v-icon>
              </v-btn>
            </v-list-tile-action>

          </v-list-tile>

          <v-divider inset></v-divider>

          <v-subheader inset v-if="folder.containedDocuments.length !== 0">Files</v-subheader>
          <v-subheader inset v-else>Folder is empty</v-subheader>

          <v-list-tile
            v-for="item in folder.containedDocuments"
            :key="item.Name"
            avatar
            @click=""
          >
            <v-list-tile-avatar>
              <v-icon class="blue white--text">image</v-icon>
            </v-list-tile-avatar>

            <v-list-tile-content>
              <v-list-tile-title>{{ item.Name }}</v-list-tile-title>
              <v-list-tile-sub-title>Created by: {{ item.Creator }} | Created on: {{ (new Date(item.DateCreated)).toLocaleDateString() }}</v-list-tile-sub-title>
            </v-list-tile-content>

            <v-list-tile-action>
              <v-btn icon ripple>
                <v-icon color="grey lighten-1">info</v-icon>
              </v-btn>
            </v-list-tile-action>
          </v-list-tile>
        </v-list>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>

  import { FOLDER_CONTENT } from '../constants/graphql'

  export default {

    data () {
      return {
        folder: []
      }
    },
    computed: {
      breadcrumbPath: function () {

        var pathName = this.$data.folder.PathName || "";
        if ( pathName === "/") {
          return [{ name: "Root", path: "/"}];
        }

        const parts = pathName.split('/');
        var currentPath = "";

        return parts.map( function(item, index) {
            currentPath += "/" + item;
            return {name: (index === 0 ? "Root" : item ), path: currentPath };
        });
      }
    },
    apollo: {
      folder: {
        query: FOLDER_CONTENT,
        variables() {
          return {
            path: this.$route.params.path === "root" ? "/" : this.$route.params.path
          }
        }
      }
    }
  }
</script>
