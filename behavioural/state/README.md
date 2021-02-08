# Állapot
 
## DVD lejátszó

Definiáld a `State` absztrakt osztályt. A lejátszó viselkedésit deklarálja:
*	`public abstract void play();`
*	`public abstract void stop();`
*	`public abstract void backward10Frame();`
*	`public abstract void forward10Frame();`
*	`public abstract void pause();`
*	`public abstract void spin();`
*	`public abstract String toString();`
Valamint ezen felül lehetővé teszi, hogy állapotból is lehessen állapotot váltani, ezért
eltárolja függőségként a `DvdPlayerContext` példányát + konstruktor.
A leszármazott konkrét állapot osztályoknak elérhetővé teszi a tárolt kontextust.

### Konkrét állapot osztályok

Hozz létre egy `PlayingState` osztályt, amely a `State` osztályból származik.
Konstruktora megkapja a kontextust, amivel inicilizálja az ős konstruktorát.
Elvárt működés
*	`play`: nem csinál semmit
*	`stop`: A kontextusban lecseréli az állapotot a `StoppedState`-re, a poziciót 0-ra állítja.
*	`backward10Frame`: nem támogatott, kivételt dob
*	`forward10Frame`: nem támogatott, kivételt dob
*	pause: A kontextusban lecseréli az állapotot `StoppedState`-re
*	spin: eggyel növeli a poziciót
*	toString: visszaadja az állapot nevét

Hozz létre egy `StoppedState` osztályt, amely a `State` osztályból származik.
Konstruktora megkapja a kontextust, amivel inicilizálja az ős konstruktorát.
Elvárt működés
*	`play`: A kontextusban lecseréli az állapotot `PlayingState`-re.
*	`stop`: poziciót nulláz
*	`backward10Frame`: poziciót 10 értékkel visszább
*	`forward10Frame`: poziciót 10 értékkel előrébb
*	`pause`: nem csinál semmit
*	`spin`: nem csinál semmit
*	`toString`: visszaadja az állapot nevét

Hozz létre egy `DvdPlayerContext` osztályt. Ez a nyilvános felülete mintának, ezt látják a kliensek.
* attribútumai
  * postion (ahol a lejátszás áll)
  * length (film hossza)
  * state (egy absztrakt State osztály típusú)
* generálj gettereket, settereket.
* konstruktorban állítsa be a `StoppedState`-re az állapotot.
* tartlamaz metódusokat, melyek a viselkedésekért felelősek, azokat delegálja az aktuális állapot metódusainak.