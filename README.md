# Sistema de Gestao de Tarefas

## Como rodar

### Banco de dados (Postgres via Docker)
```
cd backend
docker compose up -d
```

### Backend (Spring Boot + Gradle + Java 25)
```
cd backend
./gradlew bootRun
```
API em `http://localhost:8081`.

### Frontend (React + Vite)
```
cd frontend
npm install
npm run dev
```
Frontend em `http://localhost:5174`.

## Atividade

Naveguem por Dashboard > Projetos > Detalhe do Projeto > Tarefas. Testem criar projeto,
criar tarefa, filtrar por status, excluir projeto com tarefas vinculadas, editar tarefa
com prazo vencido, etc. Anotem os bugs e melhorias que encontrarem.
