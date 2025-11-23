<script setup>

import {useUserStore} from '../store/user.js'

const userStore = useUserStore()
defineProps(
    {
      marca: {
        type: String,
        required: true
      },
      modelo: {
        type: String,
        required: true
      },
      precio: {
        type: Number,
        required: true
      },
      imagen: {
        type: String,
        required: true
      },
      descuento: {
        type: Number,
        required: false,
        default: 0
      }
    }
)
</script>

<template>
  <div class="product-card">
    <img :src="imagen" alt="Producto" class="product-img" />

    <div class="product-info">
      <h2>{{marca}} - {{modelo}}</h2>
      <p v-if="descuento > 0">
        <span class="old-price">${{precio.toFixed(2)}}</span>
        <span class="discount-price">
          ${{(precio * (1 - descuento / 100)).toFixed(2)}} ({{descuento}}% off)
        </span>
      </p>
      <p v-else class="price">
        ${{precio.toFixed(2)}}
      </p>
    </div>

    <div class="product-actions">
      <RouterLink to="/Product-details" class="ver-mas">Ver más</RouterLink>

      <button class="add-cart" @click="addToCart" v-if="userStore.isLogged">
        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="white" viewBox="0 0 24 24">
          <path d="M7 4h-2l-1 2h2l3.6 7.59-1.35 2.44c-.16.28-.25.61-.25.97 0 1.11.89 2 2 2h12v-2h-11.42c-.14 0-.25-.11-.25-.25l.03-.12.9-1.63h7.72c.75 0 1.41-.41 1.75-1.03l3.58-6.49c.08-.14.12-.31.12-.48 0-.55-.45-1-1-1h-14.31l-.94-2zm-2 18c-1.1 0-1.99.9-1.99 2s.89 2 1.99 2 2-.9 2-2-.9-2-2-2zm14 0c-1.1 0-1.99.9-1.99 2s.89 2 1.99 2 2-.9 2-2-.9-2-2-2z"/>
        </svg>
      </button>
    </div>
  </div>
</template>

<style scoped>
.product-card {
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  overflow: hidden;
  width: 250px;
  display: flex;
  flex-direction: column;
  transition: transform 0.2s;
}

.product-card:hover {
  transform: translateY(-5px);
}

.product-img {
  width: 100%;
  height: 180px;
  object-fit: cover;
}

.product-info {
  padding: 15px;
  flex-grow: 1;
}

.product-info h2 {
  font-size: 18px;
  margin: 0 0 10px 0;
}

.old-price {
  text-decoration: line-through;
  color: #888;
  margin-right: 10px;
}

.discount-price {
  color: red;
  font-weight: bold;
}

.price {
  font-weight: bold;
  color: #333;
}

.product-actions {
  display: flex;
  background: #031925;
  justify-content: space-between;
  align-items: center;
  padding: 10px 15px;
  border-top: 1px solid #eee;
}

.ver-mas {
  font-size: 16px;
  font-weight: bold;
  color: #f4ebd1;
  text-decoration: none;
  transition: color 0.2s;
}

.ver-mas:hover {
  color: #ffffff;
}

.add-cart {
  background: #447d85;
  border: none;
  border-radius: 5px;
  padding: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: background 0.2s;
}

.add-cart:hover {
  background: #5fb0bb;
}

.add-cart svg {
  fill: #fdf9eb;
}
</style>