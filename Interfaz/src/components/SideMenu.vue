<script setup>
import MenuItem from "@/components/MenuItem.vue";

const Item = [
  { name: "Ver Trabajadores", url: "/information/employee" },
  { name: "Añadir Laptop", url: "/AddLaptop" }
];
</script>

<template>
  <nav class="menu-container">
    <h2 class="menu-title">Menú</h2>

    <ul class="menu-list">
      <li v-for="(item, index) in Item" :key="index">
        <MenuItem :name="item.name" :url="item.url" />
      </li>
    </ul>
  </nav>
</template>

<style scoped>
.menu-container {
  padding: 25px;
}

.menu-title {
  color: #f4ebd1;
  font-size: 22px;
  font-weight: bold;
  margin-bottom: 30px;
}

.menu-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.menu-list li {
  margin-bottom: 20px;
}
</style>
