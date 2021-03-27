package com.eugeniojava.covid19vaccination.repository.result;

public class TotalVaccineTypeResult {

    private final Long id;
    private final String vaccine;
    private final Long total;

    public TotalVaccineTypeResult(Long id, String vaccine, Long total) {
        this.id = id;
        this.vaccine = vaccine;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public String getVaccine() {
        return vaccine;
    }

    public Long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "TotalVaccineTypeResult{" +
                "id=" + id +
                ", vaccine='" + vaccine + '\'' +
                ", total=" + total +
                '}';
    }
}
