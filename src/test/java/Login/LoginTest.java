package Login;
import DatosLogin.DatosLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    Login login = new Login();
    DatosLogin datos = new DatosLogin();

    @Test
    void ValidacionCorrecta() {
        assertTrue(login.autenticar("walala", "ola123", datos));
    }

    @Test
    void UsuarioInexistente() {
        assertFalse(login.autenticar("wala","123123", datos));
    }

    @Test
    void ValidacionVacia() {
        assertFalse(login.autenticar("","", datos));
    }
    @Test
    void ContrasenaIncorrecta() {
        assertFalse(login.autenticar("walala", "123123123", datos));
    }
    @Test
    void txtMalo() {
        assertThrows(login.autenticar("walala", "ola123", datos));
    }

    private void assertThrows(boolean autenticar) {
    }

}