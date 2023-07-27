package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ht.Le;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LancePropostoStep {

	private Lance lance;

	private List<Lance> lances = new ArrayList();

	private Leilao leilao;
	@Dado("um lance válido")
	public void dado_um_lance_válido() {
		lance = new Lance(new Usuario("hugo"), BigDecimal.TEN);
	}

	@Quando("propoe o lance ao leilão")
	public void quando_propoe_o_lance() {
		leilao = new Leilao("Tablet");
		leilao.propoe(lance);
	}
	@Entao("o lance é aceito")
	public void entao_o_lance_e_aceito() {
		Assertions.assertEquals(1, leilao.getLances().size());
	}


	@Dado("um lance de {double} reais do usuário {string}")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
		lance = new Lance(new Usuario(nomeUsuario), BigDecimal.valueOf(valor));
		lances.add(lance);
	}

	@Quando("propões ao leilão")
	public void propoes_ao_leilao() {
		leilao = new Leilao("Tablet");
		lances.forEach(lance -> leilao.propoe(lance));
	}
	@Então("os lances são aceitos")
	public void os_lances_sao_aceitos() {
		System.out.println(leilao.getLances());
		Assertions.assertEquals(2, leilao.getLances().size());
	}

	@Dado("um lance invalido de {int} reais")
	public void um_lance_invalido_de_reais(int valor) {
		System.out.println(valor);
		lance = new Lance(new Usuario("invalido"), BigDecimal.valueOf(valor));
	}

	@Quando("propoe ao leilao")
	public void propoe_ao_leilao() {
		leilao = new Leilao("Invalido");
		leilao.propoe(lance);
	}
	@Entao("o lance nao e aceito")
	public void o_lance_nao_e_aceito() {
		Assertions.assertEquals(0, leilao.getLances().size());
	}


	@Dado("dois lances")
	public void dois_lances(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> valores = dataTable.asMaps();
		for (Map<String, String> mapa : valores) {
			lance = new Lance(new Usuario(mapa.get("usuario")), new BigDecimal(mapa.get("valor")));

			lances.add(lance);
		}
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		leilao = new Leilao("T");
		lances.forEach(lance -> leilao.propoe(lance));
	}
	@Então("o seguindo lance não é aceito")
	public void o_seguindo_lance_não_é_aceito() {
		Assertions.assertEquals(1, leilao.getLances().size());
	}





}
