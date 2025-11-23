<script setup>
import LaptopCart from "@/components/LaptopCart.vue";
const laptops = [
  {
    marca: "Dell",
    modelo: "XPS 13",
    precio: 999.99,
    imagen: "https://example.com/dell-xps13.jpg",
    descuento: 10
  },
  {
    marca: "Apple",
    modelo: "MacBook Air",
    precio: 1199.99,
    imagen: "https://example.com/macbook-air.jpg",
    descuento: 5
  },
  {
    marca: "HP",
    modelo: "Spectre x360",
    precio: 1099.99,
    imagen: "https://example.com/hp-spectre.jpg",
    descuento: 0
  },
  {
    marca: "Dell",
    modelo: "XPS 13",
    precio: 999.99,
    imagen: "https://example.com/dell-xps13.jpg",
    descuento: 10
  },
  {
    marca: "Apple",
    modelo: "MacBook Air",
    precio: 1199.99,
    imagen: "https://example.com/macbook-air.jpg",
    descuento: 5
  },
  {
    marca: "HP",
    modelo: "Spectre x360",
    precio: 1099.99,
    imagen: "https://example.com/hp-spectre.jpg",
    descuento: 0
  },
  {
    marca: "Dell",
    modelo: "XPS 13",
    precio: 999.99,
    imagen: "https://example.com/dell-xps13.jpg",
    descuento: 10
  },
  {
    marca: "Apple",
    modelo: "MacBook Air",
    precio: 1199.99,
    imagen: "https://example.com/macbook-air.jpg",
    descuento: 5
  },
  {
    marca: "HP",
    modelo: "Spectre x360",
    precio: 1099.99,
    imagen: "https://example.com/hp-spectre.jpg",
    descuento: 0
  },
  {
    marca: "Dell",
    modelo: "XPS 13",
    precio: 999.99,
    imagen: "https://example.com/dell-xps13.jpg",
    descuento: 10
  },
  {
    marca: "Apple",
    modelo: "MacBook Air",
    precio: 1199.99,
    imagen: "https://example.com/macbook-air.jpg",
    descuento: 5
  },
  {
    marca: "HP",
    modelo: "Spectre x360",
    precio: 1099.99,
    imagen: "https://example.com/hp-spectre.jpg",
    descuento: 0
  },
];
</script>

<template>
  <main>
    <LaptopCart
        v-for="(item, index) in laptops"
        :key="index"
        :imagen="item.imagen"
        :precio="item.precio"
        :modelo="item.modelo"
        :marca="item.marca"
        :descuento="item.descuento"
    />
  </main>
</template>

<style scoped>
*{
  background: #f2faf9 fixed;
  width: 97.89%;
  height: 100%;
}
main {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
  padding: 20px;

}


@media (max-width: 1024px) {
  main {
    grid-template-columns: repeat(2, 1fr);
  }
}
@media (max-width: 600px) {
  main {
    grid-template-columns: 2fr;
  }
}
</style>