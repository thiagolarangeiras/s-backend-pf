# satc-backend-projeto-final

# Tema:  
    Saúde e Bem-estar: Gerenciamento de Medicamentos, Mapeamento de Atendimentos Médicos, Recomendações Médicas

# 1 Funcionalidades Gerais:
O que o sistema ira ter em uma visão geral de funcionalidades

## 1.1 Gerenciamento de Medicamentos:
* Lembretes para tomar medicamentos
* Rastreamento de adesão ao tratamento
* Alerta para interações com tipos de medicamentos

## 1.2 Mapeamento de Atendimentos Médicos:
* Registro de visitas médicas
* Análise de padrões de atendimento
* Sugestões de otimização de recursos médicos
* Sugestões de médicos e retornos
* Direcionamento para médicos especializados 
    
## 1.3 Recomendações Médicas:
* Sugestões personalizadas com base no histórico médico do paciente
* Análise preditiva para antecipar necessidades futuras
* monitoramento contínuo.

# 2 Funcionalidades Descritivas:
Funcionalidades e ações que cada papel pode fazer ou receber
## 2.1 Ações do paciente
### 2.1.1 Ações
* Cadastrar medicamentos
* Marcar quando tomou o remédio
* Marcar consulta com médico
* Marcar exame
### 2.1.1 receber
* Notificação de quando tomar o remédio
* Se o remédio tem alguma contra indicação
* Se o remédio causa alguma reação com outro remédio
* Lembrete de consulta 
* Indicação envida pelo médico
* Resultado da consulta
* Resultado do exame

## 2.2 Ações do médico
### 2.1.1 Ações
* Cadastrar medicamentos para paciente
* Criar um resultado da consulta 
* Marcar um exame para paciente
* Criar resultado para exame (arquivos, laudos, etc..)
### 2.1.1 receber
* Lembrete de consulta
* Verificar quais remédios o paciente tomou
* Verificar resultado de exames

## 2.3 Ações da administração/hospital
### 2.1.1 Ações
* cadastrar médico
* cadastrar paciente
* alterar dados da conta de médico e paciente conforme a necessidade


Se o medicamento não tiver fim definido ou não acabou ainda marcar como desativado para sinalizar como para

# 3 Tecnologias

# 4 Detalhamento da API
## 4.1 Controle de medicamentos para Paciente
Endpoints:
* [POST] Inserir novo medicamento
* [POST] Tomou o remedio
* [GET] Listar todos os medicamentos
* [GET] Listar um medicamentos
* [PATCH] Alterar Dados de um medicamento (data, hora, quantidade)
* [PATCH] Marcar que parou de tomar
* [DELETE] Remover um medicamento (se ele já tomou algum ainda fica salvo, deleleta ou marca como cancelado oq poder)

### 4.1.1 Requisição: Inserir medicamento (Paciente)
    [POST]/paciente/remedio
```json
{
}
```

### 4.1.3 Requisição: Tomar medicamento medicamento
[POST]/paciente/medicamento/{id-medicamento}/tomar
```json
{
}
```

### 4.1.3 Requisição: Ler medicamentos (paciente)
    [GET]/paciente/medicamento?   
Parametros:
```
page int
count int
sort list<string>
filter map<string, string>
```
### 4.1.5 Requisição: Ler um medicamento (paciente)
    [GET]/paciente/medicamento/{id-medicamento}

### 4.1.7 Requisição: Alterar um medicamento (paciente)
    [PATCH]/paciente/medicamento/{id-medicamento}
```json

```

### 4.1.9 Requisição: Parar um medicamento (paciente)
    [PATCH]/paciente/medicamento/{id-medicamento}/parar
```json

```

### 4.1.11 Requisição: Remover um medicamento (paciente)
    [PATCH]/paciente/medicamento/{id-medicamento}
```json

```

## 4.2 Controle de medicamentos para médico
Endpoints:
* [POST] Inserir novo medicamento
* [GET] Listar todos os medicamentos
* [GET] Listar um medicamentos
* [PATCH] Alterar Dados de um medicamento (data, hora, quantidade)
* [PATCH] Marcar que parou de tomar
* [DELETE] Remover um medicamento (se ele já tomou algum ainda fica salvo, deleleta ou marca como cancelado oq poder)

### 4.2.1 Requisição: Inserir medicamento (médico)
[POST]/medico/{id-paciente}/medicamento
```json
{
}
```

### 4.2.2 Requisição: Ler medicamentos (médico)
    [GET]/medico{id-paciente}/medicamento?   
Parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.2.3 Requisição: Ler um medicamento (médico)
    [GET]/medico/{id-paciente}/medicamento/{id-medicamento}

### 4.2.4 Requisição: Alterar um medicamento (médico)
    [PATCH]/medico/{id-paciente}/medicamento/{id-medicamento}
```json
```

### 4.2.5 Requisição: Parar um medicamento (médico)
    [PATCH]/medico/{id-paciente}/medicamento/{id-medicamento}/parar
```json

```

### 4.2.5 Requisição: Remover um medicamento (médico)
    [PATCH]/medico/{id-paciente}/medicamento/{id-medicamento}
```json

```

## 4.2 Controle de Consultas para Paciente
Endpoints:
* [GET] Listar médicos
* [GET] Listar um médico
* [GET] Listar vagas do médico
* [GET] Listar vagas de todos os médicos
* [POST] Agendar consulta
* [GET] Listar consultas
* [GET] Listar uma consulta
* [PATCH] Alterar data/horario da consulta
* [DELETE] Cancelar consulta

### 4.2.1 Requisição: Listar Medicos

### 4.2.2
### 4.2.3
### 4.2.4
### 4.2.5
### 4.2.6
### 4.2.7
### 4.2.8
### 4.2.9
