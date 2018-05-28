

import java.util.Date;

public class Automovel extends Veiculo {

    protected double horaEntrada;
    protected double horaSaida;

    Date data = new Date();
    double hora = data.getHours();
    double totalAPagar;

    protected Automovel(String placa, String modelo, Cliente cliente) {
        super(placa, modelo, cliente);
        horaEntrada = hora;
    }

    @Override
    protected void estacionar(Veiculo veiculo, Estacionamento estacionamento) {
        verificaDisponibilidade(veiculo, estacionamento);

    }

    @Override
    protected void retirar(Veiculo veiculo, Estacionamento estacionamento) {
        if (estacionamento.qntVagasSobrando < 59.5) {
            estacionamento.getVagas().remove(veiculo);
            estacionamento.contadorCarroSaida++;
            System.out.println("Automovel da placa: " + placa + " retirado, valor a pagar: R$" + calcularValorEstacionamento());
        } else {
            System.out.println("Não há carros estacionados!");
        }
    }

    @Override
    protected void verificaDisponibilidade(Veiculo veiculo, Estacionamento estacionamento) {
        if (estacionamento.qntVagasSobrando != 0.5 && estacionamento.qntVagasSobrando > 0) { // estacionamento.qntVagasSobrando >0.5 && estacionamento.qntVagasSobrando <=60 ){
            estacionamento.getVagas().add(veiculo);
            estacionamento.contadorCarroEntrada++;
        } else {
            throw new VagaInsuficienteException("Não há vagas para Carro");
        }
    }

    @Override
    protected double calcularValorEstacionamento() {
        double contadorHora = horaSaida - horaEntrada;
        if (contadorHora <= 1) {
            totalAPagar = 2;
        } else if (contadorHora > 1) {
            totalAPagar = ((contadorHora - 1) * 2.5) + 2;
        }

        return totalAPagar;
    }

    @Override
    public String toString() {
        return "Automovel placa= " + placa + ", modelo= " + modelo + ", cliente= " + cliente
                + " Hora entrada= " + horaEntrada;
    }

} // Main

