package parameterized_tests.domain;

public enum MenuFooterAndHeader {

    HEADER("Управление резюме"),
    FOOTER("Разработка Web приложения База данных резюме");

    private String desc;

    MenuFooterAndHeader(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
