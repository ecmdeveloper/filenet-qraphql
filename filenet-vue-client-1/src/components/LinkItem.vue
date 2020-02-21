<template>
  <div>{{link.Name}} ({{link.Creator}})</div>
</template>

<script>
export default {
  name: 'LinkItem',
  props: ['link']
}
</script>
