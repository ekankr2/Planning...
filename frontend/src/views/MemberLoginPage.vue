<template>
  <v-container fluid>
    <web-header></web-header>
    <form>
      <v-text-field
          v-model="email"
          :error-messages="emailErrors"
          label="이메일 아이디"
          required
          @input="$v.email.$touch()"
          @blur="$v.email.$touch()"
      ></v-text-field>
      <v-text-field
          v-model="password"
          :error-messages="passwordErrors"
          :counter="20"
          label="비밀번호"
          required
          @input="$v.password.$touch()"
          @blur="$v.password.$touch()"
      ></v-text-field>
      <v-btn xs12 md6
          class="loginButton"
          color="#00c4c4"
          @click="submit"
      >
        submit
      </v-btn>
    </form>

  </v-container>
</template>

<script>
import WebHeader from "../components/WebHeader";
import { validationMixin } from 'vuelidate'
import { required, maxLength, email } from 'vuelidate/lib/validators'


export default {
  name: "MemberLoginPage",
  mixins: [validationMixin],
  components: {
    WebHeader
  },

    validations: {
      password: { required, maxLength: maxLength(20) },
      email: { required, email },
      select: { required },
      checkbox: {
        checked (val) {
          return val
        },
      },
    },

    data: () => ({
      password: '',
      email: '',
      select: null,
      items: [
        'Item 1',
        'Item 2',
        'Item 3',
        'Item 4',
      ],
      checkbox: false,
    }),

    computed: {
      checkboxErrors () {
        const errors = []
        if (!this.$v.checkbox.$dirty) return errors
        !this.$v.checkbox.checked && errors.push('You must agree to continue!')
        return errors
      },
      selectErrors () {
        const errors = []
        if (!this.$v.select.$dirty) return errors
        !this.$v.select.required && errors.push('Item is required')
        return errors
      },
      passwordErrors () {
        const errors = []
        if (!this.$v.password.$dirty) return errors
        !this.$v.password.maxLength && errors.push('비밀번호를 입력해주세요')
        !this.$v.password.required && errors.push('비밀번호를 입력해주세요.')
        return errors
      },
      emailErrors () {
        const errors = []
        if (!this.$v.email.$dirty) return errors
        !this.$v.email.email && errors.push('이메일 형식이 올바르지 않습니다.')
        !this.$v.email.required && errors.push('이메일을 입력해주세요.')
        return errors
      },
    },

    methods: {
      submit () {
        this.$v.$touch()
      },
      clear () {
        this.$v.$reset()
        this.name = ''
        this.email = ''
        this.select = null
        this.checkbox = false
      },
    },
  }
</script>

<style scoped>
form{
  margin: 0 25%;
}
.loginButton{
  margin-top: 20px;
}
</style>