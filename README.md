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

### 4.1.2 Requisição: Tomar medicamento medicamento
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
### 4.1.4 Requisição: Ler um medicamento (paciente)
    [GET]/paciente/medicamento/{id-medicamento}

### 4.1.5 Requisição: Alterar um medicamento (paciente)
    [PATCH]/paciente/medicamento/{id-medicamento}
```json

```

### 4.1.6 Requisição: Parar um medicamento (paciente)
    [PATCH]/paciente/medicamento/{id-medicamento}/parar
```json

```

### 4.1.7 Requisição: Remover um medicamento (paciente)
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

## 4.3 Controle de Consultas para Paciente
Endpoints:
* [GET] Listar médicos
* [GET] Listar um médico
* [GET] Listar vagas do médico
* [GET] Listar vagas de todos os médicos
* [POST] Agendar consulta
* [GET] Listar consultas
* [GET] Listar uma consulta
* [POST] Confirmar consulta (medico pediu para confirmar ultima chance de cancelar, não é apenas um lembrete)
* [POST] Confirmar alteracao de consulta (medico quer alterar data/hora ou cancelou)
* [PATCH] Alterar data/horario da consulta
* [DELETE] Cancelar consulta

### 4.3.1 Requisição: Listar médicos 
    [GET]/paciente/medico   
parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.3.2 Requisição: Listar um médico
    [GET]/paciente/medico/{id-medico}
### 4.3.3 Requisição: Listar vagas do médico
    [GET]/paciente/medico/{id-medico}/vagas
parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```
### 4.3.4 Requisição: Listar vagas de todos os médicos
    [GET]/paciente/medico/vagas
parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```
### 4.3.5 Requisição: Agendar consulta
    [POST]/paciente/medico/{id-medico}
```json
{

}
```
### 4.3.6 Requisição: Listar consultas
    [GET]/paciente/consulta
parametros:
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.3.7 Requisição: Listar uma consulta
    [GET]/paciente/consulta/{id-consulta}

### 4.3.8 Requisição: Confirmar consulta
    [POST]/paciente/consulta/{id-consulta}/confirmar

### 4.3.9 Requisição: Confirmar alteracao de consulta
    [POST]/paciente/consulta/{id-consulta}/confirmar/alteracao

### 4.3.10 Requisição: Alterar data/horario da consulta
    [PATCH]/paciente/consulta/{id-consulta}
```json
{

}
```

### 4.3.9 Requisição: Cancelar consulta
    [DELETE]/paciente/consulta/{id-consulta}



## 4.4 Controle de Consultas para Médico
Endpoints:
* [GET] Listar consultas
* [GET] Listar uma consulta
* [POST] Confirmar consulta (paciente pediu para agendar)
* [POST] Confirmar alteracao de consulta (paciente pediu para alterar)
* [PATCH] Alterar data/horario da consulta
* [DELETE] Cancelar consulta

### 4.4.1 Requisição:  Listar consultas
    [GET]/medico/consulta
parametros
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.4.2 Requisição:  Listar uma consulta
    [GET]/medico/consulta/{id-consulta}

### 4.4.3 Requisição:  Confirmar consulta (paciente pediu para agendar)
    [POST]/medico/consulta/{id-consulta}/confirmar

### 4.4.4 Requisição:  Confirmar alteracao de consulta (paciente pediu para alterar)
    [POST]/medico/consulta/{id-consulta}//confirmar/alteracao

### 4.4.5 Requisição: Alterar data/horario da consulta
    [PATCH]/medico/consulta/{id-consulta}
```json
{

}
```
### 4.4.6 Requisição:  Cancelar consulta
    [DELETE]/medico/consulta/{id-consulta}


## 4.5 Controle de cadastro de médicos
Endpoints:
* [POST] Inserir médico
* [GET] Listar médicos 
* [GET] Listar um médico
* [PUT] Alterar médico
* [DELETE] Remover médico
### 4.5.1 Requisição: Inserir médico
    [POST]/medico
```json
{

}
```
### 4.5.1 Requisição: Listar médicos 
    [GET]/medico
parametros
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```
### 4.5.1 Requisição: Listar um médico
    [GET]/medico/{id-medico}
### 4.5.1 Requisição: Alterar médico
    [PUT]/medico/{id-medico}
```json
{
    
}
```

### 4.5.1 Requisição: Remover médico 
    [DELETE]/medico/{id-medico}
    

## 4.6 Controle de cadastro de paciente
Endpoints:
* [POST] Inserir paciente
* [GET] Listar pacientes 
* [GET] Listar um paciente
* [PUT] Alterar paciente
* [DELETE] Remover paciente

### 4.6.1 Requisição: Inserir paciente
    [POST]/medico/consulta/{id-consulta}
```json
{

}
```

### 4.6.1 Requisição: Listar pacientes 
    [GET]/paciente
parametros
```
page int
count int
sort list<string> //nome campo
filter map<string, string> //nome campo : valor
```

### 4.6.1 Requisição: Listar um paciente
    [GET]/paciente/{id-paciente}

### 4.6.1 Requisição: Alterar paciente
    [PUT]/paciente/{id-paciente}
```json
{
    
}
```

### 4.6.1 Requisição: Remover paciente
    [DELETE]/paciente/{id-paciente}