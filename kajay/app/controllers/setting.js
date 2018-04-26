var express = require('express');
var mongoose = require('mongoose');

//middlewares

var router = express.Router();
var userModel = mongoose.model('User');

module.exports.controller = function(app){
    router.get('/setting', function (req, res) {
       res.render('setting', {
           title: "Profile Setting",
           user: req.session.user
       })
    });
    router.post('/api/v1/setting', function (req, res, next) {
        
        var temp = req.body;
        var details = new userModel({
            first_name: temp.firstname,
            last_name: temp.lastname,
            about_me: temp.about_me
        });

        userModel.update(details,{username: req.session.user.username}, function (err) {
           if (err) {
               throw err;
           }
           else {
               console.log(req.session.user._id+ '==============================================' );
               res.redirect('/user/profile');
           }
        });
    });

    app.use('/user',router);

}; // login controller end
