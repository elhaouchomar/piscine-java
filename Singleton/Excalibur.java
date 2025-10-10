class Excalibur{
    private String name;
    private static Excalibur INSTANCE;

    public Excalibur() {
        this.name = "Sword";
    }

    private Excalibur(String name) {
        this.name = name;  
    }
    public String getName() {
        return name;
    }
    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }
        return INSTANCE;
    }
}