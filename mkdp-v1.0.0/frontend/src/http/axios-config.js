// axios-config.js
import axios from 'axios';

//axios 인스턴스를 설정하는 모듈 axios-config.js
const api = axios.create({
  baseURL: 'http://localhost:8050/mkdpApp/', // 기본 URL
  headers: {
    'Content-Type': 'application/json'
    // 필요한 경우 다른 헤더를 추가하세요.
  }
});

export default api;
