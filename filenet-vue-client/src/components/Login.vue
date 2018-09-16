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
     <v-alert
       v-model="alert"
       dismissible
       type="error"
     >
       {{ errorMessage }}
     </v-alert>
   </v-flex>

 </v-layout>
</template>

<script>

  import { LOGIN_MUTATION } from '../constants/graphql'

  export default {
    data: () => ({
      valid: false,
      name: "p8admin",
      password: "Welkom01",
      alert: false,
      errorMessage: ""
    }),
    methods: {
      submit () {
        this.alert = false;
        this.$apollo.mutate({
          mutation: LOGIN_MUTATION,
          variables: {
            username: this.name,
            password: this.password
          }
        }).then((data) => {
          // Result
          console.log(data);
          console.log("Hier:" + data.data.logon);
          localStorage.setItem("sessionKey", data.data.logon);
          this.$router.push({path:'/files'})
        }).catch((error) => {
          // Error
          console.error(error)
          this.alert = true;
          this.errorMessage = error;
        });
      }
    }
  }
</script>
