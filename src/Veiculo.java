public abstract class Veiculo {

    protected String placa;
    protected String modelo;
    protected Cliente cliente;

    protected Veiculo(String placa, String modelo, Cliente cliente) {
        this.placa = placa;
        this.modelo = modelo;
        this.cliente = cliente;

    }

    protected abstract void estacionar(Veiculo veiculo, Estacionamento estacionamento);

    protected abstract void verificaDisponibilidade(Veiculo veiculo, Estacionamento estacionamento) throws Exception;

    protected abstract void retirar(Veiculo veiculo, Estacionamento estacionamento);

    protected abstract double calcularValorEstacionamento();

    public void listarVeiculos() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
