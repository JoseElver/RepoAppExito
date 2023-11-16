package app.exito.stepDefinitions;

import app.exito.questions.ValidarUsuario;
import app.exito.tasks.InicioSesionTask;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static app.exito.userInterfaces.InicioSesionUI.LBL_NOMBRE_USUARIO;

public class InicioSesionStepDefinition {

    @Before
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^digita las credenciales de inicio de sesion$")
    public void digitaLasCredencialesDeInicioDeSesion() {
        OnStage.theActor("actor").attemptsTo(InicioSesionTask.on());
    }

    @Entonces("^valida que el nombre de usuario sea visible$")
    public void validaQueElNombreDeUsuarioSeaVisible(){
        Ensure.that(Text.of(LBL_NOMBRE_USUARIO).equals(ValidarUsuario.on()));
    }
}
