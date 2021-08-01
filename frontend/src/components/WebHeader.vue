<template>
    <v-app-bar
        app
        color="#8A2BE2"
        dark
    >
      <div class="d-flex align-center hidden-sm-and-down">
        <v-img
            class="shrink mr-1"
            contain
            src="../assets/birdlogo.png"
            transition="scale-transition"
            width="70"

        />

        <v-img
            alt="Left Logo"
            class="hidden-sm-and-down"
            contain
            min-width="130"
            src="../assets/birdname.png"
            width="130"
        />

        <v-img
            alt="Center Logo"
            class="hidden-sm-and-down"
            contain
            min-width="130"
            src="../assets/birdname.png"
            width="130"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
          href="/login"
          text>
        <span class="mr-2 hidden-sm-and-down">로그인</span>
      </v-btn>
      <v-btn
          href="#"
          target="_blank"
          text>
        <span class="mr-2 hidden-sm-and-down">회원가입</span>
      </v-btn>
      <v-app-bar-nav-icon class="hidden-md-and-up"></v-app-bar-nav-icon>
    </v-app-bar>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>

</style>