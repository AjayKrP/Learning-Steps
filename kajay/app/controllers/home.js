var express = require('express');
var mongoose = require('mongoose');
var router = express.Router();

var userModel = mongoose.model('User');

module.exports.controller = function(app){

  //router for home.
  router.get('/',function(req,res){
    res.redirect('/user/login');
  });

  router.get('/contact', function (req, res, next) {
      res.render('contact',
          { title: 'Contact Us',
          user: req.session.user});
  });

  router.get('/about', function (req, res, next) {
      res.render('about',
          {title: 'About Us',
          user: req.session.user});
  });

  router.get('/news', function (req, res, next) {
      res.render('news',{
         title: 'Latest News',
         user: req.session.user
      })
  });



  app.use(router);

}//home controller end.
