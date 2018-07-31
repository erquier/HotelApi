function crearCliente(){
  $.post( "http://localhost:4567/crear",


{
  nombre   : $('#nombre').val(),
  email    : $('#email').val(),
  password : $('#password').val(),
  telefono : $('#telefono').val(),
  direccion: $('#direccion').val(),
  estado   : $('#estado').val()
})
   .done(function( data ) {
    alert( "Dato insertado: " + data );
   }, "json" );
}

function verCliente(){
    $.get( "http://localhost:4567/ver/1", function( data ) {

      $( "#nombre" ).html( data.nombre );
    }, "json" );

}
