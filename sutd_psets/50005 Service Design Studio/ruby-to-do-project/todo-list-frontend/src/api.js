// src/api.js
import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:4567', // Change this to your backend URL
});

export const getTasks = async () => {
    const response = await api.get('/tasks');
    return response.data;
};

export const addTask = async (task) => {
    const response = await api.post('/tasks', task);
    return response.data;
};

export const deleteTask = async (id) => {
    await api.delete(`/tasks/${id}`);
};

export const completeTask = async (id, task) => {
    const response = await api.put(`/tasks/${id}`, task);
    return response.data;
};
