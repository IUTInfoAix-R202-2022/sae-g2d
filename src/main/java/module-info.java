open module francefx {
    requires transitive javafx.base;
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.fxml;
    requires transitive org.kordamp.ikonli.javafx;
    requires transitive org.kordamp.ikonli.materialdesign;
    requires transitive org.kordamp.ikonli.core;

    requires jakarta.persistence;

    exports fr.univ_amu.iut.francefx;
    exports fr.univ_amu.iut.francefx.model;
}