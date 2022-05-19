package entities;

import interfaces.Operacoes;

public class Salario implements Operacoes {

    private final Double SALARIO_MINIMO = 1193.37;
    // Critério 8.c
    private Double salarioBruto, horaExtra, bonus, salarioBrutoSomado;

    public Salario() {

    }

    public Salario(Double salarioBruto, Double horaExtra, Double bonus) {
        this.salarioBruto = salarioBruto;
        this.horaExtra = horaExtra;
        this.bonus = bonus;
        this.salarioBrutoSomado = salarioBruto + horaExtra + bonus;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(Double horaExtra) {
        this.horaExtra = horaExtra;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getSalarioBrutoSomado() {
        return salarioBrutoSomado;
    }

    public void setSalarioBrutoSomado(Double salarioBrutoSomado) {
        this.salarioBrutoSomado = salarioBrutoSomado;
    }

    @Override
    public double irpf() {
        if (salarioBruto <= 1903.98) {
            return 0;
        } else if (salarioBruto >= 1903.99 && salarioBruto <= 2826.65) {
            return salarioBruto * 0.075;
        } else if (salarioBruto >= 2826.66 && salarioBruto <= 3751.05) {
            return salarioBruto * 0.15;
        } else if (salarioBruto >= 3751.06 && salarioBruto <= 4664.68) {
            return salarioBruto * 0.225;
        } else {
            return salarioBruto * 0.275;
        }
    }

    @Override
    public double inss() {
        if (salarioBruto <= 1212.00) {
            return salarioBruto * 0.075;
        } else if (salarioBruto >= 1212.01 && salarioBruto <= 2427.35) {
            return salarioBruto * 0.09;
        } else if (salarioBruto >= 2427.36 && salarioBruto <= 3641.03) {
            return salarioBruto * 0.12;
        } else {
            return salarioBruto * 0.14;
        }

    }

    @Override
    public double valeTrasporte() {
        return salarioBruto * 0.06;
    }

    @Override
    public double valeRefeicao() {
        if (salarioBruto <= SALARIO_MINIMO) {
            return 0;
        } else {
            return salarioBruto * 0.03;
        }
    }

    @Override
    public double convenioMedico() {
        if (salarioBruto <= SALARIO_MINIMO) {
            return 0;
        } else {
            return salarioBruto * 0.04;
        }

    }

    @Override
    public double valeAlimentacao() {
        if (salarioBruto > SALARIO_MINIMO * 3) {
            return salarioBruto * 0.02;
        } else {

            return 0;

        }
    }

    public double totalDescontos() {
        return irpf() + inss() + valeTrasporte() + valeRefeicao() + convenioMedico() + valeAlimentacao();
    }

    public double salarioLiquidoSemBonus() {
        return salarioBruto - irpf() - inss() - valeTrasporte() - valeRefeicao() - convenioMedico() - valeAlimentacao();
    }

    public double salarioLiquidoComBonus() {
        return salarioBruto - irpf() - inss() - valeTrasporte() - valeRefeicao() - convenioMedico() - valeAlimentacao()
                + getBonus() + getHoraExtra();
    }

    @Override
    public String toString() {
        return "Salario [SALARIO_MINIMO=" + SALARIO_MINIMO + ", bonus=" + bonus + ", horaExtra=" + horaExtra
                + ", salarioBruto=" + salarioBruto + ", salarioBrutoSomado=" + salarioBrutoSomado + "]";
    }
}
