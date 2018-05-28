public class Tester {

    public static void main(String[] args) {

        Estacionamento estacionamento = new Estacionamento();

        Cliente c1 = new Cliente("Mateus", "1234567", "999999999");
        Cliente c2 = new Cliente("Gustavo", "7654321", "888888888");
        Cliente c3 = new Cliente("Vitor", "67654567", "989898989");
        Cliente c4 = new Cliente("Cleverton", "6786888", "987878787");

        Veiculo v1 = new Motocicleta("akh1234", "Biz", c1);
        Veiculo v2 = new Motocicleta("bkh1234", "Biz", c2);
        Veiculo v3 = new Motocicleta("ckh1234", "Biz", c3);
        Veiculo v4 = new Motocicleta("kkh1234", "Biz", c4);

        Veiculo v5 = new Automovel("aghd3412", "SpaceFox", c2);
        Veiculo v6 = new Automovel("bkhh8909", "Gol", c3);
        Veiculo v7 = new Automovel("cghd3412", "SpaceFox", c2);
        Veiculo v8 = new Automovel("zkhh8909", "Gol", c3);

        System.out.println(estacionamento.qntVagasSobrando);

        estacionamento.estaciona(v1);
        estacionamento.estaciona(v2);
        estacionamento.estaciona(v3);
        //	estacionamento.estaciona(v4);
        //	estacionamento.estaciona(v1);
        //	estacionamento.estaciona(v2);
        //estacionamento.estaciona(v3);

        //estacionamento.estaciona(v7);
        estacionamento.estaciona(v8);
        
        
        System.out.println(estacionamento.qntVagasSobrando);

        estacionamento.listarVeiculos();
        System.out.println(estacionamento.qntVagasSobrando);

        //estacionamento.retira(v1);
        estacionamento.retira(v8);
        estacionamento.listarVeiculos();
        System.out.println(estacionamento.qntVagasSobrando);
    }
}
