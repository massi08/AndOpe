var express = require('express');
var app = module.exports = express();
var dir = __dirname + '/../..';

var bodyParser = require('body-parser');
app.use(bodyParser.json());

// create application/x-www-form-urlencoded parser
app.use(bodyParser.urlencoded({extended: false}));

app.use('/js', express.static('./js'));
app.use('/css', express.static('./css'));
app.use('/fonts/material_icons', express.static('./fonts/material_icons'));
app.use('/img', express.static('./img'));

app.all('/', function (req, res, next) {
    next(); // pass control to the next handler
});

app.get('/', function(req, res){
    res.sendFile(__dirname + '/index.html');
});

app.get('/cours/vuejs/exercice/1', function(req, res){
    res.sendFile(__dirname + '/html_files/vuejs/exercices/exercice1.html');
});

app.get('/cours/vuejs/exercice/2', function(req, res){
    res.sendFile(__dirname + '/html_files/vuejs/exercices/exercice2.html');
});

app.get('/cours/vuejs/exercice/3', function(req, res){
    res.sendFile(__dirname + '/html_files/vuejs/exercices/exercice3.html');
});