import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Estacionamento {

    public double qntVagas = 3;
    public double qntVagasSobrando = qntVagas;
    public double contadorCarroEntrada;
    public double contadorMotoEntrada;
    public double contadorCarroSaida;
    public double contadorMotoSaida;
    public double vagasPRetirar;

    private List<Veiculo> vagas = new ArrayList<Veiculo>();

    public void estaciona(Veiculo v) {
        v.estacionar(v, this);
        qntVagasSobrando = qntVagas - (contadorCarroEntrada + contadorMotoEntrada);
        vagasPRetirar = qntVagasSobrando;
        contadorCarroSaida = 0;
        contadorMotoSaida = 0;

    }

    //revisar
    public void retira(Veiculo v) {
        v.retirar(v, this);
        qntVagasSobrando = vagasPRetirar + (contadorCarroSaida + contadorMotoSaida);
        contadorCarroEntrada = 0;
        contadorMotoEntrada = 0;
    }


	public void listarVeiculos() {		
		Collections.sort(vagas, new PlacaProvider());
		for(Veiculo v : vagas){
			System.out.println(v.toString());
		}
	}

	public List<Veiculo> getVagas() {
		return vagas;
	}

	public void setVagas(List<Veiculo> vagas) {
		this.vagas = vagas;
	}

}
