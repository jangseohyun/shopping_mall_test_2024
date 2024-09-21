import { createRouter, createWebHistory } from 'vue-router';
import ProductDetail from '@/components/ProductDetail.vue'; // 상품 상세 컴포넌트

const routes = [
  {
    path: '/',
  },
  {
    path: '/:productId', // 상품 상세 페이지로 이동하는 URL
    name: 'ProductDetail',
    component: ProductDetail,
    props: true,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
