# mensageria_com_kafka


Este projeto utiliza um producer e dois consumers conectados ao Kafka via Spring Cloud Stream, o que garante um excelente desacoplamento tecnológico. Na prática, isso facilita muito a troca entre diferentes brokers de mensagens sem mexer no código, bastando ajustar as configurações no application.yml.
Além disso, o projeto aproveita as Virtual Threads do Java 21, o que permite uma escalabilidade horizontal enorme. Diferente do modelo tradicional de threads por requisição, as threads virtuais eliminam o gargalo de I/O, permitindo que o sistema processe milhares de eventos simultâneos com um consumo mínimo de memória e CPU

***
### para rodar

`git clone https://github.com/Romariolima1998/mensageria_com_kafka.git`

abra a pasta mensageria_com_kafka

abra o arquivo application.yml e adicione o email e sua senha de app

`docker compose up --build`

***

<img style="display: block;-webkit-user-select: none;margin: auto;cursor: zoom-in;background-color: hsl(0, 0%, 90%);transition: background-color 300ms;" src="https://raw.githubusercontent.com/Romariolima1998/mensageria_com_kafka/refs/heads/main/messsageria.png" width="885" height="446">

***
link no seu pc para o swagger: `http://localhost:8080/swagger-ui/index.html#/agendador%20de%20email/agendar`

link para api: POST ` http://localhost:8080/mensagem `

entrada: 
```
{
  "remetente": "string",
  "destinatario": "user@example.com",
  "assunto": "string",
  "corpo": "string"
}
```
saida:

status code: 202

` email agendado `
