// ajaxUtil.js
import api from './axios-config';

//공통 HTTP 요청 함수를 정의한 모듈.
const ajaxUtil = {
  // POST 요청을 보내는 함수
  ajaxCall(url, param) {
    return new Promise((resolve, reject) => {
      api.post(url, param)
        .then(response => {
          resolve(response.data);
        })
        .catch(error => {
          reject(error);
        });
    });
  },

  // 필요에 따라 다른 HTTP 메서드 (GET, PUT, DELETE 등)을 추가할 수 있습니다.
  // 예: GET 요청 함수
  ajaxGet(url, param) {
    return new Promise((resolve, reject) => {
      api.get(url, { params: param })
        .then(response => {
          resolve(response.data);
        })
        .catch(error => {
          reject(error);
        });
    });
  }
};

export { ajaxUtil };
