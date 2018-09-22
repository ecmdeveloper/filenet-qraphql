<template>
  <v-layout row>
    <v-flex xs12 sm10 offset-sm1>
       <v-card>

        <v-list two-line subheader>

          <v-breadcrumbs>
            <v-breadcrumbs-item
              v-for="item in breadcrumbPath"
              :key="item.path"
              :to="{ name: 'FolderContent', params: {path: item.path} }"
            >
              {{ item.name }}
            </v-breadcrumbs-item>
          </v-breadcrumbs>

          <v-subheader inset v-if="folder.subFolders.length !== 0">Folders</v-subheader>

          <folder-item
            v-for="item in folder.subFolders"
            :key="item.Name"
            :folder="item"
            >
          </folder-item>

          <v-divider inset></v-divider>

          <v-subheader inset v-if="folder.containedDocuments.length !== 0">Files</v-subheader>

          <v-subheader inset v-if="folder.containedDocuments.length == 0 && folder.subFolders.length === 0">Folder is empty</v-subheader>

          <document-item
            v-for="item in folder.containedDocuments"
            :key="item.Name"
            :document="item"
            >
          </document-item>

        </v-list>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>

  import { FOLDER_CONTENT } from '../constants/graphql'
  import FolderItem from './FolderItem'
  import DocumentItem from './DocumentItem'

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
    },
    components: {
      FolderItem,
      DocumentItem
    }
  }
</script>
