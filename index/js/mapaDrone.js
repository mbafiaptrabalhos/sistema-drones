var teste_drone = [{
    iddrone: "1",
    latitude: "-23.594928",
    longitude: "-46.687030",
    temperatura: "27",
    umidade: "55",
    email: "agronegocio@controlador.com"
},
{
    iddrone: "2",
    latitude: "-23.592490",
    longitude: "-46.681022",
    temperatura: "26",
    umidade: "57",
    email: "WHOOOOPS@controlador.com"
}]

var mymap = L.map('mapid').setView([teste_drone[0].latitude, teste_drone[0].longitude], 14);


L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(mymap);





for (var i = 0; i < teste_drone.length; i++){
    var id = teste_drone[i].iddrone;
    var latitude = teste_drone[i].latitude;
    var longitude = teste_drone[i].longitude;
    var temperatura = teste_drone[i].temperatura;
    var umidade = teste_drone[i].umidade;
    var email = teste_drone[i].email;

    // Adiciona marcador
    var marker = L.marker([latitude, longitude]).addTo(mymap);

    // Adiciona Popup
    marker.bindPopup(`
    Id: ${id} </br>
    Latitude: ${latitude}
    Longitude: ${longitude}
    Temperatura: ${temperatura}
    Umidade: ${umidade} </br>
    Email: ${email}
            `).openPopup();

}








