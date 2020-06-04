CREATE TABLE Utente(
	Username VARCHAR(16) PRIMARY KEY,
	Password VARCHAR(64) NOT NULL,
	Nome VARCHAR(32) NOT NULL,
	Cognome VARCHAR(32) NOT NULL,
	ComuneResidenza VARCHAR(64) NOT NULL
);

CREATE TABLE Indirizzo(
	ID SERIAL PRIMARY KEY,
	Stato VARCHAR(32) NOT NULL,
	Regione VARCHAR(32) NOT NULL,
	Provincia VARCHAR(32) NOT NULL,
	Citta VARCHAR(32) NOT NULL,	
	Via VARCHAR(32) NOT NULL,
	Civico VARCHAR(6) NOT NULL,
	CAP VARCHAR(8) NOT NULL
);

CREATE TYPE tipoEsercizio AS ENUM ('Ristorante','Alloggio','Attrazione');
CREATE TABLE Esercizio(
	ID SERIAL PRIMARY KEY,
	Denominazione VARCHAR(64) NOT NULL,
	UtenteOwner VARCHAR(16),
	Descrizione VARCHAR(4096),
	Telefono VARCHAR(16),
	Email VARCHAR(32),
	SitoWeb VARCHAR(32),
	Tipo tipoEsercizio NOT NULL,
	ID_indirizzo INT NOT NULL,
	CONSTRAINT ProprietarioFK FOREIGN KEY(UtenteOwner) REFERENCES Utente(Username) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT IndirizzoFK FOREIGN KEY(ID_indirizzo) REFERENCES Indirizzo(ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);
	
CREATE TYPE tipoRecensione AS ENUM ('Ristorante','Alloggio');
CREATE TABLE Recensione(
	ID SERIAL PRIMARY KEY,
	EsercizioID INT,
	Utente VARCHAR(16),
	Titolo VARCHAR(32) NOT NULL,
	Descrizione VARCHAR(2048) NOT NULL,
	Stelle INT NOT NULL,
	Tipo tipoRecensione NOT NULL,
	CONSTRAINT StelleValide CHECK(Stelle BETWEEN 1 AND 5),
	CONSTRAINT UtenteFK FOREIGN KEY(Utente) REFERENCES Utente(Username) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT EsercizioFK_recensione FOREIGN KEY(EsercizioID) REFERENCES Esercizio(ID) ON DELETE CASCADE ON UPDATE NO ACTION,
	CONSTRAINT RecensioneUnica UNIQUE(Utente,EsercizioID)
);

CREATE TABLE RecensioneRistorante(
	RecensioneID INT PRIMARY KEY,
	ValutazioneCucina INT NOT NULL CHECK (ValutazioneCucina BETWEEN 1 AND 5),
	ValutazioneMenu INT NOT NULL CHECK (ValutazioneMenu BETWEEN 1 AND 5),
	ValutazioneServizio INT NOT NULL CHECK (ValutazioneServizio BETWEEN 1 AND 5),
	ValutazioneConto INT NOT NULL CHECK (ValutazioneConto BETWEEN 1 AND 5),
	CONSTRAINT RecensioneFK_ristorante FOREIGN KEY(RecensioneID) REFERENCES Recensione(ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE RecensioneAlloggio(
	RecensioneID INT PRIMARY KEY,
	ValutazionePulizia INT CHECK (ValutazionePulizia BETWEEN 1 AND 5),
	ValutazioneServizio INT CHECK (ValutazioneServizio BETWEEN 1 AND 5),
	ValutazionePrezzo INT CHECK (ValutazionePrezzo BETWEEN 1 AND 5),
	ValutazionePosizione INT CHECK (ValutazionePosizione BETWEEN 1 AND 5),
	ValutazioneCibo INT CHECK (ValutazioneCibo BETWEEN 1 AND 5),
	CONSTRAINT RecensioneFK_alloggio FOREIGN KEY(RecensioneID) REFERENCES Recensione(ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TYPE tipoAlloggio AS ENUM ('Hotel','BedAndBreakfast','Casa');
CREATE TABLE Alloggio(
	EsercizioID INT PRIMARY KEY,
	Stanze INT,
	Bagni INT,
	TV BOOLEAN,
	Parcheggio BOOLEAN,
	WiFi BOOLEAN,
	Piscina BOOLEAN,
	Condizionamento BOOLEAN,
	AnimaliAmmessi BOOLEAN,
	Tipo tipoAlloggio NOT NULL,
	CONSTRAINT EsercizioFK_alloggio FOREIGN KEY(EsercizioID) REFERENCES Esercizio(ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TYPE tipoPensione AS ENUM ('Mezza','Completa');
CREATE TABLE Hotel(
	AlloggioID INT PRIMARY KEY,
	Ristorante BOOLEAN,
	Stelle INT CHECK(Stelle BETWEEN 1 AND 5) NOT NULL,
	Pensione tipoPensione,
	CONSTRAINT AlloggioFK_hotel FOREIGN KEY(AlloggioID) REFERENCES Alloggio(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);
	
CREATE TYPE tipoLetto AS ENUM ('Singolo','Matrimoniale','Singolo&Matrimoniale');
CREATE TABLE BedAndBreakfast(
	AlloggioID INT PRIMARY KEY,
	Reception BOOLEAN,
	VietatoFumare BOOLEAN,
	ServizioBiancheria BOOLEAN,
	Lavatrice BOOLEAN,
	Lavastoviglie BOOLEAN,
	Letto tipoLetto,
	CONSTRAINT AlloggioFK_BB FOREIGN KEY(AlloggioID) REFERENCES Alloggio(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TYPE tipoCasa AS ENUM ('Appartamento','Villa','Mansarda','Trullo');
CREATE TYPE tipoEsterno AS ENUM ('Giardino','Terrazzo');
CREATE TABLE Casa(
	AlloggioID INT PRIMARY KEY,
	Tipo tipoCasa,
	Mq FLOAT,
	Esterno tipoEsterno,
	VietatoFumare BOOLEAN,
	ServizioBiancheria BOOLEAN,
	Lavatrice BOOLEAN,
	Lavastoviglie BOOLEAN,
	Letto tipoLetto,
	CONSTRAINT AlloggioFK_casa FOREIGN KEY(AlloggioID) REFERENCES Alloggio(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TYPE tipoAttrazione AS ENUM ('Museo','Parco','Locale');
CREATE TABLE Attrazione(
	EsercizioID INT PRIMARY KEY,
	OrarioApertura TIME(0) NOT NULL,
	OrarioChiusura TIME(0) NOT NULL,
	PerBambini BOOLEAN,
	Tipo tipoAttrazione,
	CONSTRAINT EsercizioFK_attrazione FOREIGN KEY(EsercizioID) REFERENCES Esercizio(ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE Museo(
	AttrazioneID INT PRIMARY KEY,
	Archeologico BOOLEAN,
	Artistico BOOLEAN,
	Marino BOOLEAN,
	Militare BOOLEAN,
	Scientifico BOOLEAN,
	Naturale BOOLEAN,
	Storico BOOLEAN,
	Virtuale BOOLEAN,
	CONSTRAINT AttrazioneFK_museo FOREIGN KEY(AttrazioneID) REFERENCES Attrazione(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);		

CREATE TABLE Parco(
	AttrazioneID INT PRIMARY KEY,
	Tematico BOOLEAN,
	Divertimenti BOOLEAN,
	CONSTRAINT AttrazioneFK_parco FOREIGN KEY(AttrazioneID) REFERENCES Attrazione(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE Locale(
	AttrazioneID INT PRIMARY KEY,
	Discoteca BOOLEAN,
	Notturno BOOLEAN,
	SalaBallo BOOLEAN,
	SalaEventi BOOLEAN,
	CONSTRAINT AttrazioneFK_locale FOREIGN KEY(AttrazioneID) REFERENCES Attrazione(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE PuntoRistoro(
	EsercizioID INT PRIMARY KEY,
	orarioApertura TIME(0) NOT NULL,
	orarioChiusura TIME(0) NOT NULL,
	SenzaGlutine BOOLEAN,
	VeganFriendly BOOLEAN,
	WiFi BOOLEAN,
	PostiASedere BOOLEAN,
	DaAsporto BOOLEAN,
	Servito BOOLEAN,
	Pizzeria BOOLEAN,
	Braceria BOOLEAN,
	Pub BOOLEAN,
	Ristorante BOOLEAN,
	CONSTRAINT EsercizioFK_puntoristoro FOREIGN KEY(EsercizioID) REFERENCES Esercizio(ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE Pizzeria(
	PuntoRistoroID INT PRIMARY KEY,
	PizzaFritta BOOLEAN,
	SoloCena BOOLEAN,
	FornoElettrico BOOLEAN,
	FornoALegna BOOLEAN,
	CONSTRAINT PuntoRistoroFK_pizzeria FOREIGN KEY(PuntoRistoroID) REFERENCES PuntoRistoro(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE Braceria(
	PuntoRistoroID INT PRIMARY KEY,
	Carne BOOLEAN,
	Pesce BOOLEAN,
	CONSTRAINT PuntoRistoroFK_braceria FOREIGN KEY(PuntoRistoroID) REFERENCES PuntoRistoro(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE Pub(
	PuntoRistoroID INT PRIMARY KEY,
	Birreria BOOLEAN,
	CONSTRAINT PuntoRistoroFK_pub FOREIGN KEY(PuntoRistoroID) REFERENCES PuntoRistoro(EsercizioID) ON DELETE CASCADE ON UPDATE NO ACTION
);