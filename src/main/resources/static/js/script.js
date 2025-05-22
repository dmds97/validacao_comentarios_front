document.getElementById('loginForm').addEventListener('submit', async function (event) {
    event.preventDefault(); // impede recarregamento

    const nomeUsuario = document.getElementById('username').value;
    const senha = document.getElementById('password').value;

    if (!nomeUsuario || !senha) {
        alert('Preencha todos os campos.');
        return;
    }

    try {
        const response = await fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nomeUsuario, senha })
        });

        if (!response.ok) {
            throw new Error('Usuário ou senha inválidos');
        }

        const data = await response.json();
        localStorage.setItem('token', data.token); // salva o token no navegador

        alert('Login realizado com sucesso!');
        window.location.href = '/home';
    } catch (error) {
        alert(error.message);
    }
});
