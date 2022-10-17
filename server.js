let express = require('express');

let app = express();

app.use(express.static(__dirname+'/dist/gerenciador-treinamentos-app'));

app.get('/*',(req, resp)=>{
    resp.sendFile(__dirname+'/dist/gerenciador-treinamentos-app/index.html');
});

app.listen(process.env.PORT || 4200);