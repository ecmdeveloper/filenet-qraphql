<template>
  <v-layout row>
    <v-flex xs12 sm6 offset-sm3>
      <v-form v-model="valid">
       <v-text-field
         v-model="name"
         label="Name"
         required
       ></v-text-field>
       <v-text-field
         v-model="password"
         label="Password"
         type="password"
         required
       ></v-text-field>
       <v-btn @click="submit">Login</v-btn>
     </v-form>
   </v-flex>
 </v-layout>
</template>

<script>
  export default {
    data: () => ({
      valid: false,
      name: "",
      password: ""
    }),
    methods: {
      submit () {
//        alert("Hallo, " + this.name + "!");
        this.$router.push({path:'/files'})
      }
    }
  }
</script>
