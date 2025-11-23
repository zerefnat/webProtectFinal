<script setup>
import { ref } from 'vue';
import {useRouter} from "vue-router";
import {useUserStore} from "@/store/user.js";
const useStore = useUserStore()
const router = useRouter()
const { users } = defineProps({
  users: {
    type: Array,
    required: false,
    default: () => [
      {
        gmail: "admin@example.com",
        password: "12345",
        roll: "Admin"
      }
    ],
  },
})
const email = ref();
const password = ref();
const error = ref(null);


const handleSubmit = () => {
  const user = users.find(
      (u) => u.gmail === email.value && u.password === password.value
  );
  if (user) {
    error.value = null;
    useStore.login(user.roll)
    router.push('/')
  } else {
    error.value = "Correo o contraseña incorrectos";
  }
};


</script>

<template>
  <div id="login">
    <div class="login-container">
      <h2><img src="../../public/logo_laptop.jpg" alt="Logo de la página"></h2>
      <form @submit.prevent="handleSubmit">
        <input type="email" id="email" name="email" placeholder="Correo electrónico" required v-model="email"
               @focus="error=null"/>
        <input type="password" id="password" name="password" placeholder="Contraseña" required v-model="password"
               @focus="error=null" />
        <p class="error">{{ error }}</p>
        <button type="submit">Iniciar sesión</button>
      </form>
    </div>
  </div>
</template>

<style scoped>
#login {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f2faf9;
  font-family: Arial, sans-serif;
  padding: 20px;
}

.login-container {
  background: white;
  padding: 40px 30px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 400px;
}

.error {
  color: red;
  margin-bottom: 5px;
  text-align: center;
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

img {
  width: 50%;
  display: block;
  margin: 0 auto;
  padding-bottom: 5px;
}

input {
  width: 95%;
  padding: 12px 15px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1rem;
  transition: border 0.3s;
}

input:focus {
  border-color: #3b82f6;
  outline: none;
}

button {
  width: 100%;
  padding: 12px;
  background: #447d85;
  border: none;
  color: #fdf9eb;
  font-size: 1.1rem;
  border-radius: 5px;
  cursor: pointer;
  transition: background 0.3s;
}

button:hover {
  background: #5fb0bb;
}


@media (max-width: 480px) {
  .login-container {
    padding: 30px 20px;
  }
}
</style>