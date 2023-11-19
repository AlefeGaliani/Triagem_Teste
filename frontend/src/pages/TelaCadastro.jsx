import React, {useEffect,useState} from 'react';
import axios from "../axiosConfig.js";
import {Link} from "react-router-dom";


function enviarEmailValidacao(email) {

  const data = {
    email: email
  };


  axios.post('/api/biblioteca-gerenciamento/senha-codigo', data)
    .then((response) => {

      console.log('Email de validação enviado com sucesso', response);
    })
    .catch((error) => {

      console.error('Erro ao enviar o email de validação', error);
    });
}


function TelaCadastro() {

      const [biblioteca, setBiblioteca] = useState([]);
      

      const [atualizar,] = useState();

      const [bibliotecaSelecionado, setBibliotecaSelecionado] = useState({});

      useEffect(() => {
        axios.get("/api/biblioteca/").then((result) => {
          setBiblioteca(result.data);
        });
      }, [atualizar]);

      
    function hadleChangeBiblioteca(event) {
        setBibliotecaSelecionado({ ...bibliotecaSelecionado, [event.target.name]: event.target.value });
      }


    function handleSubmit(event) {
        event.preventDefault();
        if (bibliotecaSelecionado.id === undefined) {
          axios
            .post('/api/biblioteca/', bibliotecaSelecionado)
            .then((result) => {
              setBiblioteca([...biblioteca, result.data]);

              enviarEmailValidacao(result.data.email);   
            });
        } else {
          axios
            .put('/api/biblioteca/', bibliotecaSelecionado)
            .then((result) => {
              const updatedBiblioteca = biblioteca.map((objt) => {
                if (objt.id === result.data.id) {
                  return result.data;
                }
                return objt;
              });
              setBiblioteca(updatedBiblioteca); 
            });
        }
        function limparFormulario() {
            setBibliotecaSelecionado({});
          }
          
        limparFormulario();
      }


  return (
      <div className="container"> <br/> <br/> 
    <span className="titlelogin">
      <div>
        <h3> CADASTRO DE USUÁRIO</h3>
        <h4> Informe os dados de usuário para registro</h4>
        </div>
      </span>
        <form onSubmit={handleSubmit}>
          <div className="col-3">
            <div>
              <label className="form-label">Nome da Biblioteca:</label>
              <input onChange={hadleChangeBiblioteca} 
              value={bibliotecaSelecionado.nome || ''} 
              name="nome" type="text" className="form-control"/>
            </div>
            <div>
              <label className="form-label">Email de usuário:</label>
              <input onChange={hadleChangeBiblioteca} 
              value={bibliotecaSelecionado.email || ''} 
              name="email" type="text" className="form-control"/>
            </div>
            <br/> 
            <input type="submit" className="btn btn-dark" value="Registrar"></input>
            <br/> 
            <h6> Você receberá em seu email o código de validação para cadastrar sua senha:</h6>
            <br/> 
            <h5><Link className='btn btn-dark'to="/cadastro-senha">Cadastrar Senha</Link></h5>     
          </div>
        </form>
        <br/>
      </div>
    );
  }
  
  export default TelaCadastro;