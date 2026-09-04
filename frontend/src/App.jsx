import { Routes, Route } from 'react-router-dom'
import Dashboard from './pages/Dashboard.jsx'
import Projetos from './pages/Projetos.jsx'
import DetalheProjeto from './pages/DetalheProjeto.jsx'
import FormTarefa from './pages/FormTarefa.jsx'

function App() {
  return (
    <div>
      <nav>
        <a href="/">Dashboard</a>
        <a href="/projetos">Projetos</a>
      </nav>
      <div className="container">
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/projetos" element={<Projetos />} />
          <Route path="/projetos/:id" element={<DetalheProjeto />} />
          <Route path="/projetos/:projetoId/tarefas/nova" element={<FormTarefa />} />
          <Route path="/tarefas/:id/editar" element={<FormTarefa />} />
        </Routes>
      </div>
    </div>
  )
}

export default App
