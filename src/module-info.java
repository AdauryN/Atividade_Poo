module atividadePOO {
    requires java.desktop;
	requires PersistenciaObjetos;
	requires org.junit.jupiter.api;
	requires oblesqbom;
	requires junit;
    exports br.gov.cesarschool.poo.bonusvendas.tela;
    exports br.gov.cesarschool.poo.bonusvendas.testes to junit;
}
