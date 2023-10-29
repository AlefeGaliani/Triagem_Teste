import {Link} from "react-router-dom";


// função principal da página
function TelaIncial() {

 
  return (
      <div className="container"> <br/> <br/> <br/> <br/>
    
    <tbody>
      <tr>
        <td>
        <span className="titlelogin">
      <div>
        <h3> Bem vindo ao Biblio Manager!</h3>
        <h3> Seu sistema gerenciador de acervo literário</h3>
        </div>
      </span>
        <form onSubmit>
          <div className="col-3">
            <div>
              <h6><label className="form-label">Faça o login para acessar o sistema:</label></h6>
              <Link className='btn btn-dark'to="/login">Acessar</Link>  
              <br/><br/>
            </div>
            <div>
              <label className="form-label">Ou cadastre seu usuário:</label>
              <h6><Link className='btn btn-dark'to="/cadastro">Cadastro</Link></h6>
            </div>
          </div>
        </form>
        <br/>
        </td>
        <td>
          <p>O Biblio Manager é uma aplicação web desenvolvida para auxiliar a gestão de acervos
             literários em bibliotecas escolares, sebos e outros, visando simplificar o gerenciamento do fluxo literário 
             destas organizações. Este projeto foi desenvolvido para o Projeto Integrador II da Universidade Virtual
             do Estado de São Paulo (UNIVESP) baseando-se em uma pesquisa realizada com bibliotecas escolares, com o propósito 
             de facilitar e agilizar o gerenciamento destas organizações.</p>
        </td>
      </tr>
    </tbody>
    
      </div>
    );
  }

  
  export default TelaIncial;