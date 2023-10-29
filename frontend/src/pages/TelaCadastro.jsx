import React, {useEffect,useState} from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";

// Função para enviar o email de validação
function enviarEmailValidacao(email) {
  // Corpo da solicitação
  const data = {
    email: email
  };

  // Faz a solicitação POST para o endpoint biblioteca-gerenciamento/senha-codigo
  axios.post('http://localhost:8080/api/biblioteca-gerenciamento/senha-codigo', data)
    .then((response) => {
      // Lógica de tratamento de sucesso
      console.log('Email de validação enviado com sucesso', response);
    })
    .catch((error) => {
      // Lógica de tratamento de erro
      console.error('Erro ao enviar o email de validação', error);
    });
}

// função principal da página
function TelaCadastro() {

      // constante querecebe a biblioteca do db dando get
      const [biblioteca, setBiblioteca] = useState([]);
      
      // constante que atualiza a lista das bibliotecas
      const [atualizar,] = useState();

      const [bibliotecaSelecionado, setBibliotecaSelecionado] = useState({});

      // função  que obtém as bibliotecas do db dando get e armazena os dados na colouna
      useEffect(() => {
        axios.get("http://localhost:8080/api/biblioteca/").then((result) => {
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
            .post('http://localhost:8080/api/biblioteca/', bibliotecaSelecionado)
            .then((result) => {
              setBiblioteca([...biblioteca, result.data]);// Adicionar nova biblioteca ao estado  
              // Chame a função para enviar o email de validação com o email do usuário
              enviarEmailValidacao(result.data.email);   
            });
        } else {
          axios
            .put('http://localhost:8080/api/biblioteca/', bibliotecaSelecionado)
            .then((result) => {
              const updatedBiblioteca = biblioteca.map((objt) => {
                if (objt.id === result.data.id) {
                  return result.data;
                }
                return objt;
              });
              setBiblioteca(updatedBiblioteca); // Atualizar biblioteca específico no estado
            });
        }
        function limparFormulario() {
            setBibliotecaSelecionado({});
          }
          
        limparFormulario();
      }

    // Exibição da página com formulário para inserção dos dados para cadastro

    //input em formato de botão submit inseri os dados

    //TIRAR tabela retorna os dados do db com botão para alterar e exluir
  return (
      <div className="container"> <br/> <br/> 
    <span className="titlelogin">
      <div>
        <h3> CADASTRO DE USUÁRIO</h3>
        <h3> Informe os dados de usuário para registro</h3>
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
            <h6><Link className='btn btn-dark'to="/cadastro-senha">Cadastrar Senha</Link></h6>     
          </div>
        </form>
        <br/>
      </div>
    );
  }
  
  export default TelaCadastro;