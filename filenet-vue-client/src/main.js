import '@babel/polyfill'

import { ApolloClient } from 'apollo-client'
//import { HttpLink } from 'apollo-link-http'
import { createHttpLink } from "apollo-link-http";
import { InMemoryCache } from 'apollo-cache-inmemory'
import { ApolloLink } from 'apollo-link'

import Vue from 'vue';
import VueApollo from 'vue-apollo'
import VueRouter from 'vue-router';
import './plugins/vuetify'
import App from './App.vue'
import { routes } from './routes';

Vue.config.productionTip = false

Vue.use(VueRouter);
const router = new VueRouter ({
    routes,
    mode: 'history'
});

const httpLink = createHttpLink({
  // You should use an absolute URL here
  uri: 'http://192.168.111.82:9080/graphqlserver/graphqlce',
  credentials: 'include'
})

const authMiddleware = new ApolloLink((operation, forward) => {
  // add the authorization to the headers
  const token = localStorage.getItem("sessionKey");
  console.log("Using token " + token);

  operation.setContext({
      headers: {
        cookie: localStorage.getItem('sessionKey') || null,
      }
    });

  return forward(operation)
})

const apolloClient = new ApolloClient({
//  link: authMiddleware.concat(httpLink),
  link: httpLink,
  cache: new InMemoryCache(),
  connectToDevTools: true
})

Vue.use(VueApollo)

const apolloProvider = new VueApollo({
  defaultClient: apolloClient,
  defaultOptions: {
    $loadingKey: 'loading'
  }
})

new Vue({
  render: h => h(App),
  provide: apolloProvider.provide(),
  router
}).$mount('#app')
