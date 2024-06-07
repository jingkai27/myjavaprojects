// Creating a new basic Express server

const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const PORT = 3000;

app.use(bodyParser.json());

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
    todos = todos.map(todo => todo.id === id ? updatedTodo : todo);
    res.json(updatedTodo);
});

// Delete a to-do
app.delete('/todos/:id', (req, res) => {
    const id = parseInt(req.params.id, 10);
    todos = todos.filter(todo => todo.id !== id);
    res.status(204).send();
});

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});


