<h2>Spring Boot</h2>
<p>
O objetivo deste trabalho é estudar o Framework Spring Boot, muito popular no mundo Java atualmente. As facilidades promovidas por ele na criação e configuração de projetos otimizam a produtividade do desenvolvedor, o que coincide com a tendência contemporânea de divisão de código em vários serviços e é um dos seus principais chamativos.
</p>
<p>
  O estudo será feito através de um curso de Spring Boot na plataforma de cursos web Alura. Nele, será desenvolvida uma pequena API REST. Mais informações sobre o curso podem ser encontradas <a href="https://cursos.alura.com.br/course/spring-boot-api-rest" target="_blank">aqui</a>.
</p>
<h4>Hello World</h4>
<p>
A criação do projeto Spring Boot foi feita através do site <a href="https://start.spring.io/" target="_blank">Spring Initializr</a>, em que podem ser feitas várias configurações facilmente, incluindo a adição de dependências no projeto. Depois de configurar o projeto na interface do site, basta baixá-lo como arquivo compactado.
</p>
  <img src="/screenshots/initializr.png"/>
<p>
Uma vez descompactado, o projeto foi importado na IDE IntelliJ IDEA, por onde foram adicionados a classe HelloController e um pacote para abrigá-la. A classe é responsável por conter métodos que lidam com requições web a endereços específicos (endpoints). 
</p>
  <img src="/screenshots/helloController.png"/>
<p>
  Portanto, uma vez que se rode o projeto através de seu servidor TomCat embutido, torna-se possível acessar o endereço <i>http://localhost:8080/</i> e visualizar o famoso "Hello World!".
 </p>
  <img src="/screenshots/helloWorld.png"/>
<h4>Publicando endpoints</h4>
<p>
   Em seguida, iniciou-se o desenvolvimento de novos endpoints para a aplicação. Os primeiros foram referentes a Tópicos e, portanto, ficam localizados na nova classe chamada TopicosController. Essa classe se diferencia da primeira classe criada em alguns pontos:
</p>
<ul>
  <li>É anotada com @RestController ao invés de @Controller. Assim, ela permite não usar a anotação @ResponseBody em cada um de seus endpoints para indicar que o retorno não é uma referência a uma página.</li>
  <li>Acarretou na criação de uma classe e um respectivo pacote novos para DTOs (Data Transfer Objects). Esses objetos possuem apenas os dados que se deseja retornar no resultado de uma chamada ao endpoint, sem que haja a transmissão de atributos extra desnecessários.</li>
</ul>
<img src="/screenshots/topicosController1.png"/>
