import { createRouter, createWebHistory } from "vue-router";
import MainLayout from "../layouts/MainLayout.vue";
import AuthLayout from "../layouts/AuthLayout.vue";
import InformationLayout from "../layouts/InformationLayout.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            component: MainLayout,
            children: [
                {
                    path: "",
                    name: "Home",
                    component: () => import("../views/Home.vue"),
                },
            ],
        },
        {
            path: "/auth",
            component: AuthLayout,
            children: [
                {
                    path: "login",
                    name: "Login",
                    component: () => import("../views/Login.vue"),
                },
            ],
        },
        {
            path:"/information",
            component: InformationLayout,
            children:[
                {
                    path: "employee",
                    name: "employeeInformation",
                    component: () => import("../views/EmployeeInfo.vue"),
                }
            ]
        },
        {
            path:"/Product-details",
            component: () => import("../views/ProductDetails.vue"),
        },
        {
            path: "/AddLaptop",
            component: () => import("../views/AddLaptop.vue"),
        }
    ],
});

export default router;
