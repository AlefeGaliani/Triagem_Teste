import styles from "./ConteudoTelaSenha.module.css";
import CadastroSenha from "../../pages/CadastroSenha";

function ConteudoTelaCadastro() {

    return (

        <section className={styles.conteudocadastrosenha}>
            <CadastroSenha />
        </section>
    );

}

export default ConteudoTelaCadastro;