/* eslint-disable */
<template>
  <div>
    <h4 v-if="loading">Loading...</h4>
    <link-item
      v-for="link in folder.subFolders"
      :key="link.id"
      :link="link">
    </link-item>
  </div>
</template>

<script>
import { ROOT_FOLDERS_QUERY } from '../constants/graphql'
import LinkItem from './LinkItem'

export default {
  name: 'LinkList',
  data () {
    return {
      folder: {
      subFolders: []
    },
    loading: 0
    }
  },
  components: {
    LinkItem
  },
  apollo: {
    folder: {
      query: ROOT_FOLDERS_QUERY
    }
  }
}
</script>
