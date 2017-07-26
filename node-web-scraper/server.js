var accountSid = 'your twilio account sid'; 
var authToken = 'your twilio auth tocken';  
var twilio = require('twilio');
var request = require('request');
var cheerio = require('cheerio');
var regex = new RegExp('SE', 'g')
    url = "http://results.unipune.ac.in/";
    
    request(url, function(error, response, html){
       if(!error) {
           var $ = cheerio.load(html);
           var client = new twilio(accountSid, authToken);
           var course;
           var json = {course:""};
           $('.table').filter(function(){
               var data = $(this).text();
               var filter = data.replace(/\s/g, '').match(/(SE\d{4})/gi);
               console.log(filter);
               if(filter.length == null){
               console.log('Empty!!!');
               }
               if(filter[0] == 'SE2015'){
                client.messages.create({
                body: 'Result...SE2015',
                to: 'your mobile number',  
                from: 'your twilio mobile number' 
            }).then((message) => console.log("message will be sent!!!"));
               }
           })
       }
       else{
       console.log('Error!!!!');
       }
    });
        

