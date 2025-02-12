# Kitchen Dashboard

O **Kitchen Dashboard** é um gerenciador de insumos de cozinha desenvolvido de forma **fullstack**, com **React** no frontend e **Spring Boot** no backend. Este projeto foi criado para gerenciar o estoque de insumos de cozinha de forma eficiente e simples.

O sistema também utiliza **Docker** e **Docker Compose** para criar um ambiente de desenvolvimento isolado e facilitar a execução do projeto.

---

## Tecnologias utilizadas

- **Frontend:** React
- **Backend:** Spring Boot
- **Banco de Dados:** PostgreSQL
- **Containers:** Docker e Docker Compose

---

## Funcionalidades

- Cadastro e controle de insumos de cozinha
- Exibição de estoque e validade dos itens
- Interface amigável e fácil de usar
- Ambiente de desenvolvimento isolado via Docker

---

## Como rodar o projeto

### Pré-requisitos

- **Docker** e **Docker Compose** instalados em sua máquina
- **Java 11+** para o backend Spring Boot (caso queira rodar separadamente sem Docker)
- **Node.js** e **pnpm** para o frontend React (caso queira rodar separadamente sem Docker)
- **PostgreSQL** para o banco de dados (configurado no Docker Compose)

### Passo a Passo

1. Clone este repositório:

   ```bash
   git clone https://github.com/SeuUsuario/kitchen-dashboard.git
   cd kitchen-dashboard
   ```

2. Rode o ambiente com Docker Compose (backend, frontend e PostgreSQL juntos):

   No diretório raiz do projeto, execute o seguinte comando para iniciar o ambiente de desenvolvimento:

   ```bash
   docker-compose -f docker-compose.dev.yml up --build
   ```

   Isso irá construir e iniciar os containers do backend, frontend e o PostgreSQL. O projeto estará disponível em:

   - **Frontend:** `http://localhost:3000`
   - **Backend (API):** `http://localhost:8080`

3. Caso prefira rodar o backend ou frontend separadamente:

   - **Backend**: No diretório `backend`, execute:

     ```bash
     ./mvnw spring-boot:run
     ```

   - **Frontend**: No diretório `frontend`, execute:

     ```bash
     pnpm install
     pnpm run dev
     ```

---

## Estrutura do Projeto

- **backend/**: Código fonte do backend (Spring Boot)
- **frontend/**: Código fonte do frontend (React)
- **docker-compose.yml**: Arquivo de configuração do Docker Compose
- **Dockerfile**: Arquivo de configuração para criação do container do backend
- **frontend/Dockerfile**: Arquivo de configuração para criação do container do frontend

---

## Contribuições

Contribuições são bem-vindas! Para contribuir, siga os seguintes passos:

1. Fork o repositório
2. Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`)
3. Faça as modificações necessárias
4. Commit suas mudanças (`git commit -am 'Adicionando nova funcionalidade'`)
5. Push na branch (`git push origin feature/nova-funcionalidade`)
6. Abra um Pull Request

---

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

