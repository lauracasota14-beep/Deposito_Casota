# Analisi
La fabbrica produce cioccolatini, tavolette e cioccolata calda.
Ogni prodotto ha tipo di cioccolato e percentuale di cacao.

Classi:
- Cioccolato: proprietà comuni e metodo produce().
- Cioccolatino: forma e ripieno, consuma 2 unità.
- Tavoletta: peso e aggiunte, consuma da 4 a 24 unità.
- CioccolatoCaldo: temperatura e densità, consuma almeno 20 unità.
- Fabbrica: gestisce le 100 unità disponibili ogni giorno.
- Main: avvia e prova il programma.

Le tre classi di prodotto estendono Cioccolato.
La fabbrica controlla la disponibilità prima della produzione.
A esaurimento stampa il resoconto e chiede se continuare.