package Task2JavaLinux.toyshop.model;

public class Toy {
    /**
     * id игрушки
     */
    int idToy;
    /**
     * наименование игрушки
     */
    String nameToy;
    /**
     * количество игрушек
     */
    int quantToy;
    /**
     * вероятность выпадения игрушки в выигрыше
     */
    double pToy;
    /**
     * @param idToy - id игрушки
     * @param nameToy - наименование игрушки
     * @param quantToy - количество игрушек
     */
    public Toy(int idToy, String nameToy, int quantToy) {
        this.idToy = idToy;
        this.nameToy = nameToy;
        this.quantToy = quantToy;
    }
    /**
     * @return int id игрушки
     */
    public int getIdToy() {
        return idToy;
    }
    /**
     * @return String наименование игрушки
     */
    public String getNameToy() {
        return nameToy;
    }
    /**
     * @return int количество игрушек
     */
    public int getQuantToy() {
        return quantToy;
    }
    /**
     * @param quantToy - количество игрушек
     */
    public void setQuantToy(int quantToy) {
        this.quantToy = quantToy;
    }
    /**
     * @param pToy - вероятность выпадения игрушки в выигрыше
     */
    public void setPToy(double pToy) {
        this.pToy = pToy;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Toy) {
            Toy temp = (Toy) obj;
            return idToy == temp.idToy && nameToy == temp.nameToy;
        } else return false;
    }
    @Override
    public String toString() {
        return String.format("id=%d игрушка '%s', %d штук, вероятность выпадения в розыгрыше %.2f%%", 
                            idToy, nameToy, quantToy, pToy);
    }
}
