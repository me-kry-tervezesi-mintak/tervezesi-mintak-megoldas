# Composite

A `RobotPart`-ok (számításigényes robot részek taszkjai) névterekbe (`namespace`) vannak hierarchikusan rendezve. 
Egy névtérben lehetnek `RobotPart` és újabb névterek is.

Csak a `RobotPart` van valójában komplexitás értéke, ami megmutatja, hogy mennyore bonyolult a számítás.

A `Namespace`-nek a szokásos `addChild`, `getChildCount`, `removeChild` műveletei vannak,
amelyek bíztosítja a fa kiépítését.

Ha egy kliensnek szüksége van egy részfában levő levelek (RobotPart) komplexitásának az értékére, akkor ezt meg kell 
határozni (pl.: egy grafikus alkalmazásban drag and droppal áthúzzuk a részfát egy adott node-ra zöld ha mehet, piros ha nem.)

Azért, hogy ne kelljen a kliens oldalon végigjárni a fát (a kliens ne is tudja, hogy fában tároljuk)
kompozit mintát használunk.

Legyen egy `AbstractComponent` interfész, ami lehetővé teszi a két különböző komponens azonos viselkedését.
	```
	int getComplexity();
	int getCount();
	int getRobotPartCount();
	int getNamespaceCount();
	```
	
Mind a RobotPart, mind a Namespace implementálja az előbbi interfészt értelem szerűen.

A `RobotPart` esetén konstruktorban megkapja a komplexitást, amit eltárol egy final attribútumban.
A `getComplexity` ezt adja vissza.

A `Namespace` esetén a komplexitást a gyerek elemeinek a komplexitás összege adja.