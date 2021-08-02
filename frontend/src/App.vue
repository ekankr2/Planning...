<template>
  <v-app>
    <web-header></web-header>
    <v-main>
      <router-view>
      </router-view>
    </v-main>
  </v-app>
</template>

<script>
import WebHeader from "./components/WebHeader";
export default {
  name: 'App',
  components: {
    WebHeader
  },

  data: () => ({
    //
  }),
};
</script>
