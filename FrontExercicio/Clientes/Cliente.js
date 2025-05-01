document.addEventListener('DOMContentLoaded', carregarUsuarios)

function carregarUsuarios(){
    fetch('http://localhost:8080/cliente')
    .then(response =>{
        if(!response.ok){
            throw new Error("Erro ao buscar usuario");
        }
        return response.json()
    })
    .then(usuarios => {
        const lista = document.getElementById('listaCliente')
        lista.innerHTML = ''
        
        if(usuarios.lenght === 0){
            lista.innerHTML = '<li>Nenhum usuário encontrado. </li>'
            return;
        }
        usuarios.forEach(usuarios => {
            const item = document.createElement('li')
            item.innerHTML = `<strong>Nome: </strong> ${usuarios.nome}<br> <strong>Telefone: </strong> ${usuarios.telefone}<br> <strong>E-mail: </strong> ${usuarios.email}`
            lista.appendChild(item)
        })

    })
    .catch( erro => {
        document.getElementById('listaUsuarios').innerHTML = '<li>Erro ao carregar Usuario</li>'
    })
}