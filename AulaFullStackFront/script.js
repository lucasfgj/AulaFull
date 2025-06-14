const cadastrarUsuario = () => {
    const email = document.getElementById('email').value
    const senha = document.getElementById('senha').value
    const mensagem = document.getElementById('mensagem').value

    fetch('http://localhost:8080/usuarios', {
        method: 'POST',
        headers: {
            'content-Type': 'application/json'
        },
        body: JSON.stringify({email, senha})
    })
    .then(response => response.json().then(data=>({ status: response.status, bosy: data})))
    .then(({status, body}) =>{
        if(status >= 400){
            let erroMensagem = body.mensagem
            if(body.erros){
                erroMensagem += '' + Object.values(body.erros).join(', ')
            }
            mensagem.textContent = erroMensagem
            mensagem.classList.remove('sucesso')
            mensagem.classList.add('erro','visivel')
        }else{
            mensagem.textContent = body.mensagem || 'Usuario cadastrado com sucesso!!'
            mensagem.classList.remove('erro')
            mensagem.classList.add('sucesso', 'visivel')

            document.getElementById('cadastroForm').rest()
        }
        exibirMensagem()
    })
    .catch(() => {
        mensagem.textContent = 'Erro ao conectar ao servidor.';
        mensagem.classList.remove('Sucesso');
        mensagem.classList.add('erro', 'visivel');
        exibirMensagem();
    });
};

const exibirMensagem = () => {
    const mensagem = document.getElementById('mensagem');
    mensagem.classList.remove('oculto');
    setTimeout(() => fecharMensagem(), 5000);
};

const fecharMensagem = () => {
    const mensagem = document.getElementById('mensagem');
    mensagem.classList.remove('visivel');
    setTimeout(() => mensagem.classList.add('oculto'), 5000);
};