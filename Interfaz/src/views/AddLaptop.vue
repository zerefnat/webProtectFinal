<script setup>
import { ref } from "vue";
import CustomSelect from "@/components/CustomSelect.vue";
import CustomTextarea from "@/components/CustomTextarea.vue";
import ImageUploader from "@/components/ImageUploader.vue";

const marca = ref("");
const tarjetaVideo = ref("");
const memoriaRam = ref("");
const tipoAlmacenamiento = ref("");
const procesador = ref("");
const idiomaTeclado = ref("");
const sistemaOperativo = ref("");
const desperfectos = ref("");
const piezas = ref("");
const detalles = ref("");

function handleUrls(newUrls) {
  urls.value = newUrls;
}

const marcas = [
  { value: "hp", text: "HP" },
  { value: "dell", text: "Dell" },
  { value: "lenovo", text: "Lenovo" },
  { value: "asus", text: "ASUS" },
  { value: "acer", text: "Acer" },
  { value: "apple", text: "Apple" },
  { value: "msi", text: "MSI" },
];
const tarjetasVideo = [
  { value: "integrada", text: "Gráfica Integrada (Intel UHD / AMD Vega)" },
  { value: "gtx1650", text: "NVIDIA GTX 1650" },
  { value: "rtx3050", text: "NVIDIA RTX 3050" },
  { value: "rtx3060", text: "NVIDIA RTX 3060" },
  { value: "rtx4070", text: "NVIDIA RTX 4070" },
  { value: "radeonrx6600", text: "AMD Radeon RX 6600" },
];
const memoriasRam = [
  { value: "8gb", text: "8 GB DDR4" },
  { value: "16gb", text: "16 GB DDR4" },
  { value: "32gb", text: "32 GB DDR5" },
  { value: "64gb", text: "64 GB DDR5" },
];
const tiposAlmacenamiento = [
  { value: "hdd", text: "HDD (Disco duro tradicional)" },
  { value: "ssd", text: "SSD SATA" },
  { value: "nvme", text: "SSD NVMe (M.2)" },
  { value: "hybrid", text: "Híbrido (HDD + SSD)" },
];
const procesadores = [
  { value: "i3", text: "Intel Core i3" },
  { value: "i5", text: "Intel Core i5" },
  { value: "i7", text: "Intel Core i7" },
  { value: "ryzen3", text: "AMD Ryzen 3" },
  { value: "ryzen5", text: "AMD Ryzen 5" },
  { value: "ryzen7", text: "AMD Ryzen 7" },
];
const idiomasTeclado = [
  { value: "es", text: "Español (España)" },
  { value: "en_us", text: "Inglés (US)" },
  { value: "fr", text: "Francés (FR)" },
  { value: "de", text: "Alemán (DE)" },
  { value: "pt", text: "Portugués (PT)" },
];

const sistemasOperativos = [
  { value: "windows", text: "Windows 11" },
  { value: "ubuntu", text: "Ubuntu 24.04 LTS" },
  { value: "macos", text: "macOS Ventura" },
  { value: "fedora", text: "Fedora Workstation" },
  { value: "debian", text: "Debian 12" },
];
</script>

<template>
  <div class="add-laptop-container">
    <div class="header">
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
      <h1>Añadir Laptop</h1>
    </div>

    <div class="uploader-section">
      <ImageUploader @update:urls="handleUrls" />
    </div>
    <form class="form-container">
      <p class="note">Los campos marcados con <span>*</span> son obligatorios.</p>
      <CustomSelect label="Marca" :options="marcas" v-model="marca" required />

      <div class="form-group">
        <label for="model">Modelo: *</label>
        <input type="text" id="model" name="model" required />
      </div>

      <div class="form-group">
        <label for="serial">Número de Serie: *</label>
        <input type="text" id="serial" name="serial" required />
      </div>

      <CustomSelect label="Tarjeta de Video" :options="tarjetasVideo" v-model="tarjetaVideo" required/>
      <CustomSelect label="Memoria RAM" :options="memoriasRam" v-model="memoriaRam" required/>
      <CustomSelect label="Tipo de Almacenamiento" :options="tiposAlmacenamiento" v-model="tipoAlmacenamiento" required/>
      <CustomSelect label="Procesador" :options="procesadores" v-model="procesador" required/>
      <CustomSelect label="Idioma del Teclado" :options="idiomasTeclado" v-model="idiomaTeclado" required/>
      <CustomSelect label="Sistema Operativo" :options="sistemasOperativos" v-model="sistemaOperativo" required/>

      <CustomTextarea
          id="desperfectos"
          label="Desperfectos anteriores"
          v-model="desperfectos"
      />

      <CustomTextarea
          id="piezas"
          label="Piezas sustituidas"
          v-model="piezas"
      />

      <CustomTextarea
          id="otros"
          label="Otros detalles"
          v-model="details"
          required
      />
      <button type="submit" class="submit-btn">Añadir Laptop</button>
    </form>
  </div>
</template>

<style scoped>
.add-laptop-container {
  max-width: 800px;
  margin: 40px auto;
  padding: 20px;
  background: #f2faf9;
  border-radius: 12px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.header {
  display: flex;
  align-items: center;
  gap: 12px;
  margin-bottom: 20px;
}

.header .back-link {
  display: flex;
  align-items: center;
  color: #031925;
  text-decoration: none;
  gap: 6px;
}

.header .back-link:hover {
  text-decoration: underline;
}

.header .icon {
  width: 22px;
  height: 22px;
}

.header h1 {
  font-size: 1.6rem;
  color: #031925;
  font-weight: 600;
}

.uploader-section {
  margin-bottom: 30px;
  display: flex;
  justify-content: center;
}

.form-container {
  display: flex;
  flex-direction: column;
  gap: 18px;
}

.note {
  font-size: 0.9rem;
  color: #555;
}

.note span {
  color: #c0392b;
  font-weight: bold;
}

.form-group {
  display: flex;
  flex-direction: column;
}

label {
  font-weight: 500;
  margin-bottom: 6px;
  color: #333;
}

input,
select,
textarea {
  border: 1.5px solid #ccc;
  border-radius: 8px;
  padding: 10px;
  font-size: 1rem;
  transition: border-color 0.2s ease;
}

input:focus,
select:focus,
textarea:focus {
  border-color: #4a6cf7;
  outline: none;
}

.submit-btn {
  background-color: #447d85;
  color: #f4ebd1;
  border: none;
  border-radius: 8px;
  padding: 12px 20px;
  font-size: 1rem;
  font-weight: 500;
  cursor: pointer;
  margin-top: 10px;
  align-self: flex-end;
  transition: background 0.3s ease;
}

.submit-btn:hover {
  background-color: #5fb0bb;
}

@media (max-width: 600px) {
  .add-laptop-container {
    padding: 15px;
  }

  .form-container {
    gap: 14px;
  }

  input,
  select,
  textarea {
    font-size: 0.95rem;
  }

  .submit-btn {
    width: 100%;
  }
}
</style>