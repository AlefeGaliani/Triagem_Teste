import {Link} from "react-router-dom";


// função principal da página
function TelaIncial() {

 
  return (
  <div className="container"> <br/> <br/> <br/> <br/>
    <span className="titlelogin">
      <div>
        <h3> Bem vindo ao Biblio Manager! </h3>
        <h4> Seu sistema gerenciador de acervo literário </h4> 
      </div>
    </span>
    <table class="table">
      <tbody>
        <tr>
          <td>
              <h6><label className="form-label">Faça o login para acessar ao sistema:</label></h6>
          </td>
          <td><Link className='btn btn-dark'to="/login">Acessar</Link>  </td>
        </tr>
        <tr>
          <td>
              <h6><label className="form-label">Para novo usuário faça seu cadastro:</label></h6>                
          <br/>
          </td>
          <td><Link className='btn btn-dark'to="/cadastro">Cadastro</Link></td>
        </tr>
      </tbody>
    </table>    
  </div>
    );
  }

  
  export default TelaIncial;
