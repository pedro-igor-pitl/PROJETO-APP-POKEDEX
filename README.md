# Pokedex - Projeto App

Este projeto consiste no desenvolvimento de uma **Pokedex**, um aplicativo que permite aos usuários consultar informações sobre diversos Pokémon. O aplicativo fornecerá detalhes como tipos, nomes e descrições de cada Pokémon.

O projeto envolve o desenvolvimento de interfaces, gerenciamento de banco de dados (SQLite) e suporte à internacionalização.

## Funcionalidades do Projeto

O aplicativo contará com as seguintes funcionalidades principais:

### 1. **Activities**
- Criar as **activities** principais e secundárias conforme a regra de negócio.
- As **activities** serão responsáveis por exibir as informações detalhadas de cada Pokémon e permitir a navegação entre as diversas telas.

### 2. **Eventos de Toque**
- Implementar um gerenciador de **eventos de toque** (por exemplo, `onClickListener`) para interagir com os usuários.
- A interface será reativa, respondendo às ações do usuário de maneira fluida.

### 3. **Navegação entre Telas**
- Gerenciar transições entre telas usando **Intents**, proporcionando uma navegação clara e intuitiva dentro do aplicativo.
- O usuário poderá navegar facilmente entre as informações dos Pokémon e as listas de tipos e evoluções.

### 4. **Banco de Dados Local**
- Armazenar as informações dos Pokémon em um **banco de dados local** utilizando **SQLite**.
- Implementar uma funcionalidade que permita recuperar os dados gravados, garantindo persistência das informações durante o uso do aplicativo.

### 5. **Internacionalização**
- Adicionar suporte para **internacionalização** no aplicativo, permitindo que o usuário escolha entre diferentes idiomas (por exemplo, Português, Inglês, Espanhol).
- A ideia é tornar o aplicativo acessível para um público mais amplo, respeitando as diferenças culturais e linguísticas.

## Tecnologias Utilizadas

- **Android Studio**: Ambiente de desenvolvimento utilizado para criar o aplicativo.
- **SQLite**: Banco de dados local para armazenar informações dos Pokémon.
- **Java**: Linguagem utilizada para implementar a lógica do aplicativo.
- **XML**: Para a construção das interfaces gráficas (layouts).

## Como Executar o Projeto

1. Clone este repositório:

   ```bash
   git clone https://github.com/pedro-igor-pitl/PROJETO-APP-POKEDEX.git

2. Abra o projeto no Android Studio.

3. Conecte um dispositivo Android ou use o Emulador para rodar o aplicativo.

4. Compile e execute o projeto para visualizar o funcionamento do aplicativo.
