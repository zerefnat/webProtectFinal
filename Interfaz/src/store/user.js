import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useUserStore = defineStore('user', () => {
    const isLogged = ref(!!localStorage.getItem('tipoUsuario'))

    function login(tipo) {
        localStorage.setItem('tipoUsuario', tipo)
        isLogged.value = true
    }
    function logout() {
        localStorage.removeItem('tipoUsuario')
        isLogged.value = false
    }

    return { isLogged, login, logout }
})
