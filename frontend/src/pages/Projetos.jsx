import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { get, post } from '../services/api'

export default function Projetos() {
  const [projetos, setProjetos] = useState([])
  const [nome, setNome] = useState('')
  const [descricao, setDescricao] = useState('')

  useEffect(() => {
    carregar()
  }, [])

  function carregar() {
    get('/projetos').then(setProjetos)
  }

  function criar(e) {
    e.preventDefault()
    post('/projetos', { nome, descricao }).then(() => {
      setNome('')
      setDescricao('')
      carregar()
    })
  }

  return (
    <div>
      <h1>Projetos</h1>
      <form className="card" onSubmit={criar}>
        <div className="field">
          <label>Nome do projeto</label>
          <input value={nome} onChange={(e) => setNome(e.target.value)} />
        </div>
        <div className="field">
          <label>Descricao</label>
          <textarea value={descricao} onChange={(e) => setDescricao(e.target.value)} />
        </div>
        <button type="submit">Criar projeto</button>
      </form>

      <div className="grid">
        {projetos.map((p) => (
          <div className="card" key={p.id}>
            <h3>{p.nome}</h3>
            <p>{p.descricao}</p>
            <Link to={`/projetos/${p.id}`}>Ver tarefas</Link>
          </div>
        ))}
      </div>
    </div>
  )
}
