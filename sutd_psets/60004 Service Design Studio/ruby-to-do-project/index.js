// Creating a new basic Express server

const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');

const app = express();
const PORT = 3000;
const TODO_FILE = 'todos.json';

app.use(bodyParser.json());

// Helper function to read todos from the file
const readTodosFromFile = () => {
    try {
        const data = fs.readFileSync(TODO_FILE, 'utf8');
        return JSON.parse(data);
    } catch (err) {
        return [];
    }
};

// Helper function to write todos to the file
const writeTodosToFile = (todos) => {
    fs.writeFileSync(TODO_FILE, JSON.stringify(todos, null, 2));
};

// Get all to-dos
app.get('/todos', (req, res) => {
    res.json(todos);
});

// Add a new to-do
app.post('/todos', (req, res) => {
    const newTodo = req.body;
    todos.push(newTodo);
    res.status(201).json(newTodo);
});

// Update a to-do
app.put('/todos/:id', (req, res) => {
    const id = parseInt(req.params.id, 10);
    const updatedTodo = req.body;
    let todos = readTodosFromFile();
    todos = todos.map(todo => todo.id === id ? updatedTodo : todo);
    writeTodosToFile(todos);
    res.json(updatedTodo);
});

// Delete a to-do
app.delete('/todos/:id', (req, res) => {
    const id = parseInt(req.params.id, 10);
    let todos = readTodosFromFile();
    todos = todos.filter(todo => todo.id !== id);
    writeTodosToFile(todos);
    res.status(204).send();
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});


