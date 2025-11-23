<script setup>

</script>

<template>
  <div class="product-details-page">
    <div class="encabezado">
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

      <h2 class="title">Detalles del Producto</h2>

      <div class="header-actions">
        <button class="edit-btn">Editar</button>


        <a
            href="https://wa.me/5355634218?text=Hola%20me%20interesa%20su%20producto!"
            target="_blank"
            rel="noopener noreferrer"
            class="contact-link"
        >
          Contáctanos
        </a>
      </div>
    </div>
    <div class="carusel">
      <button class="nav-btn left">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none"
             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
          <polyline points="15 18 9 12 15 6" />
        </svg>
      </button>

      <img src="https://via.placeholder.com/600x400" alt="fotos de la laptop">

      <button class="nav-btn right">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none"
             stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
          <polyline points="9 6 15 12 9 18" />
        </svg>
      </button>
    </div>
    <div class="details">
      <h3>Nombre del Producto</h3>
      <p>
        Breve descripción del producto. Explica sus principales características,
        materiales o funciones. Ideal para laptops, accesorios o componentes.
      </p>
      <ul>
        <li>Característica 1</li>
        <li>Característica 2</li>
        <li>Característica 3</li>
      </ul>
      <span class="price">Precio: <strong>$999.99</strong></span>
      <button class="add-cart-btn">Agregar al Carrito</button>
    </div>
  </div>
</template>

<style scoped>
.product-details-page {
  padding: 2rem;
  background: #f2faf9 fixed;
  font-family: 'Quicksand', sans-serif;
  color: #2e2e2e;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2rem;
}

.encabezado {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  position: relative;
  max-width: 900px;
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
  color: #1f1f1f;
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

.header-actions {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.edit-btn {
  background: #447d85;
  color: #fff;
  border: none;
  border-radius: 0.5rem;
  padding: 0.5rem 1rem;
  font-weight: 500;
  cursor: pointer;
  transition: background 0.25s;
}
.edit-btn:hover {
  background: #5fb0bb;
}

.contact-link {
  text-decoration: none;
  font-weight: 500;
  color: #4a4a4a;
  border: 1px solid #4a4a4a;
  padding: 0.5rem 1rem;
  border-radius: 0.5rem;
  transition: all 0.25s;
}
.contact-link:hover {
  background: #4a4a4a;
  color: white;
}

.carusel {
  position: relative;
  width: 600px;
  height: 400px;
  border-radius: 1rem;
  overflow: hidden;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
  display: flex;
  align-items: center;
  justify-content: center;
}

.carusel img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.nav-btn {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background: rgba(255, 255, 255, 0.85);
  border: none;
  border-radius: 50%;
  padding: 0.5rem;
  cursor: pointer;
  transition: background 0.2s, transform 0.2s;
}
.nav-btn:hover {
  background: rgba(255, 255, 255, 1);
  transform: translateY(-50%) scale(1.1);
}
.nav-btn svg {
  width: 22px;
  height: 22px;
}
.nav-btn.left {
  left: 0.8rem;
}
.nav-btn.right {
  right: 0.8rem;
}


.details {
  text-align: center;
  max-width: 600px;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.details h3 {
  font-size: 1.5rem;
  font-weight: 600;
}

.details p {
  color: #555;
  line-height: 1.5;
}

.details ul {
  list-style-type: disc;
  padding-left: 1.5rem;
  text-align: left;
  color: #444;
  align-self: center;
}

.price {
  font-size: 1.2rem;
  font-weight: 500;
  color: #222;
}

.add-cart-btn {
  background: #447d85;
  color: white;
  border: none;
  border-radius: 0.6rem;
  padding: 0.7rem 1.5rem;
  font-weight: 500;
  cursor: pointer;
  transition: background 0.25s, transform 0.1s;
}
.add-cart-btn:hover {
  background: #5fb0bb;
  transform: translateY(-1px);
}

@media (max-width: 700px) {
  .carusel {
    width: 100%;
    height: auto;
  }
  .carusel img {
    height: auto;
  }
  .details {
    width: 100%;
    text-align: center;
  }
}
</style>