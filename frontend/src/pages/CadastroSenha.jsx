import React, {useEffect,useState} from 'react';
import axios from "../axiosConfig.js";
import {Link} from "react-router-dom";


// função principal da página
function CadastroSenha() {

      // constante que recebe a biblioteca do db dando get
      const [biblioteca, setBiblioteca] = useState([]);
      
      // constante que atualiza a lista das bibliotecas
      const [atualizar,] = useState();

      const [bibliotecaSelecionado, setBibliotecaSelecionado] = useState({});

      // função  que obtém as bibliotecas do db dando get e armazena os dados na colouna
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
            .post('/api/biblioteca-gerenciamento/senha-alterar', bibliotecaSelecionado)
            .then((result) => {
              setBiblioteca([...biblioteca, result.data]);// Adicionar nova biblioteca ao estado  
            });
        } else {
          axios
            .put('/api/biblioteca-gerenciamento/senha-alterar', bibliotecaSelecionado)
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
      <div className="container"> <br/>  
    <span className="titlelogin">
      <div>
      <h3> CADASTRO DE SENHA</h3> 
       <h4> Informe seu e-mail e código de validação para cadastrar a senha</h4>
        </div>
      </span>
        <form onSubmit={handleSubmit}>
          <div className="col-3">
            <div>
              <label className="form-label">Email de usuário:</label>
              <input onChange={hadleChangeBiblioteca} 
              value={bibliotecaSelecionado.email || ''} 
              name="email" type="text" className="form-control"/>
            </div>
            <div>
              <label className="form-label">Código de Validação:</label>
              <input onChange={hadleChangeBiblioteca} 
              value={bibliotecaSelecionado.codigoRecuperacaoSenha || ''} 
              name="codigoRecuperacaoSenha" type="text" className="form-control"/>
            </div>
            <div>
              <label className="form-label">Senha:</label>
              <input onChange={hadleChangeBiblioteca} 
              value={bibliotecaSelecionado.senha || ''} 
              name="senha" type="password" className="form-control"/>
            </div>
            <br/> 
            <input type="submit" className="btn btn-dark" value="Cadastrar"></input>
                               
          </div>
        </form>
        <br/>  
        <table>
              <tbody>
                <tr>
                  <td>
                  <h6> Acesse o sistema: </h6>
                  </td>
                  <td>
                  <h6> <Link className='btn btn-dark'to="/login">Fazer Login</Link> </h6>
                  </td>                      
                </tr>
              </tbody>
        </table> <br/>  <br/>  <br/>  
      </div>
      
    );
  }
  
  export default CadastroSenha;