// src/components/TaskList.js
import React, { useState, useEffect } from 'react';
import { getTasks, addTask, deleteTask, completeTask } from '../api';

function TaskList() {
    const [tasks, setTasks] = useState([]);
    const [newTask, setNewTask] = useState('');

    useEffect(() => {
        fetchTasks();
    }, []);

    const fetchTasks = async () => {
        const tasks = await getTasks();
        setTasks(tasks);
    };

    const handleAddTask = async () => {
        if (newTask.trim()) {
            const task = { name: newTask, completed: false };
            const addedTask = await addTask(task);
            setTasks([...tasks, addedTask]);
            setNewTask('');
        }
    };

    const handleDeleteTask = async (id) => {
        await deleteTask(id);
        setTasks(tasks.filter(task => task.id !== id));
    };

    const handleCompleteTask = async (id, completed) => {
        const task = { ...tasks.find(task => task.id === id), completed };
        const updatedTask = await completeTask(id, task);
        setTasks(tasks.map(task => task.id === id ? updatedTask : task));
    };

    return (
        <div>
            <h1>To-Do List</h1>
            <input
                type="text"
                value={newTask}
                onChange={(e) => setNewTask(e.target.value)}
                placeholder="Add a new task"
            />
            <button onClick={handleAddTask}>Add Task</button>
            <ul>
                {tasks.map((task) => (
                    <li key={task.id}>
                        <span style={{ textDecoration: task.completed ? 'line-through' : 'none' }}>
                            {task.name}
                        </span>
                        <button onClick={() => handleCompleteTask(task.id, !task.completed)}>
                            {task.completed ? 'Undo' : 'Complete'}
                        </button>
                        <button onClick={() => handleDeleteTask(task.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TaskList;
