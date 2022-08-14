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
  <li>É anotada com @RestController ao invés de @Controller. Assim, ela permite não se use a anotação @ResponseBody em cada um de seus endpoints para indicar que o retorno não é uma referência a uma página.</li>
  <li>Acarretou na criação de uma classe e um respectivo pacote novos para DTOs (Data Transfer Objects). Esses objetos possuem apenas os dados que se deseja retornar no resultado de uma chamada ao endpoint, sem que haja a transmissão de atributos extra desnecessários.</li>
</ul>
<img src="/screenshots/topicosController1.png"/>
<h4>Usando Spring Data</h4>
<p>
  A fim de tornar o código mais dinâmico com um banco de dados e tomar proveito das facilidades disponibilizadas pelo Spring Data, algumas modificações foram feitas no projeto. O banco de dados escolhido para esse objetivo foi o  H2, que é um banco de dados em memória e possui implantação simples. Sendo assim, duas dependências adicionais foram adicionadas ao arquivo pom.xml, uma que diz respeito ao JPA, e outra referente ao banco de dados H2. Além disso, algumas configurações adicionais do banco de dados foram feitas no arquivo application.properties.
</p>
<p>
  Feitas as modificações, o primeiro passo para a utilização do banco de dados foi a criação da classe TopicoRepository, relativa à persistência de dados dos tópicos. Ela extende a interface JpaRepository, que já possui muitos métodos úteis para a manipulação de uma base de dados. Além disso, a criação de uma nova busca foi uma tarefa muito simples, já que estas podem ser implementadas automaticamente pelo Spring Data através da nomenclatura de métodos na interface seguindo determinado padrões. 
</p>
<img src="/screenshots/topicoRepository.png"/>
<p>
  Para utilizar esta nova interface no controller, ela foi declarada como um atributo da classe, anotado com @Autowired. Assim, o novo método de busca pode ser chamado sempre que uma requisição é feita para o endpoint.
</p>
<img src="/screenshots/topicosController2.png"/>

