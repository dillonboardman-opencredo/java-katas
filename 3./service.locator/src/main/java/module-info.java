import com.opencredo.dillonboardman.kata.service.provider.api.FileSort;

module com.opencredo.kata.service.locator {
    exports com.opencredo.dillonboardman.kata.service.locator;
    requires com.opencredo.kata.service.provider.api;
    uses FileSort;
}