import React, { useState} from 'react';
import axios from 'axios';


function Login() {
  
  const [bibliotecaSelecionado, setBibliotecaSelecionado] = useState({ email: '', senha: '' });

  function handleChangeBiblioteca(event) {
    setBibliotecaSelecionado({ ...bibliotecaSelecionado, [event.target.name]: event.target.value });
  }

  function handleSubmit(event) {
    event.preventDefault();

    const { email, senha } = bibliotecaSelecionado;

    axios.post("http://localhost:8080/api/biblioteca/login", { email, senha })
      .then((response) => {
        if (response.data.success) {
          alert("Usuário ou senha inválidos.");
        } else {          
          window.location.href = "/home";           
        }
      })
      .catch((error) => {
        console.error("Erro ao fazer login:", error);
        alert("Usuário ou senha não identificado, por favor retorne à tela de cadastro.");
      });
  }

  return (
   <div className="container">
        <br />
        <br />
        <br />
        <br />
        <span className="titlelogin">
          <div>
            <h3>Seja bem vindo!</h3>
            <h3>Faça o login para acessar o sistema</h3>
          </div>
        </span>
        <form onSubmit={handleSubmit}>
          <div className="col-3">
            <div>
              <label className="form-label">Email:</label>
              <input
                onChange={handleChangeBiblioteca}
                value={bibliotecaSelecionado.email}
                name="email"
                type="text"
                className="form-control" />
            </div>
            <div>
              <label className="form-label">Senha:</label>
              <input
                onChange={handleChangeBiblioteca}
                value={bibliotecaSelecionado.senha}
                name="senha"
                type="password" /* Use type="password" para ocultar a senha */
                className="form-control" />
            </div>
            <br />
            <input type="submit" className="btn btn-dark" value="Acessar" />
          </div>
        </form>
        <br />
      </div>
  );
}

export default Login;
