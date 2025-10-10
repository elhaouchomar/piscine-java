class Excalibur{
    private String name;
    private Excalibur INSTANCE;
    private Excalibur(String name) {
        this.name = name;  
    }
    public String getName() {
        return name;
    }
    public Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Excalibur");
        }
        return INSTANCE;
    }
}