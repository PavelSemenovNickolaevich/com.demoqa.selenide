package parameterized_tests.domain;

public enum Header {

    HEADER("Управление резюме");

    private String desc;

    Header(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
