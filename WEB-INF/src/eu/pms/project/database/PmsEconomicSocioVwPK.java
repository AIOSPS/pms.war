package eu.pms.project.database;

import java.io.Serializable;

/**
 * Created by orayyan on 1/27/2017.
 */
public class PmsEconomicSocioVwPK implements Serializable{
    private String ecoId;
    private String comId;

    public PmsEconomicSocioVwPK() {
    }

    public String getEcoId() {
        return ecoId;
    }

    public void setEcoId(String ecoId) {
        this.ecoId = ecoId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PmsEconomicSocioVwPK that = (PmsEconomicSocioVwPK) o;

        if (!ecoId.equals(that.ecoId)) return false;
        return comId.equals(that.comId);
    }

    @Override
    public int hashCode() {
        int result = ecoId.hashCode();
        result = 31 * result + comId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PmsEconomicSocioVwPK{" +
                "ecoId='" + ecoId + '\'' +
                ", comId='" + comId + '\'' +
                '}';
    }
}
