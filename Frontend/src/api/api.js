import axios from "axios";

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
});

export function setAuth(username, password) {
  const token = btoa(`${username}:${password}`);
  api.defaults.headers.common["Authorization"] = `Basic ${token}`;
}

export function clearAuth() {
  delete api.defaults.headers.common["Authorization"];
}

export default api;
