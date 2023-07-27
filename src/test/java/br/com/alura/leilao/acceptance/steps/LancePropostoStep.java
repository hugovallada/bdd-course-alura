package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class LancePropostoStep {

	private Lance lance;
	private Leilao leilao;
	@Dado("um lance válido")
	public void dado_um_lance_válido() {
		lance = new Lance(new Usuario("hugo"), BigDecimal.TEN);
	}

	@Quando("propoe o lance")
	public void quando_propoe_o_lance() {
		leilao = new Leilao("Tablet");
		leilao.propoe(lance);
	}
	@Entao("o lance é aceito")
	public void entao_o_lance_e_aceito() {
		Assertions.assertEquals(1, leilao.getLances().size());
	}

}
