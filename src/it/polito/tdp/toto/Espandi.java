package it.polito.tdp.toto;

public class Espandi {
	
	public void espandiPronostico(Pronostico p) { // perche' espandi() deve essere privata
		Schedina parziale = new Schedina(p.getN()) ;
		espandi(p, parziale, 0) ;
	}
	
	
	// Livello della ricorsione = singola partita
	// livello = 0 -> schedina con 0 risultati
	// livello = 1 -> schedina con 1 risultato ...
	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		
		// parziale contiene gia'  (livello) valori 
		//		nelle posizioni 0...livello-1 
		// io devo determinare parziale[livello]
		//		(cioe' la livello+1 esima riga)
		// sulla base della previsione in p[livello]
		
		
		if(livello==p.getN()) { // dimensione massima del pronostico
			System.out.println(parziale) ;
			return ;
		} // Si ferma la ricorsione quando il vettore p finisce (cioe' N=13 che sarebbe la 14esima)
		
		
		Previsione prev = p.get(livello) ;
		// In questo modo prendo la riga su cui devo lavorare (cioe' p.get(livello))
		
		// Prova le varie alternative
		for(Risultato r: prev.getValori()) {
			// provo ad aggiungere 'r'
			parziale.add(r);
			
			// faccio la ricorsione 
			espandi(p, parziale, livello+1) ;
			
			// backtrack
			parziale.removeLast();
			
		}
		
	}
	

}
