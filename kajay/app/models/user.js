var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var userSchema = new Schema({
    userId : {type:String,default:"",required:true },
    username : {type:String,default:"",required:true },
    first_name: {type: String},
    last_name: {type: String},
    email : { type:String,default:"",required:true },
    password : { type:String,default:"",required:true },
    createdOn : { type:Date,default:Date.now },
    updatedOn : { type:Date,default:Date.now },
    verified : { type: Boolean, default: false },
    movies : {type: Array, default: [] },
    tv : { type: Array, default: [] },
    books: { type: Array, default: [] },
    quotes: { type: Array, default: [] },
    about_me: { type:String, default: "" },
    relationship_status: { type: String, default: "open" },
    education_history: { type: Array, default: [] }
});

mongoose.model('User',userSchema);
