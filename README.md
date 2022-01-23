# Countries API

Desenvolvida usando spring-boot e H2 Database In Memory (Os dados serão perdidos assim que reiniciar a API).


- ##### CRUD de províncias que serão as capitais - /api/v1/provinces - Para acesso necessita autenticação


- ##### CRUD de países - /api/v1/countries - Autenticação necessária

- ##### Segurança da App usando Spring Security
Para garantir a segurança da aplicação
Username: admin
Password: secret

Credenciais usadas para gerar o token de acesso 
Rota para gerar o token: 
Method: POST
Rota: api/v1/auth
Body: 
    {
        "username":"admin",
        "password":"secret"
    }

Para cada request deve ser enviado o token no cabeçalho com
Authorization: [token gerado na request anterior]

Usando o swagger, basta apenas colocar o token no campo authorize apresentado pela interface do swagger.

Foi usado o `flyway db` é uma ferramenta que se permite garantir a ordem e organização para os scripts SQL que são executados na base de dados, garantindo o controle de versão dos mesmos.

## Como executar?

- `cd country-api`
- `mvnw clean install -DskipTests`
- `java -jar target/country-api-0.0.1-SNAPSHOT.jar`

A partir deste momento, seguindo corretamente os passos terá a aplicação correndo no endereço `http://localhost:8080`

NB:
Poderá encontrar uma documentação mais interativa da API no endereço `http://localhost:8080/swagger-ui/`

## Alternativa para executar

- `cd country-api`
- `docker build -f Dockerfile -t api/country-api .`
- `docker run -d -p 8080:8080 api/country-api`

Permite executar criando um container docker