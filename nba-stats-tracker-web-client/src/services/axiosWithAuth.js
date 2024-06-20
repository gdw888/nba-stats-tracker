import axios from 'axios';

// Create an axios instance
const axiosWithAuth = axios.create({
  baseURL: process.env.REACT_APP_API_URL
});

// Set up a request interceptor to add the auth token before each request
axiosWithAuth.interceptors.request.use(
  config => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  error => Promise.reject(error)
);

export default axiosWithAuth;
