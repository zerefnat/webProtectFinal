<script setup>
import { ref } from 'vue';
import CustomTable from "@/components/CustomTable.vue";

const products = ref([
  { id: 1, name: 'Juan Perez', gmail: "jPerez@gmail.com", rol: 'Almacenero' },
  { id: 2, name: 'Anthony Perdomo', gmail: "apglez25@gmail.com", rol: 'Gestor' },
  { id: 3, name: 'Evelyn B. Nieves', gmail: "eveNievez@gmail.com", rol: 'Gestro' },
  { id: 4, name: 'Juan Perez', gmail: "jPerez@gmail.com", rol: 'Almacenero' },
  { id: 5, name: 'Anthony Perdomo', gmail: "apglez25@gmail.com", rol: 'Gestor' },
  { id: 6, name: 'Evelyn B. Nieves', gmail: "eveNievez@gmail.com", rol: 'Gestro' },
  { id: 7, name: 'Juan Perez', gmail: "jPerez@gmail.com", rol: 'Almacenero' },
  { id: 8, name: 'Anthony Perdomo', gmail: "apglez25@gmail.com", rol: 'Gestor' },
  { id: 9, name: 'Evelyn B. Nieves', gmail: "eveNievez@gmail.com", rol: 'Gestro' },
  { id: 10, name: 'Juan Perez', gmail: "jPerez@gmail.com", rol: 'Almacenero' },
  { id: 12, name: 'Anthony Perdomo', gmail: "apglez25@gmail.com", rol: 'Gestor' },
  { id: 12, name: 'Evelyn B. Nieves', gmail: "eveNievez@gmail.com", rol: 'Gestro' },
]);

const columns = ref([
  { key: 'id', label: 'ID' },
  { key: 'name', label: 'Nombre' },
  { key: 'gmail', label: 'Gmail' },
  { key: 'rol', label: 'Rol' },
  { key: 'actions', label: 'Acciones' }
]);
function editProduct(product) {
  alert(`Editando producto: ${product.name}`);
}

function deleteProduct(product) {
  alert(`Eliminando producto: ${product.name}`);
}
</script>
<template>
  <div id="EmployeeInfo" class="employee-info">
    <header class="employee-header">

      <router-link to="/" class="back-link">
        <svg
            xmlns="http://www.w3.org/2000/svg"
            class="icon"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
        >
          <polyline points="15 18 9 12 15 6" />
        </svg>
        <span>Volver</span>
      </router-link>

      <h2 class="title">Información de los Trabajadores</h2>

      <button class="add-btn" @click="openAddForm">
        <svg
            xmlns="http://www.w3.org/2000/svg"
            class="icon"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
        >
          <line x1="12" y1="5" x2="12" y2="19" />
          <line x1="5" y1="12" x2="19" y2="12" />
        </svg>
        <span>Añadir</span>
      </button>
    </header>

    <CustomTable :columns="columns" :data="products">
      <template #actions="{ item }">
        <button @click="editProduct(item)" class="action-btn edit">Editar</button>
        <button @click="deleteProduct(item)" class="action-btn delete">Eliminar</button>
      </template>

      <template #name="{ item }">
        <strong>{{ item.name }}</strong>
      </template>
    </CustomTable>
  </div>
</template>

<style scoped>
.employee-info {
  background: #f2faf9 ;
  padding: 2rem;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  font-family: 'Quicksand', sans-serif;
  color: #2e2e2e;
}


.employee-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  position: relative;
}


.back-link {
  display: flex;
  align-items: center;
  gap: 0.4rem;
  color: #4a4a4a;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.2s;
}

.back-link:hover {
  color: #2c2c2c;
}

.back-link .icon {
  width: 20px;
  height: 20px;
}

.title {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  font-size: 1.6rem;
  font-weight: 600;
  color: #333;
}

.add-btn {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  background: #447d85;
  color: #f4ebd1;
  border: none;
  padding: 0.6rem 1rem;
  border-radius: 0.6rem;
  font-weight: 500;
  cursor: pointer;
  transition: background 0.25s, transform 0.1s;
}

.add-btn:hover {
  background:#5fb0bb;
  transform: translateY(-1px);
}

.add-btn:active {
  transform: translateY(0);
}

.add-btn .icon {
  width: 18px;
  height: 18px;
}


.action-btn {
  border: none;
  padding: 0.4rem 0.8rem;
  border-radius: 0.4rem;
  cursor: pointer;
  font-size: 0.9rem;
  font-weight: 500;
}

.action-btn.edit {
  background-color: #f7e96b;
  color: #333;
}

.action-btn.delete {
  background-color: #f76b6b;
  color: white;
}
</style>