var express = require('express');
var mongoose = require('mongoose');

//middlewares

var router = express.Router();
var userModel = mongoose.model('User');

module.exports.controller = function(app){
    router.get('/profile', function (req, res) {
        res.render('profile', {
            title: "User Profile",
            user: req.session.user
        })
    });

    app.use('/user',router);

}; // login controller end
