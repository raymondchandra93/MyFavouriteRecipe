import axios from "axios";

const publicApi = axios.create({
  baseURL: "http://localhost:3030/api/v1/public",
  headers: { "Content-Type": "application/json" }
});

const userApi = axios.create({
    baseURL: "http://localhost:3030/api/v1/user",
    headers: { "Content-Type": "application/json" }
});

export {publicApi, userApi};