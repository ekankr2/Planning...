<template>
  <v-container>
    <v-app-bar app color="#8A2BE2" dark>

        <router-link to="/">
        <v-img
            class="shrink mr-1 hidden-sm-and-down"
            contain
            src="../assets/birdlogo.png"
            transition="scale-transition"
            width="70"/>
        </router-link>
        <router-link to="/">
        <v-img
            alt="Left Logo"
            class="hidden-sm-and-down"
            contain
            min-width="130"
            src="../assets/birdname.png"
            width="130"/>
        </router-link>

      <v-row justify="end">
        <router-link to="/">

        <v-img
            alt="Center Logo"
            class="centerLogo hidden-md-and-up ml-10"
            contain
            min-width="150"
            src="../assets/birdname.png"
            width="150"/>

        </router-link>
      </v-row>




      <v-spacer></v-spacer>

      <v-btn
          href="/login"
          text class="hidden-sm-and-down">
        <span class="mr-2 hidden-sm-and-down">로그인</span>
      </v-btn>
      <v-btn
          href="#"
          target="_blank"
          text class="hidden-sm-and-down">
        <span class="mr-2 hidden-sm-and-down">회원가입</span>
      </v-btn>
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer" class="hidden-md-and-up"></v-app-bar-nav-icon>
    </v-app-bar>

      <!-- drawer -->
      <v-navigation-drawer app v-model="nav_drawer" class="purple lighten-1" dark temporary right>
        <v-list nav>
          <v-list-item v-for="navs in nav" :key="navs.title" link :to="navs.route">
            <v-list-item-icon>
              <v-icon>{{ navs.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ navs.text }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <template v-slot:append>
          <div class="pa-2">
            <v-btn block class="font-weight-bold">
              로그아웃
            </v-btn>
          </div>
        </template>
      </v-navigation-drawer>
  </v-container>

</template>

<script>
export default {
  name: "WebHeader",
  data() {
    return{
      nav_drawer: false,
      nav: [
        {
          icon: 'home', text: 'Home', name: 'home', route: '/'
        },
        {
          icon: 'mdi-account-box', text: '로그인', name: 'mdi-account-box', route: '/login'
        },
        {
          icon: 'business', text: '게시판', name: 'business', route: '/materialize'
        }
      ]
    }
  },
  watch: {
    group() {
      this.nav_drawer = false
    }
  }
}
</script>

<style scoped>
div{
  user-select: none;
}




</style>