const apiUrl = 'http://localhost:8080/comentarios'; // ajuste se a porta for diferente

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('comentarioForm');
    const lista = document.getElementById('listaComentarios');

    // Carrega os comentários existentes
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            data.forEach(c => adicionarComentarioNaTela(c));
        });

    // Envia um novo comentário
    form.addEventListener('submit', (e) => {
        e.preventDefault();

        const nome = document.getElementById('nome').value.trim();
        const texto = document.getElementById('texto').value.trim();

        if (!nome || !texto) return;

        fetch(apiUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ texto: `[${nome}] ${texto}` })
        })
            .then(res => res.json())
            .then(comentario => {
                adicionarComentarioNaTela(comentario);
                form.reset();
            });
    });

    function adicionarComentarioNaTela(comentario) {
        const li = document.createElement('li');
        li.textContent = `${comentario.texto} (${new Date(comentario.criadoEm).toLocaleString()})`;
        lista.prepend(li);
    }
});
