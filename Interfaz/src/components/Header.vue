<script setup>
import { ref, onMounted } from 'vue'
import {useRouter} from "vue-router";
import {useUserStore} from "@/store/user.js";
import SideMenu from "@/components/SideMenu.vue";

const useStore = useUserStore()
const isLogged = ref(false)
const showMenu = ref(false)

onMounted(() => {
  const tipo = localStorage.getItem('tipoUsuario')
  if (tipo) isLogged.value = true
})


function toggleMenu() {
  showMenu.value = !showMenu.value
}
const router = useRouter()
function nextRouter() {
  router.push('/auth/login')
}
</script>

<template>
  <header>
    <div class="header-container">
      <button
          v-if="useStore.isLogged"
          class="hamburger"
          @click="toggleMenu"
          aria-label="Abrir menú"
      >
        &#9776;
      </button>
      <div class="header-center">
        <img src="../../public/logo_laptop.jpg" alt="Logo de la página" class="logo"/>
        <h1>Más Barato</h1>
      </div>
      <p class="login-link" v-if="!useStore.isLogged" @click="nextRouter">Login</p>
      <p v-else class="login-link" @click="useStore.logout()">Cerrar sesion</p>
    </div>
    <nav v-if="showMenu" class="side-menu">
      <SideMenu></SideMenu>
    </nav>
    <div
        v-if="showMenu"
        class="overlay"
        @click="toggleMenu"
    ></div>

  </header>
</template>

<style scoped>
header {
  width: 97.5%;
  height: 100px;
  background-color: #031925;
  padding: 0 30px;
  display: flex;
  align-items: center;
  justify-content: center;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 3000;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.header-container {
  width: 100%;
  height: 100%;
  position: relative;
}


.hamburger {
  font-size: 32px;
  background: none;
  border: none;
  color: white;
  cursor: pointer;
  position: absolute;
  left: 10px;
  top: 50%;
  transform: translateY(-50%);
}
.header-center {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  display: flex;
  align-items: center;
  gap: 10px;
}
.logo {
  width: 50px;
  height: auto;
}
h1 {
  color: #f4ebd1;
  font-size: 24px;
  margin: 0;
}

.login-link {
  position: absolute;
  right: 10px;
  top: 35%;
  transform: translateY(-50%);
  background-color: #447d85;
  color: #f4ebd1;
  padding: 10px 20px;
  border-radius: 8px;
  font-size: 15px;
  cursor: pointer;
  transition: background 0.2s;
}

.login-link:hover {
  background-color: #5fb0bb;
}

.side-menu {
  position: fixed;
  top: 100px;
  left: 0;
  width: 250px;
  height: calc(100vh - 100px);
  background-color: #031925;
  color: #f4ebd1;
  padding: 20px;
  z-index: 4000;
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  gap: 18px;
}


.overlay {
  position: fixed;
  top: 100px;
  left: 0;
  width: 100%;
  height: calc(100vh - 100px);
  background: rgba(0, 0, 0, 0.55);
  backdrop-filter: blur(3px);
  z-index: 1500;
}
</style>



