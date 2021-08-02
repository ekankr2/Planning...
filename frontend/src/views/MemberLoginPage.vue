<template>
  <div>
    <v-container>
      <form>
      <v-text-field flat solo
          v-model="email"
          :error-messages="emailErrors"
          label="이메일 아이디"
          required
          @input="$v.email.$touch()"
          @blur="$v.email.$touch()"
      ></v-text-field>

      <v-text-field flat solo
          v-model="password"
          :error-messages="passwordErrors"
          :counter="20"
          label="비밀번호"
          hint="At least 9 characters"
          required
          @input="$v.password.$touch()"
          @blur="$v.password.$touch()"
      ></v-text-field>
      <v-btn
          class="loginButton"
          color="#00c4c4"
          @click="submit">
        로그인
      </v-btn>
      </form>
    </v-container>
  </div>
</template>

<script>
import { validationMixin } from 'vuelidate'
import { required, maxLength, email } from 'vuelidate/lib/validators'


export default {
  name: "MemberLoginPage",
  mixins: [validationMixin],
  components: {

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
      rules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 8 || 'Min 8 characters',
      },
    }),

    computed: {
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

@media screen and (min-width: 768px) {
  form{
    margin: 10% 27%;
  }
}

@media screen and (max-width: 768px) {
  form{
    margin: 5% 10%;
  }
}


.v-btn {
  margin-top: 60px;
  width: 100%;
  min-width: 100%;
  color: #fff;
  font-size: 20px;
  font-weight: 700;
  min-height: 45px;
}
</style>