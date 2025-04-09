document.getElementById("login-form").addEventListener("submit", async (event) => {
    event.preventDefault();
  
    const nomeDeUsuario = document.getElementById("nomeDeUsuario").value;
    const senha = document.getElementById("senha").value;

    const response = await fetch("http://localhost:8080/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ nomeDeUsuario, senha }),
    });
  
    if (response.ok) {
      alert("Login bem-sucedido!");
    } else {
      alert("Erro no login. Verifique as credenciais.");
    }
  });