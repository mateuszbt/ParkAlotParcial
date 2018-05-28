

import java.util.Calendar;
import java.util.Date;

public class Motocicleta extends Veiculo {

    protected static double horaEntrada;
    protected static double horaSaida;

    Date data = new Date();
    double hora = data.getHours();
    double totalAPagar;

    protected Motocicleta(String placa, String modelo, Cliente cliente) {
        super(placa, modelo, cliente);
        horaEntrada = hora;
    }

    @Override
    protected void estacionar(Veiculo veiculo, Estacionamento estacionamento) {
        verificaDisponibilidade(veiculo, estacionamento);
    }

    @Override
    protected void verificaDisponibilidade(Veiculo veiculo, Estacionamento estacionamento) {
        if (estacionamento.qntVagasSobrando > 0 && estacionamento.qntVagasSobrando <= estacionamento.qntVagas) {
            estacionamento.getVagas().add(veiculo);
            estacionamento.contadorMotoEntrada = estacionamento.contadorMotoEntrada + 0.5;
        } else {
            throw new VagaInsuficienteException("Não há vagas para motos");
        }
    }

    @Override
    protected void retirar(Veiculo veiculo, Estacionamento estacionamento) {
        if (estacionamento.qntVagasSobrando <60) {
            estacionamento.getVagas().remove(veiculo);
            estacionamento.contadorMotoSaida = estacionamento.contadorMotoSaida + 0.5;
            System.out.println("Motocicleta da placa: " + placa + " retirado, valor a pagar: R$" + calcularValorEstacionamento());
        } else {
            System.out.println("Não motos estacionados!");
        }
    }

    @Override
    protected double calcularValorEstacionamento() {
        double contadorHora = horaSaida - horaEntrada;
        if (contadorHora <= 1) {
            totalAPagar = 2;
        } else if (contadorHora > 1) {
            totalAPagar = ((contadorHora - 1) * 1.5) + 2;
        }

        return totalAPagar;
    }


    @Override
    public String toString() {
        return "Motocicleta placa= " + placa + ", modelo= " + modelo + ", cliente= " + cliente
                + " Hora entrada= " + horaEntrada;
    }

}

