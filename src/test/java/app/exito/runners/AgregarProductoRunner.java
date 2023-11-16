package app.exito.runners;


import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/app.exito.features/agregar_producto.feature",
        glue = "app.exito.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class AgregarProductoRunner {
}
