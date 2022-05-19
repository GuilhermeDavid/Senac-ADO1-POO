package entities;
//Critério 8.a
public class Funcionario extends Salario {

    private String nome;

    public Funcionario() {

    }

    public Funcionario(Double salarioBruto, Double horaExtra, Double bonus, String nome) {
        super(salarioBruto, horaExtra, bonus);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\t\t\t*HOLERITE*\nNome do Funcionario: " + nome + 
        "\nSalário Bruto: R$" + String.format("%.2f", getSalarioBruto()) +
        "\nDesconto IRPF: R$" +  String.format("%.2f",irpf()) +
        "\nDesconto INSS: R$" +  String.format("%.2f",inss()) +
        "\nDesconto do vale transporte: R$" +  String.format("%.2f",valeTrasporte()) +
        "\nDesconto do vale refeição: R$" +  String.format("%.2f",valeRefeicao()) + 
        "\nDesconto do convênio médico: R$" +  String.format("%.2f",convenioMedico()) +
        "\nDesconto do vale alimentação: R$" +  String.format("%.2f",valeAlimentacao()) +
        "\n\nTotal dos descontos: R$" +  String.format("%.2f",totalDescontos()) +
        "\nSalário liquido sem bônus e hora extra: R$" +  String.format("%.2f",salarioLiquidoSemBonus()) + 
        "\n\nHora extra: R$" +  String.format("%.2f",getHoraExtra()) +
        "\nBônus: R$" +  String.format("%.2f",getBonus()) +
        "\n\nSalário Liquido com bônus e hora extra: R$" +  String.format("%.2f",salarioLiquidoComBonus());
    }
}
