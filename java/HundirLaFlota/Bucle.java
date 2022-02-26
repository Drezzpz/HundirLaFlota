




for tipoBarco = 0; tipoBarco < 7;tipoBarco++
{

	Jugador.PedirColocarBarco()
	- Tipo de Barco:  tipoBarco
	- ¿Posición Inicial? x,y 
	- ¿Orientacion? o
	  
		Participante.ColocarBarco( t, x, y, o )
			True
			False
	
}	
	
for tipoBarco = 0; tipoBarco < 7;tipoBarco++
{

	while 	Ordenador.PedirColocarBarco() = false
	{
		- Tipo de Barco:  tipoBarco
		- Posición Inicial: random.x, random.y
		- Orientacion: random.o
		  
			Participante.ColocarBarco( t, x, y, o )
				True
				False
	}
}	
	
	
	

	
