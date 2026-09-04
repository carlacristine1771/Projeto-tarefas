import { useEffect, useState } from 'react'
import { get } from '../services/api'

export default function Dashboard() {
  const [tarefas, setTarefas] = useState([])

  useEffect(() => {
    get('/tarefas').then(setTarefas)
  }, [])

  const pendentes = tarefas.filter(t => t.status === 'PENDENTE').length
  const emAndamento = tarefas.filter(t => t.status === 'EM_ANDAMENTO').length
  const concluidas = tarefas.filter(t => t.status === 'CONCLUIDA').length

  return (
    <div>
      <h1>Painel de Tarefas</h1>
      <div className="grid">
        <div className="card"><div>Pendentes</div><div className="stat">{pendentes}</div></div>
        <div className="card"><div>Em andamento</div><div className="stat">{emAndamento}</div></div>
        <div className="card"><div>Concluidas</div><div className="stat">{concluidas}</div></div>
      </div>
    </div>
  )
}
